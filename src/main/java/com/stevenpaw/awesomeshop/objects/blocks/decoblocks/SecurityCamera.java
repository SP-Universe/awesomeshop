package com.stevenpaw.awesomeshop.objects.blocks.decoblocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BellAttachment;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.BellTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public class SecurityCamera extends Block {

    public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<BellAttachment> ATTACHMENT = BlockStateProperties.BELL_ATTACHMENT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private static final VoxelShape SHAPE_N = Block.makeCuboidShape(2, 2, 2, 14, 14, 14);


    public SecurityCamera() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f,2.0f)
                .sound(SoundType.STONE)
                .harvestLevel(0));
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(ATTACHMENT, BellAttachment.FLOOR).with(POWERED, Boolean.valueOf(false)));
    }

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = worldIn.isBlockPowered(pos);
        worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)), 3);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPE_N;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getFace();
        BlockPos blockpos = context.getPos();
        World world = context.getWorld();
        Direction.Axis direction$axis = direction.getAxis();
        if (direction$axis == Direction.Axis.Y) {
            BlockState blockstate = this.getDefaultState().with(ATTACHMENT, direction == Direction.DOWN ? BellAttachment.CEILING : BellAttachment.FLOOR).with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
            if (blockstate.isValidPosition(context.getWorld(), blockpos)) {
                return blockstate;
            }
        } else {
            boolean flag = direction$axis == Direction.Axis.X && world.getBlockState(blockpos.west()).isSolidSide(world, blockpos.west(), Direction.EAST) && world.getBlockState(blockpos.east()).isSolidSide(world, blockpos.east(), Direction.WEST) || direction$axis == Direction.Axis.Z && world.getBlockState(blockpos.north()).isSolidSide(world, blockpos.north(), Direction.SOUTH) && world.getBlockState(blockpos.south()).isSolidSide(world, blockpos.south(), Direction.NORTH);
            BlockState blockstate1 = this.getDefaultState().with(HORIZONTAL_FACING, direction.getOpposite()).with(ATTACHMENT, flag ? BellAttachment.DOUBLE_WALL : BellAttachment.SINGLE_WALL);
            if (blockstate1.isValidPosition(context.getWorld(), context.getPos())) {
                return blockstate1;
            }

            boolean flag1 = world.getBlockState(blockpos.down()).isSolidSide(world, blockpos.down(), Direction.UP);
            blockstate1 = blockstate1.with(ATTACHMENT, flag1 ? BellAttachment.FLOOR : BellAttachment.CEILING);
            if (blockstate1.isValidPosition(context.getWorld(), context.getPos())) {
                return blockstate1;
            }
        }

        return null;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(HORIZONTAL_FACING, ATTACHMENT, POWERED);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }

    private static Direction getDirectionFromState(BlockState state) {
        switch((BellAttachment)state.get(ATTACHMENT)) {
            case FLOOR:
                return Direction.UP;
            case CEILING:
                return Direction.DOWN;
            default:
                return state.get(HORIZONTAL_FACING).getOpposite();
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader world, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            super.addInformation(stack, world, tooltip, flag);
            tooltip.add(new StringTextComponent(TextFormatting.BLUE + "A mat for your door"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "Shift" + "\u00A77" + " for More Information")); //"\u00A7e" is a color code
        }
    }
}
