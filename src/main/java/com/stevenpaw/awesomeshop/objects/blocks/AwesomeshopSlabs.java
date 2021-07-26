package com.stevenpaw.awesomeshop.objects.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;

public class AwesomeshopSlabs extends SlabBlock {

    public AwesomeshopSlabs(){
        super(Properties.create(Material.WOOD)
                        .hardnessAndResistance(0.5f,2.0f)
                        .sound(SoundType.WOOD)
                        .harvestLevel(0)
                        .setLightLevel(value -> 10)
                        .notSolid()
        );
    }
}
