package com.stevenpaw.awesomeshop.objects.blocks.ModernLamp;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.util.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ModernWallLamp1 extends Block {

    //Light Handling
    private static final IntegerProperty LIGHT = ModBlockStateProperties.LIGHTDIMMER; //BooleanProperty if Light is turned on
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4.5, 0, 8.5, 11.5, 16, 13.5), Block.makeCuboidShape(6.5, 2, 13, 9.5, 14, 16), IBooleanFunction.OR);
    private static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(8.5, 0, 4.5, 13.5, 16, 11.5), Block.makeCuboidShape(13, 2, 6.5, 16, 14, 9.5), IBooleanFunction.OR);
    private static final VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4.5, 0, 2.5, 11.5, 16, 7.5), Block.makeCuboidShape(6.5, 2, 0, 9.5, 14, 3), IBooleanFunction.OR);
    private static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2.5, 0, 4.5, 7.5, 16, 11.5), Block.makeCuboidShape(0, 2, 6.5, 3, 14, 9.5), IBooleanFunction.OR);

    public ModernWallLamp1() {
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
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite())
                .with(LIGHT, 3).getBlockState();
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
        builder.add(FACING).add(LIGHT);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        int lightValue = 0;

        switch (state.get(LIGHT)){
            case 0:
                lightValue = 0;
                break;
            case 1:
                lightValue = 5;
                break;
            case 2:
                lightValue = 10;
                break;
            default:
                lightValue = 15;
                break;
        }

        return lightValue;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {

        if(!worldIn.isRemote) {

            ItemStack heldItem = player.getHeldItem(hand);

            AwesomeShop.LOGGER.debug("ITEM:" + heldItem.getItem().toString());
                    switch (state.get(LIGHT)) {
                        case 0:
                            worldIn.setBlockState(pos, state.with(LIGHT, 1), 3);
                            break;
                        case 1:
                            worldIn.setBlockState(pos, state.with(LIGHT, 2), 3);
                            break;
                        case 2:
                            worldIn.setBlockState(pos, state.with(LIGHT, 3), 3);
                            break;
                        default:
                            worldIn.setBlockState(pos, state.with(LIGHT, 0), 3);
                            break;
                    }
                    return ActionResultType.CONSUME;
        } else {
            return ActionResultType.SUCCESS;
        }
    }
}
