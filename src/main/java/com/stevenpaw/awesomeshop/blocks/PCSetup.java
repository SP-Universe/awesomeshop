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

public class PCSetup extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(4, 0, 9, 12, 1, 13), Block.makeCuboidShape(5, 1, 10, 11, 2, 12), Block.makeCuboidShape(15, 3, 10, 16, 12, 12), Block.makeCuboidShape(0, 3, 10, 1, 12, 12), Block.makeCuboidShape(0, 12, 10, 16, 13, 12), Block.makeCuboidShape(0, 2, 10, 16, 3, 12), Block.makeCuboidShape(1, 3, 11, 15, 12, 13), Block.makeCuboidShape(5, 4, 12, 11, 7, 14), Block.makeCuboidShape(4, 0, 2, 15, 1, 6), Block.makeCuboidShape(1, 0, 2, 3, 1, 5)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(9, 0, 4, 13, 1, 12), Block.makeCuboidShape(10, 1, 5, 12, 2, 11), Block.makeCuboidShape(10, 3, 0, 12, 12, 1), Block.makeCuboidShape(10, 3, 15, 12, 12, 16), Block.makeCuboidShape(10, 12, 0, 12, 13, 16), Block.makeCuboidShape(10, 2, 0, 12, 3, 16), Block.makeCuboidShape(11, 3, 1, 13, 12, 15), Block.makeCuboidShape(12, 4, 5, 14, 7, 11), Block.makeCuboidShape(2, 0, 1, 6, 1, 12), Block.makeCuboidShape(2, 0, 13, 5, 1, 15)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(4, 0, 3, 12, 1, 7), Block.makeCuboidShape(5, 1, 4, 11, 2, 6), Block.makeCuboidShape(0, 3, 4, 1, 12, 6), Block.makeCuboidShape(15, 3, 4, 16, 12, 6), Block.makeCuboidShape(0, 12, 4, 16, 13, 6), Block.makeCuboidShape(0, 2, 4, 16, 3, 6), Block.makeCuboidShape(1, 3, 3, 15, 12, 5), Block.makeCuboidShape(5, 4, 2, 11, 7, 4), Block.makeCuboidShape(1, 0, 10, 12, 1, 14), Block.makeCuboidShape(13, 0, 11, 15, 1, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(3, 0, 4, 7, 1, 12), Block.makeCuboidShape(4, 1, 5, 6, 2, 11), Block.makeCuboidShape(4, 3, 15, 6, 12, 16), Block.makeCuboidShape(4, 3, 0, 6, 12, 1), Block.makeCuboidShape(4, 12, 0, 6, 13, 16), Block.makeCuboidShape(4, 2, 0, 6, 3, 16), Block.makeCuboidShape(3, 3, 1, 5, 12, 15), Block.makeCuboidShape(2, 4, 5, 4, 7, 11), Block.makeCuboidShape(10, 0, 4, 14, 1, 15), Block.makeCuboidShape(11, 0, 1, 14, 1, 3)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public PCSetup() {
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
