package com.stevenpaw.awesomeshop.events;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.ModBlocks;
import com.stevenpaw.awesomeshop.init.ModItems;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AwesomeShop.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents
{
    @SubscribeEvent
    public static void onJumpWithAwesomeCore(LivingEvent.LivingJumpEvent event)
    {
        LivingEntity player = event.getEntityLiving();
        if(player.getHeldItemMainhand().getItem() == ModItems.AWESOME_CORE.get())
        {
            AwesomeShop.LOGGER.info("Player tried to jump with Awesome Core!");
            World world = player.getEntityWorld();
            world.setBlockState(player.getPosition().add(0,-1,0), ModBlocks.AWESOMNIUM_BLOCK.get().getDefaultState());
        }
    }

    @SubscribeEvent
    public static void onDamageEntity(AttackEntityEvent event)
    {
        if(event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.POISON_APPLE.get())
        {
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity) event.getTarget();

                if (target instanceof AnimalEntity)
                {
                    PlayerEntity player = event.getPlayer();
                    target.addPotionEffect(new EffectInstance(Effects.POISON, 10*20));
                    target.setFire(3);
                    target.setGlowing(true);

                    if(!event.getPlayer().getEntityWorld().isRemote)
                    {
                        String msg = TextFormatting.RED + "That animal isn't feeling so well...";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onCraftingTableOpen(GuiOpenEvent event)
    {
        if (event.isCancelable())
        {
            if (event.getGui() instanceof CraftingScreen)
            {
                event.setCanceled(true);
                AwesomeShop.LOGGER.info("Player tried to open a crafting table... what a fool!");
            }
        }
    }
}
