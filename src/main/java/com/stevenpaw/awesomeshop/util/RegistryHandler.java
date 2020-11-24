package com.stevenpaw.awesomeshop.util;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.armor.ModArmorMaterial;
import com.stevenpaw.awesomeshop.blocks.*;
import com.stevenpaw.awesomeshop.items.ItemBase;
import com.stevenpaw.awesomeshop.items.PoisonApple;
import com.stevenpaw.awesomeshop.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
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
    public static final RegistryObject<Item> AWESOMNIUM_PARTICLES = ITEMS.register("awesomnium_particles", ItemBase::new);
    public static final RegistryObject<Item> DEPRESSNIUM_PARTICLES = ITEMS.register("depressnium_particles", ItemBase::new);
    public static final RegistryObject<Item> AWESOME_CORE = ITEMS.register("awesome_core", ItemBase::new);
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("poison_apple", PoisonApple::new);
    public static final RegistryObject<Item> DUCATIUM_SLIME = ITEMS.register("ducatium_slime", ItemBase::new);


    //TOOLS
    // attackSpeed base is 4 (so make it faster with negative number)
    //Swords:
    public static final RegistryObject<SwordItem> AWESOMNIUM_SWORD = ITEMS.register("awesomnium_sword", () ->
            new SwordItem(ModItemTier.AWESOMNIUM, 2, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<SwordItem> DEPRESSNIUM_SWORD = ITEMS.register("depressnium_sword", () ->
            new SwordItem(ModItemTier.DEPRESSNIUM, 2, -2.4F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Pickaxes:
    public static final RegistryObject<PickaxeItem> AWESOMNIUM_PICKAXE = ITEMS.register("awesomnium_pickaxe", () ->
            new PickaxeItem(ModItemTier.AWESOMNIUM, 0, -2.8F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<PickaxeItem> DEPRESSNIUM_PICKAXE = ITEMS.register("depressnium_pickaxe", () ->
            new PickaxeItem(ModItemTier.DEPRESSNIUM, 0, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Shovels:
    public static final RegistryObject<ShovelItem> AWESOMNIUM_SHOVEL = ITEMS.register("awesomnium_shovel", () ->
            new ShovelItem(ModItemTier.AWESOMNIUM, 0.5F, -2.8F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ShovelItem> DEPRESSNIUM_SHOVEL = ITEMS.register("depressnium_shovel", () ->
            new ShovelItem(ModItemTier.DEPRESSNIUM, 0.5F, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Axes:
    public static final RegistryObject<AxeItem> AWESOMNIUM_AXE = ITEMS.register("awesomnium_axe", () ->
            new AxeItem(ModItemTier.AWESOMNIUM, 5, -2.8F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<AxeItem> DEPRESSNIUM_AXE = ITEMS.register("depressnium_axe", () ->
            new AxeItem(ModItemTier.DEPRESSNIUM, 5, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Hoes:
    public static final RegistryObject<HoeItem> AWESOMNIUM_HOE = ITEMS.register("awesomnium_hoe", () ->
            new HoeItem(ModItemTier.AWESOMNIUM, 0, -1.0F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<HoeItem> DEPRESSNIUM_HOE = ITEMS.register("depressnium_hoe", () ->
            new HoeItem(ModItemTier.DEPRESSNIUM, -3, -1.0F, new Item.Properties().group(AwesomeShop.ITEMTAB)));



    //ARMOR
    //
    public static final RegistryObject<ArmorItem> AWESOMNIUM_HELMET = ITEMS.register("awesomnium_helmet", () ->
            new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.HEAD, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ArmorItem> AWESOMNIUM_CHESTPLATE = ITEMS.register("awesomnium_chestplate", () ->
            new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.CHEST, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ArmorItem> AWESOMNIUM_LEGGINGS = ITEMS.register("awesomnium_leggings", () ->
            new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.LEGS, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ArmorItem> AWESOMNIUM_BOOTS = ITEMS.register("awesomnium_boots", () ->
            new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.FEET, new Item.Properties().group(AwesomeShop.ITEMTAB)));



    // BLOCKS
    // public static final RegistryObject<Block> NAME_OF_BLOCK = BLOCKS.register("name_of_block", NameOfBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_ORE = BLOCKS.register("awesomnium_ore", AwesomniumOre::new);
    public static final RegistryObject<Block> DUCATIUM_ORE = BLOCKS.register("ducatium_ore", DucatiumOre::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK = BLOCKS.register("awesomnium_block", AwesomniumBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK_DIAGONAL = BLOCKS.register("awesomnium_block_diagonal", AwesomniumBlockDiagonal::new);

    //BLOCK ITEMS
    public static final RegistryObject<Item> AWESOMNIUM_ORE_ITEM = ITEMS.register("awesomnium_ore", ()
            -> new BlockItemBase(AWESOMNIUM_ORE.get()));
    public static final RegistryObject<Item> DUCATIUM_ORE_ITEM = ITEMS.register("ducatium_ore", ()
            -> new BlockItemBase(DUCATIUM_ORE.get()));
    public static final RegistryObject<Item> AWESOMNIUM_BLOCK_ITEM = ITEMS.register("awesomnium_block", ()
            -> new BlockItemBase(AWESOMNIUM_BLOCK.get()));
    public static final RegistryObject<Item> AWESOMNIUM_BLOCK_DIAGONAL_ITEM = ITEMS.register("awesomnium_block_diagonal", ()
            -> new BlockItemBase(AWESOMNIUM_BLOCK_DIAGONAL.get()));
}
