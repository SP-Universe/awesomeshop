package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.objects.blocks.*;
import com.stevenpaw.awesomeshop.objects.blocks.ModernLamp.*;
import com.stevenpaw.awesomeshop.objects.blocks.decoblocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);


    public static final RegistryObject<Block> SHREDDER = BLOCKS.register("shredder", Shredder::new);
    public static final RegistryObject<Block> AWESOMESHOP = BLOCKS.register("awesomeshop", AwesomeShopBlock::new);

    // BLOCKS
    // public static final RegistryObject<Block> NAME_OF_BLOCK = BLOCKS.register("name_of_block", NameOfBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_ORE = BLOCKS.register("awesomnium_ore", AwesomniumOre::new);
    public static final RegistryObject<Block> DUCATIUM_ORE = BLOCKS.register("ducatium_ore", DucatiumOre::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK = BLOCKS.register("awesomnium_block", AwesomniumBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK_DIAGONAL = BLOCKS.register("awesomnium_block_diagonal", AwesomniumBlockDiagonal::new);

    public static final RegistryObject<Block> HAND_MINER = BLOCKS.register("hand_miner", HandMiner::new);
    public static final RegistryObject<Block> AWESOME_CHEST = BLOCKS.register("awesome_chest", AwesomeChest::new);
    public static final RegistryObject<Block> PRESENT = BLOCKS.register("present", Present::new);
    public static final RegistryObject<Block> CARDBOARD_BOX = BLOCKS.register("cardboard_box", CardboardBox::new);
    public static final RegistryObject<Block> TRASHCAN = BLOCKS.register("trashcan", TrashCan::new);

    //Logstairs
    public static final RegistryObject<Block> OAK_LOG_STAIR = BLOCKS.register("stairs/oak_log_stairs", AwesomeshopStairs::new);
    public static final RegistryObject<Block> SPRUCE_LOG_STAIR = BLOCKS.register("stairs/spruce_log_stairs", AwesomeshopStairs::new);
    public static final RegistryObject<Block> BIRCH_LOG_STAIR = BLOCKS.register("stairs/birch_log_stairs", AwesomeshopStairs::new);
    public static final RegistryObject<Block> JUNGLE_LOG_STAIR = BLOCKS.register("stairs/jungle_log_stairs", AwesomeshopStairs::new);
    public static final RegistryObject<Block> ACACIA_LOG_STAIR = BLOCKS.register("stairs/acacia_log_stairs", AwesomeshopStairs::new);
    public static final RegistryObject<Block> DARK_OAK_LOG_STAIR = BLOCKS.register("stairs/dark_oak_log_stairs", AwesomeshopStairs::new);

    //Logslabs
    public static final RegistryObject<Block> OAK_LOG_SLAB = BLOCKS.register("slabs/oak_log_slab", AwesomeshopSlabs::new);
    public static final RegistryObject<Block> SPRUCE_LOG_SLAB = BLOCKS.register("slabs/spruce_log_slab", AwesomeshopSlabs::new);
    public static final RegistryObject<Block> BIRCH_LOG_SLAB = BLOCKS.register("slabs/birch_log_slab", AwesomeshopSlabs::new);
    public static final RegistryObject<Block> JUNGLE_LOG_SLAB = BLOCKS.register("slabs/jungle_log_slab", AwesomeshopSlabs::new);
    public static final RegistryObject<Block> ACACIA_LOG_SLAB = BLOCKS.register("slabs/acacia_log_slab", AwesomeshopSlabs::new);
    public static final RegistryObject<Block> DARK_OAK_LOG_SLAB = BLOCKS.register("slabs/dark_oak_log_slab", AwesomeshopSlabs::new);

    //Doors
    public static final RegistryObject<Block> AWESOME_DOOR = BLOCKS.register("doors/awesome_door", AwesomeshopDoor::new);
    public static final RegistryObject<Block> MODERN_GLASS_DOOR = BLOCKS.register("doors/modern_glass_door", AwesomeshopDoor::new);
    public static final RegistryObject<Block> SPOOKY_DOOR = BLOCKS.register("doors/spooky_door", AwesomeshopDoor::new);
    public static final RegistryObject<Block> CHAIN_DOOR = BLOCKS.register("doors/chain_door", AwesomeshopDoor::new);
    public static final RegistryObject<Block> CHURCH_DOOR = BLOCKS.register("doors/church_door", AwesomeshopDoor::new);
    public static final RegistryObject<Block> CLASSICAL_DOOR = BLOCKS.register("doors/classical_door", AwesomeshopDoor::new);
    public static final RegistryObject<Block> MODERN_DOOR = BLOCKS.register("doors/modern_door", AwesomeshopDoor::new);

    //Trapdoors
    public static final RegistryObject<Block> AWESOME_TRAPDOOR = BLOCKS.register("trapdoors/awesome_trapdoor", AwesomeshopTrapDoor::new);
    public static final RegistryObject<Block> MODERN_GLASS_TRAPDOOR = BLOCKS.register("trapdoors/modern_glass_trapdoor", AwesomeshopTrapDoor::new);
    public static final RegistryObject<Block> SPOOKY_TRAPDOOR = BLOCKS.register("trapdoors/spooky_trapdoor", AwesomeshopTrapDoor::new);
    public static final RegistryObject<Block> CHAIN_TRAPDOOR = BLOCKS.register("trapdoors/chain_trapdoor", AwesomeshopTrapDoor::new);
    public static final RegistryObject<Block> CHURCH_TRAPDOOR = BLOCKS.register("trapdoors/church_trapdoor", AwesomeshopTrapDoor::new);
    public static final RegistryObject<Block> CLASSICAL_TRAPDOOR = BLOCKS.register("trapdoors/classical_trapdoor", AwesomeshopTrapDoor::new);
    public static final RegistryObject<Block> MODERN_TRAPDOOR = BLOCKS.register("trapdoors/modern_trapdoor", AwesomeshopTrapDoor::new);

    //Pillars
    public static final RegistryObject<Block> QUARTZ_PILLAR = BLOCKS.register("pillars/quartz_pillar", PillarBlock::new);
    public static final RegistryObject<Block> STONE_PILLAR = BLOCKS.register("pillars/stone_pillar", PillarBlock::new);
    public static final RegistryObject<Block> BLACK_CONCRETE_PILLAR = BLOCKS.register("pillars/black_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> BLUE_CONCRETE_PILLAR = BLOCKS.register("pillars/blue_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> BROWN_CONCRETE_PILLAR = BLOCKS.register("pillars/brown_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> CYAN_CONCRETE_PILLAR = BLOCKS.register("pillars/cyan_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> GRAY_CONCRETE_PILLAR = BLOCKS.register("pillars/gray_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> GREEN_CONCRETE_PILLAR = BLOCKS.register("pillars/green_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_PILLAR = BLOCKS.register("pillars/light_blue_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_PILLAR = BLOCKS.register("pillars/light_gray_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> LIME_CONCRETE_PILLAR = BLOCKS.register("pillars/lime_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_PILLAR = BLOCKS.register("pillars/magenta_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> ORANGE_CONCRETE_PILLAR = BLOCKS.register("pillars/orange_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> PINK_CONCRETE_PILLAR = BLOCKS.register("pillars/pink_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> PURPLE_CONCRETE_PILLAR = BLOCKS.register("pillars/purple_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> RED_CONCRETE_PILLAR = BLOCKS.register("pillars/red_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> WHITE_CONCRETE_PILLAR = BLOCKS.register("pillars/white_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> YELLOW_CONCRETE_PILLAR = BLOCKS.register("pillars/yellow_concrete_pillar", PillarBlock::new);
    public static final RegistryObject<Block> NETHERRACK_PILLAR = BLOCKS.register("pillars/netherrack_pillar", PillarBlock::new);
    public static final RegistryObject<Block> OAK_PLANKS_PILLAR = BLOCKS.register("pillars/oak_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> DARK_OAK_PLANKS_PILLAR = BLOCKS.register("pillars/dark_oak_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> ACACIA_PLANKS_PILLAR = BLOCKS.register("pillars/acacia_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> BIRCH_PLANKS_PILLAR = BLOCKS.register("pillars/birch_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> CRIMSON_PLANKS_PILLAR = BLOCKS.register("pillars/crimson_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> JUNGLE_PLANKS_PILLAR = BLOCKS.register("pillars/jungle_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> SPRUCE_PLANKS_PILLAR = BLOCKS.register("pillars/spruce_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> WARPED_PLANKS_PILLAR = BLOCKS.register("pillars/warped_planks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> COBBLESTONE_PILLAR = BLOCKS.register("pillars/cobblestone_pillar", PillarBlock::new);
    public static final RegistryObject<Block> STONE_BRICKS_PILLAR = BLOCKS.register("pillars/stone_bricks_pillar", PillarBlock::new);
    public static final RegistryObject<Block> ANDESITE_PILLAR = BLOCKS.register("pillars/andesite_pillar", PillarBlock::new);
    public static final RegistryObject<Block> DIORITE_PILLAR = BLOCKS.register("pillars/diorite_pillar", PillarBlock::new);
    public static final RegistryObject<Block> GRANITE_PILLAR = BLOCKS.register("pillars/granite_pillar", PillarBlock::new);
    public static final RegistryObject<Block> POLISHED_ANDESITE_PILLAR = BLOCKS.register("pillars/polished_andesite_pillar", PillarBlock::new);
    public static final RegistryObject<Block> POLISHED_DIORITE_PILLAR = BLOCKS.register("pillars/polished_diorite_pillar", PillarBlock::new);
    public static final RegistryObject<Block> POLISHED_GRANITE_PILLAR = BLOCKS.register("pillars/polished_granite_pillar", PillarBlock::new);
    public static final RegistryObject<Block> GLASS_PILLAR = BLOCKS.register("pillars/glass_pillar", PillarBlock::new);
    public static final RegistryObject<Block> SANDSTONE_PILLAR = BLOCKS.register("pillars/sandstone_pillar", PillarBlock::new);
    public static final RegistryObject<Block> REDSTONE_BLOCK_PILLAR = BLOCKS.register("pillars/redstone_block_pillar", PillarBlock::new);
    public static final RegistryObject<Block> IRON_BLOCK_PILLAR = BLOCKS.register("pillars/iron_block_pillar", PillarBlock::new);
    public static final RegistryObject<Block> EMERALD_BLOCK_PILLAR = BLOCKS.register("pillars/emerald_block_pillar", PillarBlock::new);
    public static final RegistryObject<Block> DIAMOND_BLOCK_PILLAR = BLOCKS.register("pillars/diamond_block_pillar", PillarBlock::new);
    public static final RegistryObject<Block> GOLD_BLOCK_PILLAR = BLOCKS.register("pillars/gold_block_pillar", PillarBlock::new);

    public static final RegistryObject<Block> EASTER_NEST = BLOCKS.register("easter/easter_nest", EasterNest::new);

    public static final RegistryObject<Block> SHOWER_HEAD = BLOCKS.register("shower_head", ShowerHead::new);
    public static final RegistryObject<Block> CHANDELIER = BLOCKS.register("chandelier", Chandelier::new);
    public static final RegistryObject<Block> SHOWER_FAUCET1 = BLOCKS.register("shower_faucet1", ShowerFaucet1::new);
    public static final RegistryObject<Block> SHOWER_FAUCET2 = BLOCKS.register("shower_faucet2", ShowerFaucet2::new);
    public static final RegistryObject<Block> SMALL_TV = BLOCKS.register("small_tv", SmallTV::new);
    public static final RegistryObject<Block> BRICK_OVEN = BLOCKS.register("brick_oven", BrickOven::new);
    public static final RegistryObject<Block> BRICK_OVEN_TUBE = BLOCKS.register("brick_oven_tube", BrickOvenTube::new);
    public static final RegistryObject<Block> DOORMAT = BLOCKS.register("doormat", Doormat::new);
    public static final RegistryObject<Block> SWITCH = BLOCKS.register("switch", Switch::new);
    public static final RegistryObject<Block> PC_SETUP = BLOCKS.register("pc_setup", PCSetup::new);
    public static final RegistryObject<Block> TOILET = BLOCKS.register("toilet", Toilet::new);
    public static final RegistryObject<Block> STAIRS = BLOCKS.register("stairs", Stairs::new);
    public static final RegistryObject<Block> NIGHT_LAMP = BLOCKS.register("night_lamp", NightLamp::new);
    public static final RegistryObject<Block> SMALL_MODERN_LAMP = BLOCKS.register("small_modern_lamp1", SmallModernLamp1::new);
    public static final RegistryObject<Block> SMALL_MODERN_LAMP2 = BLOCKS.register("small_modern_lamp2", SmallModernLamp2::new);
    public static final RegistryObject<Block> SMALL_MODERN_LAMP3 = BLOCKS.register("small_modern_lamp3", SmallModernLamp3::new);
    public static final RegistryObject<Block> MODERN_WALL_LAMP1 = BLOCKS.register("modern_wall_lamp1", ModernWallLamp1::new);
    public static final RegistryObject<Block> CHRISTMASTREE = BLOCKS.register("christmastree", Christmastree::new);
    public static final RegistryObject<Block> BASICTABLE = BLOCKS.register("basic_table", BasicTable::new);
    public static final RegistryObject<Block> PIANO = BLOCKS.register("piano", Piano::new);
    public static final RegistryObject<Block> TOASTER = BLOCKS.register("toaster", Toaster::new);
    public static final RegistryObject<Block> STAIRS_RAILING_LEFT = BLOCKS.register("stairs_railing_left", StairsRailingLeft::new);
    public static final RegistryObject<Block> STAIRS_RAILING_RIGHT = BLOCKS.register("stairs_railing_right", StairsRailingRight::new);

    public static final RegistryObject<Block> ADVENT_WREATH_4 = BLOCKS.register("advent_wreath4", AdventWreath4::new);
    public static final RegistryObject<Block> ADVENT_WREATH_3 = BLOCKS.register("advent_wreath3", AdventWreath3::new);
    public static final RegistryObject<Block> ADVENT_WREATH_2 = BLOCKS.register("advent_wreath2", AdventWreath2::new);
    public static final RegistryObject<Block> ADVENT_WREATH_1 = BLOCKS.register("advent_wreath1", AdventWreath1::new);
    public static final RegistryObject<Block> ADVENT_WREATH_0 = BLOCKS.register("advent_wreath0", AdventWreath0::new);

    //Flags
    public static final RegistryObject<Block> DRUGAR_FLAG = BLOCKS.register("flags/drugar_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> PAN_FLAG = BLOCKS.register("flags/pan_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> BI_FLAG = BLOCKS.register("flags/bi_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> GAY_FLAG = BLOCKS.register("flags/gay_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> USA_FLAG = BLOCKS.register("flags/usa_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> GERMAN_FLAG = BLOCKS.register("flags/german_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> SWEDEN_FLAG = BLOCKS.register("flags/sweden_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> ENGLAND_FLAG = BLOCKS.register("flags/england_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> CHINA_FLAG = BLOCKS.register("flags/china_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> JAPAN_FLAG = BLOCKS.register("flags/japan_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> CROATIA_FLAG = BLOCKS.register("flags/croatia_flag", AwesomeFlag::new);
    public static final RegistryObject<Block> RUSSIA_FLAG = BLOCKS.register("flags/russia_flag", AwesomeFlag::new);

    //The Big Screen
    public static final RegistryObject<Block> BIG_SCREEN_1 = BLOCKS.register("big_screen/big_screen1", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_2 = BLOCKS.register("big_screen/big_screen2", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_3 = BLOCKS.register("big_screen/big_screen3", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_4 = BLOCKS.register("big_screen/big_screen4", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_5 = BLOCKS.register("big_screen/big_screen5", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_6 = BLOCKS.register("big_screen/big_screen6", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_7 = BLOCKS.register("big_screen/big_screen7", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_8 = BLOCKS.register("big_screen/big_screen8", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_9 = BLOCKS.register("big_screen/big_screen9", BigScreen::new);
    public static final RegistryObject<Block> BIG_SCREEN_10 = BLOCKS.register("big_screen/big_screen10", BigScreen::new);
}
