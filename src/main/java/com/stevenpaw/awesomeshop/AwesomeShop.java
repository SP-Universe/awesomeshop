package com.stevenpaw.awesomeshop;

import com.stevenpaw.awesomeshop.init.ModBlocks;
import com.stevenpaw.awesomeshop.init.ModContainerTypes;
import com.stevenpaw.awesomeshop.init.ModItems;
import com.stevenpaw.awesomeshop.init.ModRecipeSerializers;
import com.stevenpaw.awesomeshop.world.gen.ModOreGen;
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
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "awesomeshop";

    public AwesomeShop()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //ModContainerTypes.CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

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
}
