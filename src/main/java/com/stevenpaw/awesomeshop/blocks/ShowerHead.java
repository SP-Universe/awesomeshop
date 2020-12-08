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
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ShowerHead extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(6.999, 12.02731, 9.94358, 8.999, 14.02731, 15.94358), Block.makeCuboidShape(5.999, 10.3, 8.6, 10.009, 11.3, 12.6), Block.makeCuboidShape(7.05, 11.3, 9.6, 8.95, 13.3, 11.6), Block.makeCuboidShape(4.999, 9.3, 8.6, 6.009, 10.3, 12.6), Block.makeCuboidShape(9.999, 9.3, 8.6, 11.009, 10.3, 12.6), Block.makeCuboidShape(5.999, 9.3001, 7.6, 10.009, 10.3011, 8.6), Block.makeCuboidShape(5.999, 9.3001, 12.6, 10.009, 10.3011, 13.6)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(9.94358, 12.02731, 7.0009999999999994, 15.94358, 14.02731, 9.001000000000001), Block.makeCuboidShape(7.899647709210958, 10.714699023660526, 5.991, 11.899647709210958, 11.714699023660526, 10.001000000000001), Block.makeCuboidShape(8.899647709210958, 11.714699023660526, 7.050000000000001, 10.899647709210958, 13.714699023660526, 8.95), Block.makeCuboidShape(7.899647709210958, 9.714699023660526, 9.991, 11.899647709210958, 10.714699023660526, 11.001000000000001), Block.makeCuboidShape(7.899647709210958, 9.714699023660526, 4.991, 11.899647709210958, 10.714699023660526, 6.0009999999999994), Block.makeCuboidShape(6.899647709210958, 9.714799023660525, 5.991, 7.899647709210958, 10.715799023660525, 10.001000000000001), Block.makeCuboidShape(11.899647709210958, 9.714799023660525, 5.991, 12.899647709210958, 10.715799023660525, 10.001000000000001)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(7.0009999999999994, 12.02731, 0.05641999999999925, 9.001000000000001, 14.02731, 6.056419999999999), Block.makeCuboidShape(5.991, 10.714699023660526, 4.100352290789042, 10.001000000000001, 11.714699023660526, 8.100352290789042), Block.makeCuboidShape(7.050000000000001, 11.714699023660526, 5.100352290789042, 8.95, 13.714699023660526, 7.100352290789042), Block.makeCuboidShape(9.991, 9.714699023660526, 4.100352290789042, 11.001000000000001, 10.714699023660526, 8.100352290789042), Block.makeCuboidShape(4.991, 9.714699023660526, 4.100352290789042, 6.0009999999999994, 10.714699023660526, 8.100352290789042), Block.makeCuboidShape(5.991, 9.714799023660525, 8.100352290789042, 10.001000000000001, 10.715799023660525, 9.100352290789042), Block.makeCuboidShape(5.991, 9.714799023660525, 3.1003522907890417, 10.001000000000001, 10.715799023660525, 4.100352290789042)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(0.05641999999999925, 12.02731, 6.999, 6.056419999999999, 14.02731, 8.999), Block.makeCuboidShape(4.100352290789042, 10.714699023660526, 5.999, 8.100352290789042, 11.714699023660526, 10.009), Block.makeCuboidShape(5.100352290789042, 11.714699023660526, 7.05, 7.100352290789042, 13.714699023660526, 8.95), Block.makeCuboidShape(4.100352290789042, 9.714699023660526, 4.999, 8.100352290789042, 10.714699023660526, 6.009), Block.makeCuboidShape(4.100352290789042, 9.714699023660526, 9.999, 8.100352290789042, 10.714699023660526, 11.009), Block.makeCuboidShape(8.100352290789042, 9.714799023660525, 5.999, 9.100352290789042, 10.715799023660525, 10.009), Block.makeCuboidShape(3.1003522907890417, 9.714799023660525, 5.999, 4.100352290789042, 10.715799023660525, 10.009)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ShowerHead() {
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
