package com.stevenpaw.awesomeshop.objects.blocks;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AwesomeshopDoor extends DoorBlock {

    public AwesomeshopDoor(){
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(1.0f,2.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .notSolid()
        );
    }
}
