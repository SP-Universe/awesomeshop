package com.stevenpaw.awesomeshop.objects.blocks;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;

public class AwesomeshopTrapDoor extends TrapDoorBlock {

    public AwesomeshopTrapDoor(){
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(1.0f,2.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .notSolid()
        );
    }
}
