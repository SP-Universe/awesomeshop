package com.stevenpaw.awesomeshop.util;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.blocks.AwesomniumBlock;
import com.stevenpaw.awesomeshop.blocks.AwesomniumOre;
import com.stevenpaw.awesomeshop.blocks.BlockItemBase;
import com.stevenpaw.awesomeshop.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AwesomeShop.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // ITEMS
    //public static final RegistryObject<Item> NAME_OF_ITEM = ITEMS.register("name_of_item", ItemBase::new); - Registers an Item
    public static final RegistryObject<Item> AWESOMNIUM_CRYSTAL = ITEMS.register("awesomnium_crystal", ItemBase::new);
    public static final RegistryObject<Item> DEPRESSNIUM_CRYSTAL = ITEMS.register("depressnium_crystal", ItemBase::new);


    // BLOCKS
    // public static final RegistryObject<Block> NAME_OF_BLOCK = BLOCKS.register("name_of_block", NameOfBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_ORE = BLOCKS.register("awesomnium_ore", AwesomniumOre::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK = BLOCKS.register("awesomnium_block", AwesomniumBlock::new);


    //BLOCK ITEMS
    //
    public static final RegistryObject<Item> AWESOMNIUM_ORE_ITEM = ITEMS.register("awesomnium_ore", () -> new BlockItemBase(AWESOMNIUM_ORE.get()));
    public static final RegistryObject<Item> AWESOMNIUM_BLOCK_ITEM = ITEMS.register("awesomnium_block", () -> new BlockItemBase(AWESOMNIUM_BLOCK.get()));
}
