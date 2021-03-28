package com.stevenpaw.awesomeshop.util;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.client.gui.*;
import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import com.stevenpaw.awesomeshop.objects.blocks.CardboardBox;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AwesomeShop.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        ScreenManager.registerFactory(ModContainerTypes.AWESOME_CHEST.get(), AwesomeChestScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.PRESENT.get(), PresentScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.CARDBOARD_BOX.get(), CardboardBoxScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.SHREDDER.get(), ShredderScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.AWESOMESHOP.get(), AwesomeShopScreen::new);
        ScreenManager.registerFactory(ModContainerTypes.TRASHCAN.get(), TrashCanScreen::new);
    }
}
