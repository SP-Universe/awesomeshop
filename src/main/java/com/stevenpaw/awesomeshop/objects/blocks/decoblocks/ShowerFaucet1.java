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

import net.minecraft.block.AbstractBlock.Properties;

public class ShowerFaucet1 extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(7, 6, 13, 9, 11, 14), Block.makeCuboidShape(6, 3, 15, 10, 13, 16), Block.makeCuboidShape(10, 4, 15, 11, 12, 16), Block.makeCuboidShape(5, 4, 15, 6, 12, 16), Block.makeCuboidShape(7, 9, 14, 9, 11, 15)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(13, 6, 7, 14, 11, 9), Block.makeCuboidShape(15, 3, 6, 16, 13, 10), Block.makeCuboidShape(15, 4, 5, 16, 12, 6), Block.makeCuboidShape(15, 4, 10, 16, 12, 11), Block.makeCuboidShape(14, 9, 7, 15, 11, 9)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(7, 6, 2, 9, 11, 3), Block.makeCuboidShape(6, 3, 0, 10, 13, 1), Block.makeCuboidShape(5, 4, 0, 6, 12, 1), Block.makeCuboidShape(10, 4, 0, 11, 12, 1), Block.makeCuboidShape(7, 9, 1, 9, 11, 2)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(2, 6, 7, 3, 11, 9), Block.makeCuboidShape(0, 3, 6, 1, 13, 10), Block.makeCuboidShape(0, 4, 10, 1, 12, 11), Block.makeCuboidShape(0, 4, 5, 1, 12, 6), Block.makeCuboidShape(1, 9, 7, 2, 11, 9)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ShowerFaucet1() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f,2.0f)
                .sound(SoundType.STONE)
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
