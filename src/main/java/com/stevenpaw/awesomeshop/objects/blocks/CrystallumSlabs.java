package com.stevenpaw.awesomeshop.objects.blocks;

import com.stevenpaw.awesomeshop.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import net.minecraft.block.AbstractBlock.Properties;

public class CrystallumSlabs extends SlabBlock {

    //hardness:         how easy it is to mine block
    //resistance:       how easy it can be destroyed by TNT
    //sound:            how the block sounds
    //harvestLevel:     1-Wood, 2-Stone, 3-Iron/Gold, 4-Diamond | What you need to harvest the block
    //harvestTool:      What kind of Tool you need to harvest the block

    public CrystallumSlabs() {
        super(Properties.create(Material.CLAY)
                .hardnessAndResistance(0.5f,2.0f)
                .sound(SoundType.GLASS)
                .harvestLevel(0)
                .notSolid()
        );
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return 0.6f;
    }
}
