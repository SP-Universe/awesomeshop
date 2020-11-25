package com.stevenpaw.awesomeshop.blocks;

import com.stevenpaw.awesomeshop.init.ModTileEntityTypes;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import sun.util.resources.cldr.it.LocaleNames_it;

import javax.annotation.Nullable;
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
        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH).with(LIT, false));
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }

    





    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos po, ISelectionContext context)
    {
        switch (state.get(FACING))
        {
            case NORTH:
                return SHAPE_N;
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
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }
}
