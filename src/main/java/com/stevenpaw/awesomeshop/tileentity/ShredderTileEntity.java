package com.stevenpaw.awesomeshop.tileentity;

import com.stevenpaw.awesomeshop.blocks.Shredder;
import com.stevenpaw.awesomeshop.container.ShredderContainer;
import com.stevenpaw.awesomeshop.init.StartupCommon;
import com.stevenpaw.awesomeshop.util.enums.SetBlockStateFlag;
import com.stevenpaw.awesomeshop.util.ShredderStateData;
import com.stevenpaw.awesomeshop.util.ShredderZoneContents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;

public class ShredderTileEntity extends TileEntity implements INamedContainerProvider, ITickableTileEntity{
    public static final int FUEL_SLOTS_COUNT = 1;
    public static final int INPUT_SLOTS_COUNT = 1;
    public static final int OUTPUT_SLOTS_COUNT = 1;
    public static final int TOTAL_SLOTS_COUNT = FUEL_SLOTS_COUNT + INPUT_SLOTS_COUNT + OUTPUT_SLOTS_COUNT;

    private ShredderZoneContents fuelZoneContents;
    private ShredderZoneContents inputZoneContents;
    private ShredderZoneContents outputZoneContents;

    private final ShredderStateData shredderStateData = new ShredderStateData();

    public ShredderTileEntity(){
        super(StartupCommon.shredderTileEntity);
        fuelZoneContents = ShredderZoneContents.createForTileEntity(FUEL_SLOTS_COUNT,
                this::canPlayerAccessInventory, this::markDirty);
        inputZoneContents = ShredderZoneContents.createForTileEntity(INPUT_SLOTS_COUNT,
                this::canPlayerAccessInventory, this::markDirty);
        outputZoneContents = ShredderZoneContents.createForTileEntity(OUTPUT_SLOTS_COUNT,
                this::canPlayerAccessInventory, this::markDirty);
    }

    // Return true if the given player is able to use this block. In this case it checks that
    // 1) the world tileentity hasn't been replaced in the meantime, and
    // 2) the player isn't too far away from the centre of the block
    public boolean canPlayerAccessInventory(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) return false;
        final double X_CENTRE_OFFSET = 0.5;
        final double Y_CENTRE_OFFSET = 0.5;
        final double Z_CENTRE_OFFSET = 0.5;
        final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
        return player.getDistanceSq(pos.getX() + X_CENTRE_OFFSET, pos.getY() + Y_CENTRE_OFFSET, pos.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
    }

    /**
     * Get the number of slots which have fuel burning in them.
     * @return number of slots with burning fuel, 0 - FUEL_SLOTS_COUNT
     */
    public int numberOfBurningFuelSlots()	{
        int burningCount = 0;
        for (int burnTime : shredderStateData.burnTimeRemainings) {
            if (burnTime > 0) ++burningCount;
        }
        return burningCount;
    }

    // This method is called every tick to update the tile entity, i.e.
    // - see if the fuel has run out, and if so turn the furnace "off" and slowly uncook the current item (if any)
    // - see if the current smelting input item has finished smelting; if so, convert it to output
    // - burn fuel slots
    // It runs both on the server and the client but we only need to do updates on the server side.
    @Override
    public void tick() {
        if (world.isRemote) return; // do nothing on client.
        ItemStack currentlySmeltingItem = getCurrentlySmeltingInputItem();

        // if user has changed the input slots, reset the smelting time
        if (!ItemStack.areItemsEqual(currentlySmeltingItem, currentlySmeltingItemLastTick)) {  // == and != don't work!
            shredderStateData.shredderTimeElapsed = 0;
        }
        currentlySmeltingItemLastTick = currentlySmeltingItem.copy();

        if (!currentlySmeltingItem.isEmpty()) {
            int numberOfFuelBurning = burnFuel();

            // If fuel is available, keep cooking the item, otherwise start "uncooking" it at double speed
            if (numberOfFuelBurning > 0) {
                shredderStateData.shredderTimeElapsed += numberOfFuelBurning;
            }	else {
                shredderStateData.shredderTimeElapsed -= 2;
            }
            if (shredderStateData.shredderTimeElapsed < 0) shredderStateData.shredderTimeElapsed = 0;

            int cookTimeForCurrentItem = getCookTime(this.world, currentlySmeltingItem);
            shredderStateData.shredderTimeForCompletion = cookTimeForCurrentItem;
            // If cookTime has reached maxCookTime smelt the item and reset cookTime
            if (shredderStateData.shredderTimeElapsed >= cookTimeForCurrentItem) {
                smeltFirstSuitableInputItem();
                shredderStateData.shredderTimeElapsed = 0;
            }
        }	else {
            shredderStateData.shredderTimeElapsed = 0;
        }

        // when the number of burning slots changes, we need to force the block to re-render, otherwise the change in
        //   state will not be visible.  Likewise, we need to force a lighting recalculation.
        // The block update (for renderer) is only required on client side, but the lighting is required on both, since
        //    the client needs it for rendering and the server needs it for crop growth etc
        int numberBurning = numberOfBurningFuelSlots();
        BlockState currentBlockState = world.getBlockState(this.pos);
        BlockState newBlockState = currentBlockState.with(Shredder.BURNING_SIDES_COUNT, numberBurning);
        if (!newBlockState.equals(currentBlockState)) {
            final int FLAGS = SetBlockStateFlag.get(SetBlockStateFlag.BLOCK_UPDATE, SetBlockStateFlag.SEND_TO_CLIENTS);
            world.setBlockState(this.pos, newBlockState, FLAGS);
            markDirty();
        }
    }

    /**
     * 	for each fuel slot: decreases the burn time, checks if burnTimeRemainings = 0 and tries to consume a new piece of fuel if one is available
     * @return the number of fuel slots which are burning
     */
    private int burnFuel() {
        int burningCount = 0;
        boolean inventoryChanged = false;

        for (int fuelIndex = 0; fuelIndex < FUEL_SLOTS_COUNT; fuelIndex++) {
            if (shredderStateData.burnTimeRemainings[fuelIndex] > 0) {
                --shredderStateData.burnTimeRemainings[fuelIndex];
                ++burningCount;
            }

            if (shredderStateData.burnTimeRemainings[fuelIndex] == 0) {
                ItemStack fuelItemStack = fuelZoneContents.getStackInSlot(fuelIndex);
                if (!fuelItemStack.isEmpty() && getItemBurnTime(this.world, fuelItemStack) > 0) {
                    // If the stack in this slot isn't empty and is fuel, set burnTimeRemainings & burnTimeInitialValues to the
                    // item's burn time and decrease the stack size
                    int burnTimeForItem = getItemBurnTime(this.world, fuelItemStack);
                    shredderStateData.burnTimeRemainings[fuelIndex] = burnTimeForItem;
                    shredderStateData.burnTimeInitialValues[fuelIndex] = burnTimeForItem;
                    fuelZoneContents.decrStackSize(fuelIndex, 1);
                    ++burningCount;
                    inventoryChanged = true;

                    // If the stack size now equals 0 set the slot contents to the item container item. This is for fuel
                    // item such as lava buckets so that the bucket is not consumed. If the item dose not have
                    // a container item, getContainerItem returns ItemStack.EMPTY which sets the slot contents to empty
                    if (fuelItemStack.isEmpty()) {
                        ItemStack containerItem = fuelItemStack.getContainerItem();
                        fuelZoneContents.setInventorySlotContents(fuelIndex, containerItem);
                    }
                }
            }
        }
        if (inventoryChanged) markDirty();
        return burningCount;
    }

    /**
     * Check if any of the input item are smeltable and there is sufficient space in the output slots
     * @return the ItemStack of the first input item that can be smelted; ItemStack.EMPTY if none
     */
    private ItemStack getCurrentlySmeltingInputItem() {return smeltFirstSuitableInputItem(false);}

    /**
     * Smelt an input item into an output slot, if possible
     */
    private void smeltFirstSuitableInputItem() {
        smeltFirstSuitableInputItem(true);
    }

    /**
     * checks that there is an item to be smelted in one of the input slots and that there is room for the result in the output slots
     * If desired, performs the smelt
     * @param performSmelt if true, perform the smelt.  if false, check whether smelting is possible, but don't change the inventory
     * @return a copy of the ItemStack of the input item smelted or to-be-smelted
     */
    private ItemStack smeltFirstSuitableInputItem(boolean performSmelt)
    {
        Integer firstSuitableInputSlot = null;
        Integer firstSuitableOutputSlot = null;
        ItemStack result = ItemStack.EMPTY;

        // finds the first input slot which is smeltable and whose result fits into an output slot (stacking if possible)
        for (int inputIndex = 0; inputIndex < INPUT_SLOTS_COUNT; inputIndex++)	{
            ItemStack itemStackToSmelt = inputZoneContents.getStackInSlot(inputIndex);
            if (!itemStackToSmelt.isEmpty()) {
                result = getSmeltingResultForItem(this.world, itemStackToSmelt);
                if (!result.isEmpty()) {
                    // find the first suitable output slot- either empty, or with identical item that has enough space
                    for (int outputIndex = 0; outputIndex < OUTPUT_SLOTS_COUNT; outputIndex++) {
                        if (willItemStackFit(outputZoneContents, outputIndex, result)) {
                            firstSuitableInputSlot = inputIndex;
                            firstSuitableOutputSlot = outputIndex;
                            break;
                        }
                    }
                    if (firstSuitableInputSlot != null) break;
                }
            }
        }

        if (firstSuitableInputSlot == null) return ItemStack.EMPTY;

        ItemStack returnvalue = inputZoneContents.getStackInSlot(firstSuitableInputSlot).copy();
        if (!performSmelt) return returnvalue;

        // alter input and output
        inputZoneContents.decrStackSize(firstSuitableInputSlot, 1);
        outputZoneContents.increaseStackSize(firstSuitableOutputSlot, result);

        markDirty();
        return returnvalue;
    }

    /**
     * Will the given ItemStack fully fit into the target slot?
     * @param shredderZoneContents
     * @param slotIndex
     * @param itemStackOrigin
     * @return true if the given ItemStack will fit completely; false otherwise
     */
    public boolean willItemStackFit(ShredderZoneContents shredderZoneContents, int slotIndex, ItemStack itemStackOrigin) {
        ItemStack itemStackDestination = shredderZoneContents.getStackInSlot(slotIndex);

        if (itemStackDestination.isEmpty() || itemStackOrigin.isEmpty()) {
            return true;
        }

        if (!itemStackOrigin.isItemEqual(itemStackDestination)) {
            return false;
        }

        int sizeAfterMerge = itemStackDestination.getCount() + itemStackOrigin.getCount();
        if (sizeAfterMerge <= shredderZoneContents.getInventoryStackLimit() && sizeAfterMerge <= itemStackDestination.getMaxStackSize()) {
            return true;
        }
        return false;
    }

    // returns the smelting result for the given stack. Returns ItemStack.EMPTY if the given stack can not be smelted
    public static ItemStack getSmeltingResultForItem(World world, ItemStack itemStack) {
        Optional<FurnaceRecipe> matchingRecipe = getMatchingRecipeForInput(world, itemStack);
        if (!matchingRecipe.isPresent()) return ItemStack.EMPTY;
        return matchingRecipe.get().getRecipeOutput().copy();  // beware! You must deep copy otherwise you will alter the recipe itself
    }

    // returns the number of ticks the given item will burn. Returns 0 if the given item is not a valid fuel
    public static int getItemBurnTime(World world, ItemStack stack)
    {
        int burntime = net.minecraftforge.common.ForgeHooks.getBurnTime(stack);
        return burntime;
    }

    // gets the recipe which matches the given input, or Missing if none.
    public static Optional<FurnaceRecipe> getMatchingRecipeForInput(World world, ItemStack itemStack) {
        RecipeManager recipeManager = world.getRecipeManager();
        Inventory singleItemInventory = new Inventory(itemStack);
        Optional<FurnaceRecipe> matchingRecipe = recipeManager.getRecipe(IRecipeType.SMELTING, singleItemInventory, world);
        return matchingRecipe;
    }

    /**
     * Gets the cooking time for this recipe input
     * @param world
     * @param itemStack the input item to be smelted
     * @return cooking time (ticks) or 0 if no matching recipe
     */
    public static int getCookTime(World world, ItemStack itemStack) {
        Optional<FurnaceRecipe> matchingRecipe = getMatchingRecipeForInput(world, itemStack);
        if (!matchingRecipe.isPresent()) return 0;
        return matchingRecipe.get().getCookTime();
    }

    // Return true if the given stack is allowed to be inserted in the given slot
    // Unlike the vanilla furnace, we allow anything to be placed in the fuel slots
    static public boolean isItemValidForFuelSlot(ItemStack itemStack)
    {
        return true;
    }

    // Return true if the given stack is allowed to be inserted in the given slot
    // Unlike the vanilla furnace, we allow anything to be placed in the input slots
    static public boolean isItemValidForInputSlot(ItemStack itemStack)
    {
        return true;
    }

    // Return true if the given stack is allowed to be inserted in the given slot
    static public boolean isItemValidForOutputSlot(ItemStack itemStack)
    {
        return false;
    }

    //------------------------------
    private final String FUEL_SLOTS_NBT = "fuelSlots";
    private final String INPUT_SLOTS_NBT = "inputSlots";
    private final String OUTPUT_SLOTS_NBT = "outputSlots";

    // This is where you save any data that you don't want to lose when the tile entity unloads
    // In this case, it saves the state of the furnace (burn time etc) and the itemstacks stored in the fuel, input, and output slots
    @Override
    public CompoundNBT write(CompoundNBT parentNBTTagCompound)
    {
        super.write(parentNBTTagCompound); // The super call is required to save and load the tile's location

        shredderStateData.putIntoNBT(parentNBTTagCompound);
        parentNBTTagCompound.put(FUEL_SLOTS_NBT, fuelZoneContents.serializeNBT());
        parentNBTTagCompound.put(INPUT_SLOTS_NBT, inputZoneContents.serializeNBT());
        parentNBTTagCompound.put(OUTPUT_SLOTS_NBT, outputZoneContents.serializeNBT());
        return parentNBTTagCompound;
    }

    // This is where you load the data that you saved in writeToNBT
    @Override
    public void read(BlockState blockState, CompoundNBT nbtTagCompound)
    {
        super.read(blockState, nbtTagCompound); // The super call is required to save and load the tile's location

        shredderStateData.readFromNBT(nbtTagCompound);

        CompoundNBT inventoryNBT = nbtTagCompound.getCompound(FUEL_SLOTS_NBT);
        fuelZoneContents.deserializeNBT(inventoryNBT);

        inventoryNBT = nbtTagCompound.getCompound(INPUT_SLOTS_NBT);
        inputZoneContents.deserializeNBT(inventoryNBT);

        inventoryNBT = nbtTagCompound.getCompound(OUTPUT_SLOTS_NBT);
        outputZoneContents.deserializeNBT(inventoryNBT);

        if (fuelZoneContents.getSizeInventory() != FUEL_SLOTS_COUNT
                || inputZoneContents.getSizeInventory() != INPUT_SLOTS_COUNT
                || outputZoneContents.getSizeInventory() != OUTPUT_SLOTS_COUNT
        )
            throw new IllegalArgumentException("Corrupted NBT: Number of inventory slots did not match expected.");
    }

    //	// When the world loads from disk, the server needs to send the TileEntity information to the client
//	//  it uses getUpdatePacket(), getUpdateTag(), onDataPacket(), and handleUpdateTag() to do this
    @Override
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket()
    {
        CompoundNBT updateTagDescribingTileEntityState = getUpdateTag();
        final int METADATA = 42; // arbitrary.
        return new SUpdateTileEntityPacket(this.pos, METADATA, updateTagDescribingTileEntityState);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT updateTagDescribingTileEntityState = pkt.getNbtCompound();
        BlockState blockState = world.getBlockState(pos);
        handleUpdateTag(blockState, updateTagDescribingTileEntityState);
    }

    /* Creates a tag containing the TileEntity information, used by vanilla to transmit from server to client
       Warning - although our getUpdatePacket() uses this method, vanilla also calls it directly, so don't remove it.
     */
    @Override
    public CompoundNBT getUpdateTag()
    {
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return nbtTagCompound;
    }

    /* Populates this TileEntity with information from the tag, used by vanilla to transmit from server to client
     *  The vanilla default is suitable for this example but I've included an explicit definition anyway.
     */
    @Override
    public void handleUpdateTag(BlockState blockState, CompoundNBT tag) { read(blockState, tag); }

    /**
     * When this tile entity is destroyed, drop all of its contents into the world
     * @param world
     * @param blockPos
     */
    public void dropAllContents(World world, BlockPos blockPos) {
        InventoryHelper.dropInventoryItems(world, blockPos, fuelZoneContents);
        InventoryHelper.dropInventoryItems(world, blockPos, inputZoneContents);
        InventoryHelper.dropInventoryItems(world, blockPos, outputZoneContents);
    }

    // -------------  The following two methods are used to make the TileEntity perform as a NamedContainerProvider, i.e.
    //  1) Provide a name used when displaying the container, and
    //  2) Creating an instance of container on the server, and linking it to the inventory items stored within the TileEntity

    /**
     *  standard code to look up what the human-readable name is.
     *  Can be useful when the tileentity has a customised name (eg "David's footlocker")
     */
    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("containername.awesomeshop.shredder");
    }

    /**
     * The name is misleading; createMenu has nothing to do with creating a Screen, it is used to create the Container on the server only
     * @param windowID
     * @param playerInventory
     * @param playerEntity
     * @return
     */
    @Nullable
    @Override
    public Container createMenu(int windowID, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return ShredderContainer.createContainerServerSide(windowID, playerInventory,
                inputZoneContents, outputZoneContents, fuelZoneContents, shredderStateData);
    }

    private ItemStack currentlySmeltingItemLastTick = ItemStack.EMPTY;
}