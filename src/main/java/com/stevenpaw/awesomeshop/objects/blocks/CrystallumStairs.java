package com.stevenpaw.awesomeshop.objects.blocks;

import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.CrystallumInit;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock.Properties;

public class CrystallumStairs extends StairsBlock {

    //hardness:         how easy it is to mine block
    //resistance:       how easy it can be destroyed by TNT
    //sound:            how the block sounds
    //harvestLevel:     1-Wood, 2-Stone, 3-Iron/Gold, 4-Diamond | What you need to harvest the block
    //harvestTool:      What kind of Tool you need to harvest the block

    public CrystallumStairs() {
        super(CrystallumInit.BLACK_CRYSTALLUM.get().getDefaultState(),
                Properties.create(Material.CLAY)
                .hardnessAndResistance(0.5f,2.0f)
                .sound(SoundType.GLASS)
                .harvestLevel(0)
                .setLightLevel(value -> 10)
                .notSolid()
        );
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }
}
