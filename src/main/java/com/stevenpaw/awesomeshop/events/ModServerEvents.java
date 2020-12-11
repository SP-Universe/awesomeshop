package com.stevenpaw.awesomeshop.events;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AwesomeShop.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

    @SubscribeEvent
    public static void OnServerChat(ServerChatEvent event)
    {

    }
}
