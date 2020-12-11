package com.stevenpaw.awesomeshop.blocks;

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

public class Toilet extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(6, 0, 6, 7, 5, 16), Block.makeCuboidShape(7, 4, 12, 9, 17, 16), Block.makeCuboidShape(10, 5, 5, 12, 7, 16), Block.makeCuboidShape(11, 7, 5, 13, 9, 16), Block.makeCuboidShape(2, 8, 4, 4, 11, 16), Block.makeCuboidShape(3, 7, 5, 5, 9, 16), Block.makeCuboidShape(12, 8, 4, 14, 11, 16), Block.makeCuboidShape(4, 5, 5, 6, 7, 16), Block.makeCuboidShape(4, 9, 2, 12, 11, 3), Block.makeCuboidShape(4, 7, 4, 12, 8, 6), Block.makeCuboidShape(6, 5, 5, 10, 7, 7), Block.makeCuboidShape(3, 8, 3, 13, 11, 4), Block.makeCuboidShape(4, 8, 4, 12, 9, 5), Block.makeCuboidShape(9, 0, 6, 10, 5, 16), Block.makeCuboidShape(7, 0, 6, 9, 5, 8), Block.makeCuboidShape(7, 0, 8, 9, 2, 16), Block.makeCuboidShape(6, 5, 12, 7, 17, 16), Block.makeCuboidShape(5, 7, 12, 6, 17, 16), Block.makeCuboidShape(4, 9, 12, 5, 17, 16), Block.makeCuboidShape(2, 11, 12, 4, 16, 16), Block.makeCuboidShape(9, 5, 12, 10, 17, 16), Block.makeCuboidShape(10, 7, 12, 11, 17, 16), Block.makeCuboidShape(11, 9, 12, 12, 17, 16), Block.makeCuboidShape(12, 11, 12, 14, 16, 16), Block.makeCuboidShape(5, 17, 13, 7, 18, 15), Block.makeCuboidShape(11, 8, 4, 12, 11, 5), Block.makeCuboidShape(4, 8, 4, 5, 11, 5), Block.makeCuboidShape(7, 4, 10, 9, 5, 12)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(6, 0, 9, 16, 5, 10), Block.makeCuboidShape(12, 4, 7, 16, 17, 9), Block.makeCuboidShape(5, 5, 4, 16, 7, 6), Block.makeCuboidShape(5, 7, 3, 16, 9, 5), Block.makeCuboidShape(4, 8, 12, 16, 11, 14), Block.makeCuboidShape(5, 7, 11, 16, 9, 13), Block.makeCuboidShape(4, 8, 2, 16, 11, 4), Block.makeCuboidShape(5, 5, 10, 16, 7, 12), Block.makeCuboidShape(2, 9, 4, 3, 11, 12), Block.makeCuboidShape(4, 7, 4, 6, 8, 12), Block.makeCuboidShape(5, 5, 6, 7, 7, 10), Block.makeCuboidShape(3, 8, 3, 4, 11, 13), Block.makeCuboidShape(4, 8, 4, 5, 9, 12), Block.makeCuboidShape(6, 0, 6, 16, 5, 7), Block.makeCuboidShape(6, 0, 7, 8, 5, 9), Block.makeCuboidShape(8, 0, 7, 16, 2, 9), Block.makeCuboidShape(12, 5, 9, 16, 17, 10), Block.makeCuboidShape(12, 7, 10, 16, 17, 11), Block.makeCuboidShape(12, 9, 11, 16, 17, 12), Block.makeCuboidShape(12, 11, 12, 16, 16, 14), Block.makeCuboidShape(12, 5, 6, 16, 17, 7), Block.makeCuboidShape(12, 7, 5, 16, 17, 6), Block.makeCuboidShape(12, 9, 4, 16, 17, 5), Block.makeCuboidShape(12, 11, 2, 16, 16, 4), Block.makeCuboidShape(13, 17, 9, 15, 18, 11), Block.makeCuboidShape(4, 8, 4, 5, 11, 5), Block.makeCuboidShape(4, 8, 11, 5, 11, 12), Block.makeCuboidShape(10, 4, 7, 12, 5, 9)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(9, 0, 0, 10, 5, 10), Block.makeCuboidShape(7, 4, 0, 9, 17, 4), Block.makeCuboidShape(4, 5, 0, 6, 7, 11), Block.makeCuboidShape(3, 7, 0, 5, 9, 11), Block.makeCuboidShape(12, 8, 0, 14, 11, 12), Block.makeCuboidShape(11, 7, 0, 13, 9, 11), Block.makeCuboidShape(2, 8, 0, 4, 11, 12), Block.makeCuboidShape(10, 5, 0, 12, 7, 11), Block.makeCuboidShape(4, 9, 13, 12, 11, 14), Block.makeCuboidShape(4, 7, 10, 12, 8, 12),Block.makeCuboidShape(6, 5, 9, 10, 7, 11), Block.makeCuboidShape(3, 8, 12, 13, 11, 13), Block.makeCuboidShape(4, 8, 11, 12, 9, 12), Block.makeCuboidShape(6, 0, 0, 7, 5, 10), Block.makeCuboidShape(7, 0, 8, 9, 5, 10), Block.makeCuboidShape(7, 0, 0, 9, 2, 8), Block.makeCuboidShape(9, 5, 0, 10, 17, 4), Block.makeCuboidShape(10, 7, 0, 11, 17, 4), Block.makeCuboidShape(11, 9, 0, 12, 17, 4), Block.makeCuboidShape(12, 11, 0, 14, 16, 4), Block.makeCuboidShape(6, 5, 0, 7, 17, 4), Block.makeCuboidShape(5, 7, 0, 6, 17, 4), Block.makeCuboidShape(4, 9, 0, 5, 17, 4), Block.makeCuboidShape(2, 11, 0, 4, 16, 4), Block.makeCuboidShape(9, 17, 1, 11, 18, 3), Block.makeCuboidShape(4, 8, 11, 5, 11, 12), Block.makeCuboidShape(11, 8, 11, 12, 11, 12), Block.makeCuboidShape(7, 4, 4, 9, 5, 6)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(0, 0, 6, 10, 5, 7), Block.makeCuboidShape(0, 4, 7, 4, 17, 9), Block.makeCuboidShape(0, 5, 10, 11, 7, 12), Block.makeCuboidShape(0, 7, 11, 11, 9, 13), Block.makeCuboidShape(0, 8, 2, 12, 11, 4), Block.makeCuboidShape(0, 7, 3, 11, 9, 5), Block.makeCuboidShape(0, 8, 12, 12, 11, 14), Block.makeCuboidShape(0, 5, 4, 11, 7, 6), Block.makeCuboidShape(13, 9, 4, 14, 11, 12), Block.makeCuboidShape(10, 7, 4, 12, 8, 12), Block.makeCuboidShape(9, 5, 6, 11, 7, 10), Block.makeCuboidShape(12, 8, 3, 13, 11, 13), Block.makeCuboidShape(11, 8, 4, 12, 9, 12), Block.makeCuboidShape(0, 0, 9, 10, 5, 10), Block.makeCuboidShape(8, 0, 7, 10, 5, 9), Block.makeCuboidShape(0, 0, 7, 8, 2, 9), Block.makeCuboidShape(0, 5, 6, 4, 17, 7), Block.makeCuboidShape(0, 7, 5, 4, 17, 6), Block.makeCuboidShape(0, 9, 4, 4, 17, 5), Block.makeCuboidShape(0, 11, 2, 4, 16, 4), Block.makeCuboidShape(0, 5, 9, 4, 17, 10), Block.makeCuboidShape(0, 7, 10, 4, 17, 11), Block.makeCuboidShape(0, 9, 11, 4, 17, 12), Block.makeCuboidShape(0, 11, 12, 4, 16, 14), Block.makeCuboidShape(1, 17, 5, 3, 18, 7), Block.makeCuboidShape(11, 8, 11, 12, 11, 12), Block.makeCuboidShape(11, 8, 4, 12, 11, 5), Block.makeCuboidShape(4, 4, 7, 6, 5, 9)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Toilet() {
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
