package com.stevenpaw.awesomeshop.objects.blocks.flags;

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

import net.minecraft.block.AbstractBlock.Properties;

public class BiFlag extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(2, 0, 7, 4, 16, 9), Block.makeCuboidShape(4, 8, 7, 7, 15, 8), Block.makeCuboidShape(7, 8, 8, 11, 15, 9), Block.makeCuboidShape(11, 8, 7, 14, 15, 8)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(7, 0, 2, 9, 16, 4), Block.makeCuboidShape(8, 8, 4, 9, 15, 7), Block.makeCuboidShape(7, 8, 7, 8, 15, 11), Block.makeCuboidShape(8, 8, 11, 9, 15, 14)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(12, 0, 7, 14, 16, 9), Block.makeCuboidShape(9, 8, 8, 12, 15, 9), Block.makeCuboidShape(5, 8, 7, 9, 15, 8), Block.makeCuboidShape(2, 8, 8, 5, 15, 9)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(7, 0, 12, 9, 16, 14), Block.makeCuboidShape(7, 8, 9, 8, 15, 12), Block.makeCuboidShape(8, 8, 5, 9, 15, 9), Block.makeCuboidShape(7, 8, 2, 8, 15, 5)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BiFlag() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f,4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
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
