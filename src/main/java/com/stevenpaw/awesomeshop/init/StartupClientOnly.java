package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.containerScreens.ShredderContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class StartupClientOnly {
    // register the factory that is used on the client to generate a ContainerScreen corresponding to our Container
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(StartupCommon.shredderContainerType, ShredderContainerScreen::new);
    }
}
