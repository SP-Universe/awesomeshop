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

public class ShowerFaucet2 extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(3, 8, 13, 5, 12, 14), Block.makeCuboidShape(11, 9, 12.8, 13, 11, 15.8), Block.makeCuboidShape(3, 9, 12.8, 5, 11, 15.8), Block.makeCuboidShape(11, 8, 13, 13, 12, 14), Block.makeCuboidShape(10, 9, 12.99, 14, 11, 13.991), Block.makeCuboidShape(2, 9, 12.99, 6, 11, 13.991), Block.makeCuboidShape(5, 9.5, 14.5, 11, 10.5, 15.5), Block.makeCuboidShape(1, 8, 15, 2, 12, 16), Block.makeCuboidShape(14, 8, 15, 15, 12, 16), Block.makeCuboidShape(2, 7, 15, 14, 13, 16)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(13, 8, 11, 14, 12, 13), Block.makeCuboidShape(12.8, 9, 3, 15.8, 11, 5), Block.makeCuboidShape(12.8, 9, 11, 15.8, 11, 13), Block.makeCuboidShape(13, 8, 3, 14, 12, 5), Block.makeCuboidShape(12.99, 9, 2, 13.991, 11, 6), Block.makeCuboidShape(12.99, 9, 10, 13.991, 11, 14), Block.makeCuboidShape(14.5, 9.5, 5, 15.5, 10.5, 11), Block.makeCuboidShape(15, 8, 14, 16, 12, 15), Block.makeCuboidShape(15, 8, 1, 16, 12, 2), Block.makeCuboidShape(15, 7, 2, 16, 13, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(11, 8, 2, 13, 12, 3), Block.makeCuboidShape(3, 9, 0.1999999999999993, 5, 11, 3.1999999999999993), Block.makeCuboidShape(11, 9, 0.1999999999999993, 13, 11, 3.1999999999999993), Block.makeCuboidShape(3, 8, 2, 5, 12, 3), Block.makeCuboidShape(2, 9, 2.0090000000000003, 6, 11, 3.01), Block.makeCuboidShape(10, 9, 2.0090000000000003, 14, 11, 3.01), Block.makeCuboidShape(5, 9.5, 0.5, 11, 10.5, 1.5), Block.makeCuboidShape(14, 8, 0, 15, 12, 1), Block.makeCuboidShape(1, 8, 0, 2, 12, 1), Block.makeCuboidShape(2, 7, 0, 14, 13, 1)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(2, 8, 3, 3, 12, 5), Block.makeCuboidShape(0.1999999999999993, 9, 11, 3.1999999999999993, 11, 13), Block.makeCuboidShape(0.1999999999999993, 9, 3, 3.1999999999999993, 11, 5), Block.makeCuboidShape(2, 8, 11, 3, 12, 13), Block.makeCuboidShape(2.0090000000000003, 9, 10, 3.01, 11, 14), Block.makeCuboidShape(2.0090000000000003, 9, 2, 3.01, 11, 6), Block.makeCuboidShape(0.5, 9.5, 5, 1.5, 10.5, 11), Block.makeCuboidShape(0, 8, 1, 1, 12, 2), Block.makeCuboidShape(0, 8, 14, 1, 12, 15), Block.makeCuboidShape(0, 7, 2, 1, 13, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ShowerFaucet2() {
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
