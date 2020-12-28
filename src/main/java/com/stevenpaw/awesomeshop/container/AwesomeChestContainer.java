package com.stevenpaw.awesomeshop.container;

import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import com.stevenpaw.awesomeshop.tileentity.AwesomeChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class AwesomeChestContainer extends Container {

    public final AwesomeChestTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    //VARIABLES FOR DEFINING THE SLOTS---------
    int startChestX = 8;                                //The pixelX on which the first Slot starts
    int startChestY = 18;                               //The pixelY on which the first Slot starts
    int slotSize = 16;                                  //Pixelsize of a slot
    int slotSpacing = 2;                                //Spacing between Slots
    int slotSizeWithSpace = slotSize + slotSpacing;     //SlotSize with SlotSpacing

    int rowCount = 4;                                   //Number of Rows for the Chest
    int columnCount = 9;                                //Number of Columns for the Chest

    int playerInventoryStartX = 8;                      //The pixelX on which the first Slot of the PlayerInventory starts
    int inventorySpacing = 12;                          //The space between the Container and the PlayerInventory
    int hotBarSpacing = 4;                              //The space between the PlayerInventory and the HotBar
    //-----------------------------------------

    int slotCount = rowCount * columnCount;

    public AwesomeChestContainer(final int windowId, final PlayerInventory playerInventory, final AwesomeChestTileEntity tileEntity) {
        super(ModContainerTypes.AWESOME_CHEST.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        //Chest Inventory
        for (int row = 0; row < rowCount; ++row) {
            for (int column = 0; column < columnCount; ++column) {
                this.addSlot(new Slot(tileEntity, (row * columnCount) + column, startChestX + (column * slotSizeWithSpace), startChestY + (row * slotSizeWithSpace)));
            }
        }


        //Player Inventory
        int startPlayerInvY = startChestY + (rowCount * slotSizeWithSpace) + inventorySpacing;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, playerInventoryStartX + (column * slotSizeWithSpace), startPlayerInvY + (row * slotSizeWithSpace)));
            }
        }

        //Player HotBar
        int hotbarY = startPlayerInvY + (3 * slotSizeWithSpace) + hotBarSpacing;
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, playerInventoryStartX + (column * slotSizeWithSpace), hotbarY));
        }
    }

    private static AwesomeChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof AwesomeChestTileEntity) {
            return (AwesomeChestTileEntity) tileAtPos;
        }
        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public AwesomeChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.AWESOME_CHEST.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < slotCount) {
                if (!this.mergeItemStack(itemstack1, slotCount, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, slotCount, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}
