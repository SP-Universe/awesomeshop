package com.stevenpaw.awesomeshop.blocks;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.util.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
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
import java.util.stream.Stream;

public class NightLamp extends Block {

    //Light Handling
    private static final IntegerProperty LIGHT = ModBlockStateProperties.LIGHTDIMMER; //BooleanProperty if Light is turned on
    private static final IntegerProperty COLOR = ModBlockStateProperties.COLOR;

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(6, 11, 6, 10, 13, 10), Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(7, 2, 7, 9, 11, 9), Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(4, 6, 4, 12, 9, 5), Block.makeCuboidShape(4, 6, 11, 12, 9, 12), Block.makeCuboidShape(4, 6, 5, 5, 9, 11), Block.makeCuboidShape(11, 6, 5, 12, 9, 11), Block.makeCuboidShape(5, 9, 6, 6, 11, 10), Block.makeCuboidShape(5, 9, 10, 11, 11, 11), Block.makeCuboidShape(5, 9, 5, 11, 11, 6), Block.makeCuboidShape(10, 9, 6, 11, 11, 10)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(6, 11, 6, 10, 13, 10), Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(7, 2, 7, 9, 11, 9), Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(4, 6, 4, 12, 9, 5), Block.makeCuboidShape(4, 6, 11, 12, 9, 12), Block.makeCuboidShape(4, 6, 5, 5, 9, 11), Block.makeCuboidShape(11, 6, 5, 12, 9, 11), Block.makeCuboidShape(5, 9, 6, 6, 11, 10), Block.makeCuboidShape(5, 9, 10, 11, 11, 11), Block.makeCuboidShape(5, 9, 5, 11, 11, 6), Block.makeCuboidShape(10, 9, 6, 11, 11, 10)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(6, 11, 6, 10, 13, 10), Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(7, 2, 7, 9, 11, 9), Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(4, 6, 4, 12, 9, 5), Block.makeCuboidShape(4, 6, 11, 12, 9, 12), Block.makeCuboidShape(4, 6, 5, 5, 9, 11), Block.makeCuboidShape(11, 6, 5, 12, 9, 11), Block.makeCuboidShape(5, 9, 6, 6, 11, 10), Block.makeCuboidShape(5, 9, 10, 11, 11, 11), Block.makeCuboidShape(5, 9, 5, 11, 11, 6), Block.makeCuboidShape(10, 9, 6, 11, 11, 10)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(6, 11, 6, 10, 13, 10), Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(7, 2, 7, 9, 11, 9), Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(4, 6, 4, 12, 9, 5), Block.makeCuboidShape(4, 6, 11, 12, 9, 12), Block.makeCuboidShape(4, 6, 5, 5, 9, 11), Block.makeCuboidShape(11, 6, 5, 12, 9, 11), Block.makeCuboidShape(5, 9, 6, 6, 11, 10), Block.makeCuboidShape(5, 9, 10, 11, 11, 11), Block.makeCuboidShape(5, 9, 5, 11, 11, 6), Block.makeCuboidShape(10, 9, 6, 11, 11, 10)).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public NightLamp() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f,4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0));

        this.setDefaultState(this.getDefaultState().with(LIGHT, Integer.valueOf(3)).with(COLOR,Integer.valueOf(6)));
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
                .with(LIGHT, 3).with(COLOR, 6).getBlockState();
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
        builder.add(FACING).add(LIGHT).add(COLOR);
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

            switch (heldItem.getItem().toString()) {
                case "cyan_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 0), 3);
                    break;
                case "purple_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 1), 3);
                    break;
                case "blue_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 2), 3);
                    break;
                case "brown_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 3), 3);
                    break;
                case "green_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 4), 3);
                    break;
                case "red_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 5), 3);
                    break;
                case "white_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 6), 3);
                    break;
                case "orange_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 7), 3);
                    break;
                case "magenta_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 8), 3);
                    break;
                case "light_blue_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 9), 3);
                    break;
                case "yellow_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 10), 3);
                    break;
                case "lime_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 11), 3);
                    break;
                case "pink_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 12), 3);
                    break;
                case "gray_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 13), 3);
                    break;
                case "light_gray_dye":
                    worldIn.setBlockState(pos, state.with(COLOR, 14), 3);
                    break;
                case "awesome_matter":
                    worldIn.setBlockState(pos, state.with(COLOR, 15), 3);
                    break;
                default:
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

            }

        } else {
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.CONSUME;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        worldIn.setBlockState(pos, BlockInit.NIGHT_LAMP.get().getDefaultState());
    }
}
