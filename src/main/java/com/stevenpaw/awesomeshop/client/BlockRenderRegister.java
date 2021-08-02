package com.stevenpaw.awesomeshop.client;

import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.CrystallumInit;
import com.stevenpaw.awesomeshop.init.StreetInit;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.RegistryObject;

public class BlockRenderRegister {
    public static void registerBlockRenderer() {
        RenderTypeLookup.setRenderLayer(CrystallumInit.RAW_CRYSTALLUM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.SHREDDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.AWESOMESHOP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.GLASS_PILLAR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.AWESOME_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.MODERN_GLASS_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.SPOOKY_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.CHURCH_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.CLASSICAL_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.MODERN_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.AWESOME_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.CHAIN_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.CHURCH_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.CLASSICAL_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.MODERN_GLASS_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.MODERN_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.SPOOKY_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.CHANDELIER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(BlockInit.WASHING_MACHINE.get(), RenderType.getTranslucent());

        //Roadsigns
        StreetInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            setTransparent(block);
        });

    }
    public static void setTransparent(Block blockIn){
        RenderTypeLookup.setRenderLayer(blockIn, RenderType.getTranslucent());
    }
}
