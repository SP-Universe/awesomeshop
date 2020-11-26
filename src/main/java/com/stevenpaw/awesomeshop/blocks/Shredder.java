package com.stevenpaw.awesomeshop.blocks;

import com.stevenpaw.awesomeshop.init.ModTileEntityTypes;
import com.stevenpaw.awesomeshop.tileentity.ShredderTileEntity;
import com.stevenpaw.awesomeshop.util.ShredderItemHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import sun.util.resources.cldr.it.LocaleNames_it;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.stream.Stream;

public class Shredder extends Block{

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(2, 12, 10, 14, 15, 13), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(0, 7, 0, 16, 14, 5), Block.makeCuboidShape(0, 7, 11, 16, 14, 16), Block.makeCuboidShape(1, 11, 2, 2, 15, 14), Block.makeCuboidShape(14, 11, 2, 15, 15, 14), Block.makeCuboidShape(2, 12, 3, 14, 15, 6)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(3, 12, 2, 6, 15, 14), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(11, 7, 0, 16, 14, 16), Block.makeCuboidShape(0, 7, 0, 5, 14, 16), Block.makeCuboidShape(2, 11, 1, 14, 15, 2), Block.makeCuboidShape(2, 11, 14, 14, 15, 15), Block.makeCuboidShape(10, 12, 2, 13, 15, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(2, 12, 3, 14, 15, 6), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(0, 7, 11, 16, 14, 16), Block.makeCuboidShape(0, 7, 0, 16, 14, 5), Block.makeCuboidShape(14, 11, 2, 15, 15, 14), Block.makeCuboidShape(1, 11, 2, 2, 15, 14), Block.makeCuboidShape(2, 12, 10, 14, 15, 13)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(10, 12, 2, 13, 15, 14), Block.makeCuboidShape(1, 0, 1, 15, 11, 15), Block.makeCuboidShape(0, 7, 0, 5, 14, 16), Block.makeCuboidShape(11, 7, 0, 16, 14, 16), Block.makeCuboidShape(2, 11, 14, 14, 15, 15), Block.makeCuboidShape(2, 11, 1, 14, 15, 2), Block.makeCuboidShape(3, 12, 2, 6, 15, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Shredder() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f,4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return ModTileEntityTypes.SHREDDER.get().create();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING, LIT);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.get(LIT) ? super.getLightValue(state, world, pos) : 0;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if(stack.hasDisplayName()) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof ShredderTileEntity) {
                ((ShredderTileEntity)tile).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos){
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT)) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY();
            double d2 = (double) pos.getZ() + 0.5D;
            if (rand.nextDouble() < 0.1D) {
                worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F,
                        false);
            }

            Direction direction = stateIn.get(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d4 = rand.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double) direction.getXOffset() * 0.52D : d4;
            double d6 = rand.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getZOffset() * 0.52D : d4;
            worldIn.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                Hand handIn, BlockRayTraceResult hit){
        if(worldIn != null && !worldIn.isRemote) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof ShredderTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity)player, (INamedContainerProvider)tile, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving){
        TileEntity tile = worldIn.getTileEntity(pos);
        if(tile instanceof  ShredderTileEntity) {
            ShredderTileEntity shredder = (ShredderTileEntity) tile;
            ItemEntity itemEntity;

            ShredderTileEntity te = (ShredderTileEntity) worldIn.getTileEntity(pos);
            IItemHandler cap = (IItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            for (int i = 0; i < cap.getSlots(); ++i)
            {
                ItemStack itemstack = cap.getStackInSlot(i);

                if (!itemstack.isEmpty())
                {
                    InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
                }
            }

            //shredder.getInventory().toNonNullList().forEach(item -> {
            //    itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
            //   worldIn.addEntity(itemEntity);
            //});
        }

        if(state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
            worldIn.removeTileEntity(pos);
        }
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

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }
}
