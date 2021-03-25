package com.stevenpaw.awesomeshop.objects.blocks;

import com.stevenpaw.awesomeshop.client.container.AwesomeShopContainer;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class PillarBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public static final BooleanProperty TOP = BlockStateProperties.OCCUPIED;
    public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;


    public PillarBlock(){
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f,1.0f)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .notSolid());
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(TOP, false).with(BOTTOM, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPE;
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
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            player.openContainer(state.getContainer(worldIn, pos));
            return ActionResultType.CONSUME;
        }
    }

    public static BlockState getValidBlockForPosition(BlockState currentState, IWorld worldIn, BlockPos pos) {
        BlockState blockstate = currentState;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(Direction direction : UPDATE_ORDER) {
            blockpos$mutable.setAndMove(pos, direction);
            blockstate = blockstate.updatePostPlacement(direction, worldIn.getBlockState(blockpos$mutable), worldIn, pos, blockpos$mutable);
        }

        return blockstate;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
            World world = context.getWorld();
            boolean flag = world.isBlockPowered(blockpos) || world.isBlockPowered(blockpos.up());
            return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(TOP, true).with(BOTTOM, true);
        } else {
            return null;
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        Boolean top = true;
        Boolean bottom = true;
        if(worldIn.getBlockState(pos.up()).getBlock().matchesBlock(this)){
            top = false;
        }
        if(worldIn.getBlockState(pos.down()).getBlock().matchesBlock(this)){
            bottom = false;
        }
        worldIn.setBlockState(pos.up(), state.with(TOP, top).with(BOTTOM, bottom), 3);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(TOP).add(BOTTOM);
    }
}
