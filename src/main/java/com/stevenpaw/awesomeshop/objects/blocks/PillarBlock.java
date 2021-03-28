package com.stevenpaw.awesomeshop.objects.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PillarBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;


    public PillarBlock(){
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f,1.0f)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .notSolid());
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(OCCUPIED, false).with(BOTTOM, false));
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

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        if (blockpos.getY() < 255) {
            World world = context.getWorld();
            return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(OCCUPIED, true).with(BOTTOM, true);
        } else {
            return null;
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        Boolean top = false;
        Boolean bottom = false;
        if(worldIn.getBlockState(pos.up()).getBlock().getRegistryName().equals(this.getRegistryName())){
            top = true;
            PillarBlock pillar = (PillarBlock) worldIn.getBlockState(pos.up()).getBlock();
            pillar.UpdateModel(worldIn, pos.up(), state);
        }
        if(worldIn.getBlockState(pos.down()).getBlock().getRegistryName().equals(this.getRegistryName())){
            bottom = true;
            PillarBlock pillar = (PillarBlock) worldIn.getBlockState(pos.down()).getBlock();
            pillar.UpdateModel(worldIn, pos.down(), state);
        }
        worldIn.setBlockState(pos, state.with(OCCUPIED, top).with(BOTTOM, bottom), 3);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(worldIn.getBlockState(pos.up()).getBlock().getRegistryName().equals(this.getRegistryName())){
            PillarBlock pillar = (PillarBlock) worldIn.getBlockState(pos.up()).getBlock();
            pillar.UpdateModel(worldIn, pos.up(), state);
        }
        if(worldIn.getBlockState(pos.down()).getBlock().getRegistryName().equals(this.getRegistryName())){
            PillarBlock pillar = (PillarBlock) worldIn.getBlockState(pos.down()).getBlock();
            pillar.UpdateModel(worldIn, pos.down(), state);
        }

        worldIn.playEvent(player, 2001, pos, getStateId(state));
        if (this.isIn(BlockTags.GUARDED_BY_PIGLINS)) {
            PiglinTasks.func_234478_a_(player, false);
        }
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        if(worldIn.getBlockState(pos.up()).getBlock().getRegistryName().equals(this.getRegistryName())){
            PillarBlock pillar = (PillarBlock) worldIn.getBlockState(pos.up()).getBlock();
            pillar.UpdateModel((World) worldIn, pos.up(), state);
        }
        if(worldIn.getBlockState(pos.down()).getBlock().getRegistryName().equals(this.getRegistryName())){
            PillarBlock pillar = (PillarBlock) worldIn.getBlockState(pos.down()).getBlock();
            pillar.UpdateModel((World) worldIn, pos.down(), state);
        }
    }

    public void UpdateModel(World worldIn, BlockPos pos, BlockState state) {
        Boolean top = false;
        Boolean bottom = false;
        if(worldIn.getBlockState(pos.up()).getBlock().getRegistryName().equals(this.getRegistryName())){
            top = true;
        }
        if(worldIn.getBlockState(pos.down()).getBlock().getRegistryName().equals(this.getRegistryName())){
            bottom = true;
        }
        worldIn.setBlockState(pos, state.with(OCCUPIED, top).with(BOTTOM, bottom), 3);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(OCCUPIED).add(BOTTOM);
    }
}
