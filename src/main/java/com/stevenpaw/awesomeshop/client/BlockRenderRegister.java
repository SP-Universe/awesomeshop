package com.stevenpaw.awesomeshop.client;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.CrystallumInit;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;

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
    }
}
