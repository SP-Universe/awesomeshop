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

public class StairsRailingLeft extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(14.500000000000002, -11, 4.700000000000001, 15.500000000000002, 5, 5.700000000000001), Block.makeCuboidShape(14.500000000000002, -8, 8, 15.500000000000002, 8, 9), Block.makeCuboidShape(14.500000000000002, -14.2, 1.5000000000000004, 15.500000000000002, 1.8000000000000007, 2.5000000000000004), Block.makeCuboidShape(14.500000000000002, -5, 11, 15.500000000000002, 11, 12), Block.makeCuboidShape(14.500000000000002, -1.6999999999999997, 14.299999999999999, 15.500000000000002, 14.299999999999999, 15.299999999999999)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(4.700000000000001, -11, 0.4999999999999982, 5.700000000000001, 5, 1.4999999999999982), Block.makeCuboidShape(8, -8, 0.4999999999999982, 9, 8, 1.4999999999999982), Block.makeCuboidShape(1.5, -14.2, 0.4999999999999982, 2.5, 1.8000000000000007, 1.4999999999999982), Block.makeCuboidShape(11, -5, 0.4999999999999982, 12, 11, 1.4999999999999982), Block.makeCuboidShape(14.299999999999999, -1.6999999999999993, 0.4999999999999982, 15.299999999999999, 14.299999999999999, 1.4999999999999982)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(0.4999999999999982, -11, 10.299999999999999, 1.4999999999999982, 5, 11.299999999999999), Block.makeCuboidShape(0.4999999999999982, -8, 7, 1.4999999999999982, 8, 8), Block.makeCuboidShape(0.4999999999999982, -14.2, 13.5, 1.4999999999999982, 1.8000000000000007, 14.5), Block.makeCuboidShape(0.4999999999999982, -5, 4, 1.4999999999999982, 11, 5), Block.makeCuboidShape(0.4999999999999982, -1.6999999999999993, 0.7000000000000011, 1.4999999999999982, 14.299999999999999, 1.700000000000001)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(10.299999999999999, -11, 14.500000000000002, 11.299999999999999, 5, 15.500000000000002), Block.makeCuboidShape(7, -8, 14.500000000000002, 8, 8, 15.500000000000002), Block.makeCuboidShape(13.5, -14.2, 14.500000000000002, 14.5, 1.8000000000000007, 15.500000000000002), Block.makeCuboidShape(4, -5, 14.500000000000002, 5, 11, 15.500000000000002), Block.makeCuboidShape(0.7000000000000011, -1.6999999999999993, 14.500000000000002, 1.700000000000001, 14.299999999999999, 15.500000000000002)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public StairsRailingLeft() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f,2.0f)
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
