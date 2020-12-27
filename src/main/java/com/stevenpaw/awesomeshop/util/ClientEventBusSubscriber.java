package com.stevenpaw.awesomeshop.util;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.client.gui.AwesomeChestScreen;
import com.stevenpaw.awesomeshop.client.gui.PresentScreen;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
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
    }
}
