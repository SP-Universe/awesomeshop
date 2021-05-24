package com.stevenpaw.awesomeshop;

import com.stevenpaw.awesomeshop.client.BlockRenderRegister;
import com.stevenpaw.awesomeshop.init.*;
import com.stevenpaw.awesomeshop.recipe.ModRecipeSerializer;
import com.stevenpaw.awesomeshop.world.gen.ModOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("awesomeshop")
@Mod.EventBusSubscriber(modid = AwesomeShop.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AwesomeShop {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "awesomeshop";
    public static AwesomeShop instance;

    public AwesomeShop() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        CrystallumInit.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);

        ModRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(AwesomeShop.BLOCKTAB);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        CrystallumInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(AwesomeShop.CRYSTALLUMTAB);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("[AWESOME SHOP] - Registered BlockItems!");
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModOreGen.registerOres();
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        BlockRenderRegister.registerBlockRenderer();
    }

    //Creating Custom Inventory Tabs
    public static final ItemGroup ITEMTAB = new ItemGroup("awesomeshopItemTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.AWESOMNIUM_CRYSTAL.get());
        }
    };

    public static final ItemGroup BLOCKTAB = new ItemGroup("awesomeshopBlockTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.AWESOMNIUM_BLOCK.get());
        }
    };

    public static final ItemGroup CRYSTALLUMTAB = new ItemGroup("awesomeshopCrystallumTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(CrystallumInit.RAW_CRYSTALLUM.get());
        }
    };
}
