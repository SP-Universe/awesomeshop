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

public class StairsRailingRight extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(0.5000000000000018, -11, 4.700000000000001, 1.5000000000000018, 5, 5.700000000000001), Block.makeCuboidShape(0.5000000000000018, -8, 8, 1.5000000000000018, 8, 9), Block.makeCuboidShape(0.5000000000000018, -14.2, 1.5, 1.5000000000000018, 1.8000000000000007, 2.5), Block.makeCuboidShape(0.5000000000000018, -5, 11, 1.5000000000000018, 11, 12), Block.makeCuboidShape(0.5000000000000018, -1.6999999999999993, 14.299999999999999, 1.5000000000000018, 14.299999999999999, 15.299999999999999)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(4.700000000000001, -11, 14.499999999999998, 5.700000000000001, 5, 15.499999999999998), Block.makeCuboidShape(8, -8, 14.499999999999998, 9, 8, 15.499999999999998), Block.makeCuboidShape(1.5, -14.2, 14.499999999999998, 2.5, 1.8000000000000007, 15.499999999999998), Block.makeCuboidShape(11, -5, 14.499999999999998, 12, 11, 15.499999999999998), Block.makeCuboidShape(14.299999999999999, -1.6999999999999993, 14.499999999999998, 15.299999999999999, 14.299999999999999, 15.499999999999998)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(14.499999999999998, -11, 10.299999999999999, 15.499999999999998, 5, 11.299999999999999), Block.makeCuboidShape(14.499999999999998, -8, 7, 15.499999999999998, 8, 8), Block.makeCuboidShape(14.499999999999998, -14.2, 13.5, 15.499999999999998, 1.8000000000000007, 14.5), Block.makeCuboidShape(14.499999999999998, -5, 4, 15.499999999999998, 11, 5), Block.makeCuboidShape(14.499999999999998, -1.6999999999999993, 0.7000000000000011, 15.499999999999998, 14.299999999999999, 1.700000000000001)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(10.299999999999999, -11, 0.5000000000000018, 11.299999999999999, 5, 1.5000000000000018), Block.makeCuboidShape(7, -8, 0.5000000000000018, 8, 8, 1.5000000000000018), Block.makeCuboidShape(13.5, -14.2, 0.5000000000000018, 14.5, 1.8000000000000007, 1.5000000000000018), Block.makeCuboidShape(4, -5, 0.5000000000000018, 5, 11, 1.5000000000000018), Block.makeCuboidShape(0.7000000000000011, -1.6999999999999993, 0.5000000000000018, 1.700000000000001, 14.299999999999999, 1.5000000000000018)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public StairsRailingRight() {
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
