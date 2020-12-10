package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.util.enums.ModArmorMaterial;
import com.stevenpaw.awesomeshop.blocks.BlockItemBase;
import com.stevenpaw.awesomeshop.items.ItemBase;
import com.stevenpaw.awesomeshop.items.PoisonApple;
import com.stevenpaw.awesomeshop.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AwesomeShop.MOD_ID);


    // ITEMS
    //public static final RegistryObject<Item> NAME_OF_ITEM = ITEMS.register("name_of_item", ItemBase::new); - Registers an Item
    public static final RegistryObject<Item> AWESOMNIUM_CRYSTAL = ITEMS.register("awesomnium_crystal", ItemBase::new);
    public static final RegistryObject<Item> DEPRESSNIUM_CRYSTAL = ITEMS.register("depressnium_crystal", ItemBase::new);
    public static final RegistryObject<Item> AWESOMNIUM_PARTICLES = ITEMS.register("awesomnium_particles", ItemBase::new);
    public static final RegistryObject<Item> DEPRESSNIUM_PARTICLES = ITEMS.register("depressnium_particles", ItemBase::new);
    public static final RegistryObject<Item> AWESOME_CORE = ITEMS.register("awesome_core", ItemBase::new);
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register("poison_apple", PoisonApple::new);
    public static final RegistryObject<Item> DUCATIUM_SLIME = ITEMS.register("ducatium_slime", ItemBase::new);
    public static final RegistryObject<Item> AWESOMNIUM_STICK = ITEMS.register("awesomnium_stick", ItemBase::new);
    public static final RegistryObject<Item> DEPRESSNIUM_STICK = ITEMS.register("depressnium_stick", ItemBase::new);
    public static final RegistryObject<Item> HIGHLIGHTER = ITEMS.register("highlighter", ItemBase::new);
    public static final RegistryObject<Item> AWESOME_MATTER = ITEMS.register("awesome_matter", ItemBase::new);
    public static final RegistryObject<Item> DEPRESSING_MATTER = ITEMS.register("depressing_matter", ItemBase::new);


    //TOOLS
    // attackSpeed base is 4 (so make it faster with negative number)
    //Swords:
    public static final RegistryObject<SwordItem> AWESOMNIUM_SWORD = ITEMS.register("awesomnium_sword",
            () -> new SwordItem(ModItemTier.AWESOMNIUM, 2, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<SwordItem> DEPRESSNIUM_SWORD = ITEMS.register("depressnium_sword",
            () -> new SwordItem(ModItemTier.DEPRESSNIUM, 2, -2.4F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Pickaxes:
    public static final RegistryObject<PickaxeItem> AWESOMNIUM_PICKAXE = ITEMS.register("awesomnium_pickaxe",
            () -> new PickaxeItem(ModItemTier.AWESOMNIUM, 0, -2.8F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<PickaxeItem> DEPRESSNIUM_PICKAXE = ITEMS.register("depressnium_pickaxe",
            () -> new PickaxeItem(ModItemTier.DEPRESSNIUM, 0, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Shovels:
    public static final RegistryObject<ShovelItem> AWESOMNIUM_SHOVEL = ITEMS.register("awesomnium_shovel",
            () -> new ShovelItem(ModItemTier.AWESOMNIUM, 0.5F, -2.8F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ShovelItem> DEPRESSNIUM_SHOVEL = ITEMS.register("depressnium_shovel",
            () -> new ShovelItem(ModItemTier.DEPRESSNIUM, 0.5F, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Axes:
    public static final RegistryObject<AxeItem> AWESOMNIUM_AXE = ITEMS.register("awesomnium_axe",
            () -> new AxeItem(ModItemTier.AWESOMNIUM, 5, -2.8F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<AxeItem> DEPRESSNIUM_AXE = ITEMS.register("depressnium_axe",
            () -> new AxeItem(ModItemTier.DEPRESSNIUM, 5, -2.6F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    //Hoes:
    public static final RegistryObject<HoeItem> AWESOMNIUM_HOE = ITEMS.register("awesomnium_hoe",
            () -> new HoeItem(ModItemTier.AWESOMNIUM, 0, -1.0F, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<HoeItem> DEPRESSNIUM_HOE = ITEMS.register("depressnium_hoe",
            () -> new HoeItem(ModItemTier.DEPRESSNIUM, -3, -1.0F, new Item.Properties().group(AwesomeShop.ITEMTAB)));



    //ARMOR
    //
    public static final RegistryObject<ArmorItem> AWESOMNIUM_HELMET = ITEMS.register("awesomnium_helmet",
            () -> new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.HEAD, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ArmorItem> AWESOMNIUM_CHESTPLATE = ITEMS.register("awesomnium_chestplate",
            () -> new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.CHEST, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ArmorItem> AWESOMNIUM_LEGGINGS = ITEMS.register("awesomnium_leggings",
            () -> new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.LEGS, new Item.Properties().group(AwesomeShop.ITEMTAB)));
    public static final RegistryObject<ArmorItem> AWESOMNIUM_BOOTS = ITEMS.register("awesomnium_boots",
            () -> new ArmorItem(ModArmorMaterial.AWESOMNIUM, EquipmentSlotType.FEET, new Item.Properties().group(AwesomeShop.ITEMTAB)));



    //BLOCK ITEMS
    public static final RegistryObject<Item> AWESOMNIUM_ORE_ITEM = ITEMS.register("awesomnium_ore",
            () -> new BlockItemBase(ModBlocks.AWESOMNIUM_ORE.get()));
    public static final RegistryObject<Item> DUCATIUM_ORE_ITEM = ITEMS.register("ducatium_ore",
            () -> new BlockItemBase(ModBlocks.DUCATIUM_ORE.get()));
    public static final RegistryObject<Item> AWESOMNIUM_BLOCK_ITEM = ITEMS.register("awesomnium_block",
            () -> new BlockItemBase(ModBlocks.AWESOMNIUM_BLOCK.get()));
    public static final RegistryObject<Item> AWESOMNIUM_BLOCK_DIAGONAL_ITEM = ITEMS.register("awesomnium_block_diagonal",
            () -> new BlockItemBase(ModBlocks.AWESOMNIUM_BLOCK_DIAGONAL.get()));
    //public static final RegistryObject<Item> SHREDDER_ITEM = ITEMS.register("shredder",
    //        () -> new BlockItemBase(ModBlocks.SHREDDER.get()));
    public static final RegistryObject<Item> SHOWER_HEAD_ITEM = ITEMS.register("shower_head",
            () -> new BlockItemBase(ModBlocks.SHOWER_HEAD.get()));
    public static final RegistryObject<Item> SHOWER_FAUCET1_ITEM = ITEMS.register("shower_faucet1",
            () -> new BlockItemBase(ModBlocks.SHOWER_FAUCET1.get()));
    public static final RegistryObject<Item> SHOWER_FAUCET2_ITEM = ITEMS.register("shower_faucet2",
            () -> new BlockItemBase(ModBlocks.SHOWER_FAUCET2.get()));
    public static final RegistryObject<Item> SMALL_TV_ITEM = ITEMS.register("small_tv",
            () -> new BlockItemBase(ModBlocks.SMALL_TV.get()));
    public static final RegistryObject<Item> BRICK_OVEN_ITEM = ITEMS.register("brick_oven",
            () -> new BlockItemBase(ModBlocks.BRICK_OVEN.get()));
    public static final RegistryObject<Item> BRICK_OVEN_TUBE_ITEM = ITEMS.register("brick_oven_tube",
            () -> new BlockItemBase(ModBlocks.BRICK_OVEN_TUBE.get()));
    public static final RegistryObject<Item> DOORMAT_ITEM = ITEMS.register("doormat",
            () -> new BlockItemBase(ModBlocks.DOORMAT.get()));
    public static final RegistryObject<Item> SWITCH_ITEM = ITEMS.register("switch",
            () -> new BlockItemBase(ModBlocks.SWITCH.get()));
    public static final RegistryObject<Item> PC_SETUP_ITEM = ITEMS.register("pc_setup",
            () -> new BlockItemBase(ModBlocks.PC_SETUP.get()));

    //Flags
    public static final RegistryObject<Item> DRUGAR_FLAG_ITEM = ITEMS.register("drugar_flag",
            () -> new BlockItemBase(ModBlocks.DRUGAR_FLAG.get()));
    public static final RegistryObject<Item> GERMAN_FLAG_ITEM = ITEMS.register("german_flag",
            () -> new BlockItemBase(ModBlocks.GERMAN_FLAG.get()));
    public static final RegistryObject<Item> USA_FLAG_ITEM = ITEMS.register("usa_flag",
            () -> new BlockItemBase(ModBlocks.USA_FLAG.get()));
    public static final RegistryObject<Item> GAY_FLAG_ITEM = ITEMS.register("gay_flag",
            () -> new BlockItemBase(ModBlocks.GAY_FLAG.get()));
    public static final RegistryObject<Item> BI_FLAG_ITEM = ITEMS.register("bi_flag",
            () -> new BlockItemBase(ModBlocks.BI_FLAG.get()));
    public static final RegistryObject<Item> PAN_FLAG_ITEM = ITEMS.register("pan_flag",
            () -> new BlockItemBase(ModBlocks.PAN_FLAG.get()));
}
