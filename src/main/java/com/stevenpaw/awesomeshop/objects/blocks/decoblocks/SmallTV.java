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

public class SmallTV extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(0, 3, 7, 1, 12, 9), Block.makeCuboidShape(5, 1, 7, 11, 2, 9), Block.makeCuboidShape(4, 0, 6, 12, 1, 10), Block.makeCuboidShape(15, 3, 7, 16, 12, 9), Block.makeCuboidShape(0, 2, 7, 16, 3, 9), Block.makeCuboidShape(0, 12, 7, 16, 13, 9), Block.makeCuboidShape(1, 3, 8, 15, 12, 10), Block.makeCuboidShape(5, 4, 9, 11, 7, 11)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(7, 3, 15, 9, 12, 16), Block.makeCuboidShape(7, 1, 5, 9, 2, 11), Block.makeCuboidShape(6, 0, 4, 10, 1, 12), Block.makeCuboidShape(7, 3, 0, 9, 12, 1), Block.makeCuboidShape(7, 2, 0, 9, 3, 16), Block.makeCuboidShape(7, 12, 0, 9, 13, 16), Block.makeCuboidShape(8, 3, 1, 10, 12, 15), Block.makeCuboidShape(9, 4, 5, 11, 7, 11)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(15, 3, 7, 16, 12, 9), Block.makeCuboidShape(5, 1, 7, 11, 2, 9), Block.makeCuboidShape(4, 0, 6, 12, 1, 10), Block.makeCuboidShape(0, 3, 7, 1, 12, 9), Block.makeCuboidShape(0, 2, 7, 16, 3, 9), Block.makeCuboidShape(0, 12, 7, 16, 13, 9), Block.makeCuboidShape(1, 3, 6, 15, 12, 8), Block.makeCuboidShape(5, 4, 5, 11, 7, 7)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(7, 3, 0, 9, 12, 1), Block.makeCuboidShape(7, 1, 5, 9, 2, 11), Block.makeCuboidShape(6, 0, 4, 10, 1, 12), Block.makeCuboidShape(7, 3, 15, 9, 12, 16), Block.makeCuboidShape(7, 2, 0, 9, 3, 16), Block.makeCuboidShape(7, 12, 0, 9, 13, 16), Block.makeCuboidShape(6, 3, 1, 8, 12, 15), Block.makeCuboidShape(5, 4, 5, 7, 7, 11)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public SmallTV() {
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
