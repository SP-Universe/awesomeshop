package com.stevenpaw.awesomeshop.blocks;

import com.stevenpaw.awesomeshop.tileentity.ShredderTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Shredder extends ContainerBlock{

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(2, 12, 10, 14, 15, 13), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(0, 7, 0, 16, 14, 5), Block.makeCuboidShape(0, 7, 11, 16, 14, 16), Block.makeCuboidShape(1, 11, 2, 2, 15, 14), Block.makeCuboidShape(14, 11, 2, 15, 15, 14), Block.makeCuboidShape(2, 12, 3, 14, 15, 6)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(3, 12, 2, 6, 15, 14), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(11, 7, 0, 16, 14, 16), Block.makeCuboidShape(0, 7, 0, 5, 14, 16), Block.makeCuboidShape(2, 11, 1, 14, 15, 2), Block.makeCuboidShape(2, 11, 14, 14, 15, 15), Block.makeCuboidShape(10, 12, 2, 13, 15, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(2, 12, 3, 14, 15, 6), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(0, 7, 11, 16, 14, 16), Block.makeCuboidShape(0, 7, 0, 16, 14, 5), Block.makeCuboidShape(14, 11, 2, 15, 15, 14), Block.makeCuboidShape(1, 11, 2, 2, 15, 14), Block.makeCuboidShape(2, 12, 10, 14, 15, 13)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(10, 12, 2, 13, 15, 14), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(0, 7, 0, 5, 14, 16), Block.makeCuboidShape(11, 7, 0, 16, 14, 16), Block.makeCuboidShape(2, 11, 14, 14, 15, 15), Block.makeCuboidShape(2, 11, 1, 14, 15, 2), Block.makeCuboidShape(3, 12, 2, 6, 15, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Shredder()
    {
        super(Block.Properties.create(Material.ROCK).setLightLevel(Shredder::getLightValue)
        );
        BlockState defaultBlockState = this.stateContainer.getBaseState().with(BURNING_SIDES_COUNT, 0);
        this.setDefaultState(defaultBlockState);
    }

    // --- The block changes its appearance depending on how many of the furnace slots have burning fuel in them
    //  In order to do that, we add a blockstate for each state (0 -> 4), each with a corresponding model.  We also change the blockLight emitted.

    final static int MAX_NUMBER_OF_BURNING_SIDES = 4;
    public static final IntegerProperty BURNING_SIDES_COUNT =
            IntegerProperty.create("burning_sides_count",0, MAX_NUMBER_OF_BURNING_SIDES);

    // change the furnace emitted light ("block light") depending on how many slots are burning
    private static final int ALL_SIDES_LIGHT_VALUE = 15; // light value for four sides burning
    private static final int ONE_SIDE_LIGHT_VALUE = 8;  // light value for a single side burning

    /**
     * Amount of block light emitted by the furnace
     * This function is registered in the Block Properties using func_235838_a;  see BlockInventoryFurnace constructor
     */
    public static int getLightValue(BlockState state) {
        int lightValue = 0;
        Integer burningSidesCount = state.get(BURNING_SIDES_COUNT);

        if (burningSidesCount == 0) {
            lightValue = 0;
        } else {
            // linearly interpolate the light value depending on how many slots are burning
            lightValue = ONE_SIDE_LIGHT_VALUE +
                    (ALL_SIDES_LIGHT_VALUE - ONE_SIDE_LIGHT_VALUE) * burningSidesCount / (MAX_NUMBER_OF_BURNING_SIDES - 1);
        }
        lightValue = MathHelper.clamp(lightValue, 0, ALL_SIDES_LIGHT_VALUE);
        return lightValue;
    }

    // ---------------------

    /**
     * Create the Tile Entity for this block.
     * Forge has a default but I've included it anyway for clarity
     * @return
     */
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return createNewTileEntity(world);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new ShredderTileEntity();
    }

    // not needed if your block implements ITileEntityProvider (in this case implemented by BlockContainer), but it
    //  doesn't hurt to include it anyway...
    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }


    // Called when the block is right clicked
    // In this block it is used to open the block gui when right clicked by a player
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        if (worldIn.isRemote) return ActionResultType.SUCCESS; // on client side, don't do anything

        INamedContainerProvider namedContainerProvider = this.getContainer(state, worldIn, pos);
        if (namedContainerProvider != null) {
            if (!(player instanceof ServerPlayerEntity)) return ActionResultType.FAIL;  // should always be true, but just in case...
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
            NetworkHooks.openGui(serverPlayerEntity, namedContainerProvider, (packetBuffer)->{});
            // (packetBuffer)->{} is just a do-nothing because we have no extra data to send
        }
        return ActionResultType.SUCCESS;
    }

    // This is where you can do something when the block is broken. In this case drop the inventory's contents
    // Code is copied directly from vanilla eg ChestBlock, CampfireBlock
    @Override
    public void onReplaced(BlockState state, World world, BlockPos blockPos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tileentity = world.getTileEntity(blockPos);
            if (tileentity instanceof ShredderTileEntity) {
                ShredderTileEntity tileEntityFurnace = (ShredderTileEntity)tileentity;
                tileEntityFurnace.dropAllContents(world, blockPos);
            }
//      worldIn.updateComparatorOutputLevel(pos, this);  if the inventory is used to set redstone power for comparators
            super.onReplaced(state, world, blockPos, newState, isMoving);  // call it last, because it removes the TileEntity
        }
    }

    // ---------------------------
    // If you want your container to provide redstone power to a comparator based on its contents, implement these methods
    //  see vanilla for examples

    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return false;
    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return 0;
    }

    //------------------------------------------------------------
    //  The code below isn't necessary for illustrating the Inventory Furnace concepts, it's just used for rendering.
    //  For more background information see MBE03

    // render using a BakedModel
    // required because the default (super method) is INVISIBLE for BlockContainers.
    @Override
    public BlockRenderType getRenderType(BlockState iBlockState) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BURNING_SIDES_COUNT);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos po, ISelectionContext context)
    {
        switch (state.get(FACING))
        {
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }
}
