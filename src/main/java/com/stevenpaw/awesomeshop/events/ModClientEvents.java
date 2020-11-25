package com.stevenpaw.awesomeshop.events;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.util.Hand.MAIN_HAND;

@Mod.EventBusSubscriber(modid = AwesomeShop.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModClientEvents
{
    @SubscribeEvent
    public static void onInteractEntity(PlayerInteractEvent.EntityInteract event)
    {
        PlayerEntity player = event.getPlayer();

        Item usedItem;

        if(event.getHand() == MAIN_HAND)
        {
            usedItem = player.getHeldItemMainhand().getItem();
        } else {
            usedItem = player.getHeldItemOffhand().getItem();
        }

        if(!player.world.isRemote) {
            if (usedItem == ModItems.HIGHLIGHTER.get()) {
                Entity target = (Entity) event.getTarget();

                if (target.isGlowing()) {
                    target.setGlowing(false);
                } else {
                    target.setGlowing(true);
                }

                event.setCanceled(true);
            }
        }
    }
}
