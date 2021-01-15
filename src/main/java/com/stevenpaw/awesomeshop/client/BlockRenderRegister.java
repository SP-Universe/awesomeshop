package com.stevenpaw.awesomeshop.client;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.CrystallumInit;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister {
    public static void registerBlockRenderer() {
        RenderTypeLookup.setRenderLayer(CrystallumInit.RAW_CRYSTALLUM.get(), RenderType.getTranslucent());
    }
}
