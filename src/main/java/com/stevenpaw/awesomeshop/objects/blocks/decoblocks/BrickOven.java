package com.stevenpaw.awesomeshop.objects.blocks.decoblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class BrickOven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(0, 0, 8, 16, 1, 16), Block.makeCuboidShape(3, 1, 15, 13, 9, 16), Block.makeCuboidShape(0, 9, 8, 16, 10, 16), Block.makeCuboidShape(2, 10, 8, 14, 11, 16), Block.makeCuboidShape(4, 11, 10, 12, 12, 16), Block.makeCuboidShape(5, 12, 15, 11, 16, 16), Block.makeCuboidShape(5, 12, 12, 11, 16, 13), Block.makeCuboidShape(10, 12, 13, 11, 16, 15), Block.makeCuboidShape(5, 12, 13, 6, 16, 15), Block.makeCuboidShape(4, 9, 6, 12, 10, 8), Block.makeCuboidShape(11, 8, 6, 13, 9, 7), Block.makeCuboidShape(3, 8, 6, 5, 9, 7), Block.makeCuboidShape(0, 1, 8, 3, 9, 16), Block.makeCuboidShape(12, 1, 7, 15, 10, 8), Block.makeCuboidShape(1, 1, 7, 4, 10, 8), Block.makeCuboidShape(13, 1, 8, 16, 9, 16), Block.makeCuboidShape(1, 0, 7, 15, 1, 8), Block.makeCuboidShape(5, 0, 5, 11, 1, 6), Block.makeCuboidShape(3, 0, 6, 13, 1, 7), Block.makeCuboidShape(4, 3, 7, 12, 4, 8), Block.makeCuboidShape(6, 1, 7, 7, 3, 8), Block.makeCuboidShape(9, 1, 7, 10, 3, 8)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(8, 0, 0, 16, 1, 16), Block.makeCuboidShape(15, 1, 3, 16, 9, 13), Block.makeCuboidShape(8, 9, 0, 16, 10, 16), Block.makeCuboidShape(8, 10, 2, 16, 11, 14), Block.makeCuboidShape(10, 11, 4, 16, 12, 12), Block.makeCuboidShape(15, 12, 5, 16, 16, 11), Block.makeCuboidShape(12, 12, 5, 13, 16, 11), Block.makeCuboidShape(13, 12, 5, 15, 16, 6), Block.makeCuboidShape(13, 12, 10, 15, 16, 11), Block.makeCuboidShape(6, 9, 4, 8, 10, 12), Block.makeCuboidShape(6, 8, 3, 7, 9, 5), Block.makeCuboidShape(6, 8, 11, 7, 9, 13), Block.makeCuboidShape(8, 1, 13, 16, 9, 16), Block.makeCuboidShape(7, 1, 1, 8, 10, 4), Block.makeCuboidShape(7, 1, 12, 8, 10, 15), Block.makeCuboidShape(8, 1, 0, 16, 9, 3), Block.makeCuboidShape(7, 0, 1, 8, 1, 15), Block.makeCuboidShape(5, 0, 5, 6, 1, 11), Block.makeCuboidShape(6, 0, 3, 7, 1, 13), Block.makeCuboidShape(7, 3, 4, 8, 4, 12), Block.makeCuboidShape(7, 1, 9, 8, 3, 10), Block.makeCuboidShape(7, 1, 6, 8, 3, 7)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(0, 0, 0, 16, 1, 8), Block.makeCuboidShape(3, 1, 0, 13, 9, 1), Block.makeCuboidShape(0, 9, 0, 16, 10, 8), Block.makeCuboidShape(2, 10, 0, 14, 11, 8), Block.makeCuboidShape(4, 11, 0, 12, 12, 6), Block.makeCuboidShape(5, 12, 0, 11, 16, 1), Block.makeCuboidShape(5, 12, 3, 11, 16, 4), Block.makeCuboidShape(5, 12, 1, 6, 16, 3), Block.makeCuboidShape(10, 12, 1, 11, 16, 3), Block.makeCuboidShape(4, 9, 8, 12, 10, 10), Block.makeCuboidShape(3, 8, 9, 5, 9, 10), Block.makeCuboidShape(11, 8, 9, 13, 9, 10), Block.makeCuboidShape(13, 1, 0, 16, 9, 8), Block.makeCuboidShape(1, 1, 8, 4, 10, 9), Block.makeCuboidShape(12, 1, 8, 15, 10, 9), Block.makeCuboidShape(0, 1, 0, 3, 9, 8), Block.makeCuboidShape(1, 0, 8, 15, 1, 9), Block.makeCuboidShape(5, 0, 10, 11, 1, 11), Block.makeCuboidShape(3, 0, 9, 13, 1, 10), Block.makeCuboidShape(4, 3, 8, 12, 4, 9), Block.makeCuboidShape(9, 1, 8, 10, 3, 9), Block.makeCuboidShape(6, 1, 8, 7, 3, 9)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(0, 0, 0, 8, 1, 16), Block.makeCuboidShape(0, 1, 3, 1, 9, 13), Block.makeCuboidShape(0, 9, 0, 8, 10, 16), Block.makeCuboidShape(0, 10, 2, 8, 11, 14), Block.makeCuboidShape(0, 11, 4, 6, 12, 12), Block.makeCuboidShape(0, 12, 5, 1, 16, 11), Block.makeCuboidShape(3, 12, 5, 4, 16, 11), Block.makeCuboidShape(1, 12, 10, 3, 16, 11), Block.makeCuboidShape(1, 12, 5, 3, 16, 6), Block.makeCuboidShape(8, 9, 4, 10, 10, 12), Block.makeCuboidShape(9, 8, 11, 10, 9, 13), Block.makeCuboidShape(9, 8, 3, 10, 9, 5), Block.makeCuboidShape(0, 1, 0, 8, 9, 3), Block.makeCuboidShape(8, 1, 12, 9, 10, 15), Block.makeCuboidShape(8, 1, 1, 9, 10, 4), Block.makeCuboidShape(0, 1, 13, 8, 9, 16), Block.makeCuboidShape(8, 0, 1, 9, 1, 15), Block.makeCuboidShape(10, 0, 5, 11, 1, 11), Block.makeCuboidShape(9, 0, 3, 10, 1, 13), Block.makeCuboidShape(8, 3, 4, 9, 4, 12), Block.makeCuboidShape(8, 1, 6, 9, 3, 7), Block.makeCuboidShape(8, 1, 9, 9, 3, 10)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BrickOven() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f,4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0));
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
