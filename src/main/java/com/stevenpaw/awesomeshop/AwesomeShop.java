package com.stevenpaw.awesomeshop;

import com.stevenpaw.awesomeshop.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("awesomeshop")
public class AwesomeShop
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "awesomeshop";

    public AwesomeShop()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init(); //Starts registering all kinds of stuff

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    }

    //Creating Custom Inventory Tabs
    public static final ItemGroup ITEMTAB = new ItemGroup("awesomeshopItemTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(RegistryHandler.AWESOMNIUM_CRYSTAL.get());
        }
    };

    public static final ItemGroup BLOCKTAB = new ItemGroup("awesomeshopBlockTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(RegistryHandler.AWESOMNIUM_ORE.get());
        }
    };
}
