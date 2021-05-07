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

public class AdventWreath1 extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(3, 0, 6, 5, 2, 10),
            Block.makeCuboidShape(6, 0, 3, 10, 2, 5),
            Block.makeCuboidShape(11, 0, 6, 13, 2, 10),
            Block.makeCuboidShape(6, 0, 11, 10, 2, 13),
            Block.makeCuboidShape(7.5, 2, 3.5, 8.5, 6, 4.5),
            Block.makeCuboidShape(3.5, 2, 7.5, 4.5, 6, 8.5),
            Block.makeCuboidShape(11.5, 2, 7.5, 12.5, 6, 8.5),
            Block.makeCuboidShape(7.5, 2, 11.5, 8.5, 6, 12.5),
            Block.makeCuboidShape(3, 0, 3, 13, 2, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public AdventWreath1() {
        super(Properties.create(Material.GLASS)
                .hardnessAndResistance(3.5f,4.0f)
                .sound(SoundType.SOUL_SAND)
                .harvestLevel(0));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos po, ISelectionContext context)
    {
        return SHAPE_N;
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
