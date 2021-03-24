package com.stevenpaw.awesomeshop.objects.blocks.decoblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public class Piano extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(-10, 11, 0, 11, 21, 32), Block.makeCuboidShape(-10, 11, -5, 26, 15, 2), Block.makeCuboidShape(11, 11, 0, 26, 21, 17), Block.makeCuboidShape(22, 0, 0, 24, 10, 2), Block.makeCuboidShape(-8, 0, 0, -6, 10, 2), Block.makeCuboidShape(-3, 0, 24, -1, 10, 26), Block.makeCuboidShape(11, 11, 17, 23, 21, 22), Block.makeCuboidShape(11, 11, 22, 16, 21, 29), Block.makeCuboidShape(16, 11, 22, 20, 21, 26)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(0, 11, 5, 32, 21, 26), Block.makeCuboidShape(-5, 11, -10, 2, 15, 26), Block.makeCuboidShape(0, 11, -10, 17, 21, 5), Block.makeCuboidShape(0, 0, -8, 2, 10, -6), Block.makeCuboidShape(0, 0, 22, 2, 10, 24), Block.makeCuboidShape(24, 0, 17, 26, 10, 19), Block.makeCuboidShape(17, 11, -7, 22, 21, 5), Block.makeCuboidShape(22, 11, 0, 29, 21, 5), Block.makeCuboidShape(22, 11, -4, 26, 21, 0)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(5, 11, -16, 26, 21, 16), Block.makeCuboidShape(-10, 11, 14, 26, 15, 21), Block.makeCuboidShape(-10, 11, -1, 5, 21, 16), Block.makeCuboidShape(-8, 0, 14, -6, 10, 16), Block.makeCuboidShape(22, 0, 14, 24, 10, 16), Block.makeCuboidShape(17, 0, -10, 19, 10, -8), Block.makeCuboidShape(-7, 11, -6, 5, 21, -1), Block.makeCuboidShape(0, 11, -13, 5, 21, -6), Block.makeCuboidShape(-4, 11, -10, 0, 21, -6)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(-16, 11, -10, 16, 21, 11), Block.makeCuboidShape(14, 11, -10, 21, 15, 26), Block.makeCuboidShape(-1, 11, 11, 16, 21, 26), Block.makeCuboidShape(14, 0, 22, 16, 10, 24), Block.makeCuboidShape(14, 0, -8, 16, 10, -6), Block.makeCuboidShape(-10, 0, -3, -8, 10, -1), Block.makeCuboidShape(-6, 11, 11, -1, 21, 23), Block.makeCuboidShape(-13, 11, 11, -6, 21, 16), Block.makeCuboidShape(-10, 11, 16, -6, 21, 20)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Piano() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(1.5f,1.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .notSolid());
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

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            super.addInformation(stack, world, tooltip, flag);
            tooltip.add(new StringTextComponent(TextFormatting.BLUE + "A Tree for Christmas"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information")); //"\u00A7e" is a color code
        }
    }
}
