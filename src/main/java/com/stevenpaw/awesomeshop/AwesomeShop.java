package com.stevenpaw.awesomeshop;

import com.stevenpaw.awesomeshop.container.ShredderContainer;
import com.stevenpaw.awesomeshop.init.*;
import com.stevenpaw.awesomeshop.world.gen.ModOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("awesomeshop")
public class AwesomeShop
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "awesomeshop";

    public static IEventBus MOD_EVENT_BUS;

    public AwesomeShop()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(MOD_EVENT_BUS);
        ModItems.ITEMS.register(MOD_EVENT_BUS);

        registerCommonEvents();
        DistExecutor.runWhenOn(Dist.CLIENT, () -> AwesomeShop::registerClientOnlyEvents);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ModOreGen.registerOres();
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    }

    //Creating Custom Inventory Tabs
    public static final ItemGroup ITEMTAB = new ItemGroup("awesomeshopItemTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.AWESOMNIUM_CRYSTAL.get());
        }
    };

    public static final ItemGroup BLOCKTAB = new ItemGroup("awesomeshopBlockTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.AWESOMNIUM_BLOCK.get());
        }
    };


    public static void registerCommonEvents() {
        MOD_EVENT_BUS.register(StartupCommon.class);
    }

    public static void registerClientOnlyEvents() {
        MOD_EVENT_BUS.register(StartupClientOnly.class);
    }
}
