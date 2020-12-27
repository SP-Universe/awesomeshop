package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.objects.blocks.*;
import com.stevenpaw.awesomeshop.objects.blocks.ModernLamp.ModernWallLamp1;
import com.stevenpaw.awesomeshop.objects.blocks.ModernLamp.SmallModernLamp1;
import com.stevenpaw.awesomeshop.objects.blocks.ModernLamp.SmallModernLamp2;
import com.stevenpaw.awesomeshop.objects.blocks.ModernLamp.SmallModernLamp3;
import com.stevenpaw.awesomeshop.objects.blocks.flags.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);

    // BLOCKS
    // public static final RegistryObject<Block> NAME_OF_BLOCK = BLOCKS.register("name_of_block", NameOfBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_ORE = BLOCKS.register("awesomnium_ore", AwesomniumOre::new);
    public static final RegistryObject<Block> DUCATIUM_ORE = BLOCKS.register("ducatium_ore", DucatiumOre::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK = BLOCKS.register("awesomnium_block", AwesomniumBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK_DIAGONAL = BLOCKS.register("awesomnium_block_diagonal", AwesomniumBlockDiagonal::new);

    public static final RegistryObject<Block> HAND_MINER = BLOCKS.register("hand_miner", HandMiner::new);
    public static final RegistryObject<Block> AWESOME_CHEST = BLOCKS.register("awesome_chest", AwesomeChest::new);
    public static final RegistryObject<Block> PRESENT = BLOCKS.register("present", Present::new);

    //public static final RegistryObject<Block> SHREDDER = BLOCKS.register("shredder", Shredder::new);
    public static final RegistryObject<Block> SHOWER_HEAD = BLOCKS.register("shower_head", ShowerHead::new);
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
    public static final RegistryObject<Block> SMALL_MODERN_LAMP = BLOCKS.register("small_modern_lamp", SmallModernLamp1::new);
    public static final RegistryObject<Block> SMALL_MODERN_LAMP2 = BLOCKS.register("small_modern_lamp2", SmallModernLamp2::new);
    public static final RegistryObject<Block> SMALL_MODERN_LAMP3 = BLOCKS.register("small_modern_lamp3", SmallModernLamp3::new);
    public static final RegistryObject<Block> MODERN_WALL_LAMP1 = BLOCKS.register("modern_wall_lamp1", ModernWallLamp1::new);
    public static final RegistryObject<Block> CHRISTMASTREE = BLOCKS.register("christmastree", Christmastree::new);
    public static final RegistryObject<Block> BASICTABLE = BLOCKS.register("basic_table", BasicTable::new);
    public static final RegistryObject<Block> PIANO = BLOCKS.register("piano", Piano::new);

    //Flags
    public static final RegistryObject<Block> DRUGAR_FLAG = BLOCKS.register("drugar_flag", DrugarFlag::new);
    public static final RegistryObject<Block> ADVENT_WREATH_4 = BLOCKS.register("advent_wreath4", AdventWreath4::new);
    public static final RegistryObject<Block> ADVENT_WREATH_3 = BLOCKS.register("advent_wreath3", AdventWreath3::new);
    public static final RegistryObject<Block> ADVENT_WREATH_2 = BLOCKS.register("advent_wreath2", AdventWreath2::new);
    public static final RegistryObject<Block> ADVENT_WREATH_1 = BLOCKS.register("advent_wreath1", AdventWreath1::new);
    public static final RegistryObject<Block> ADVENT_WREATH_0 = BLOCKS.register("advent_wreath0", AdventWreath0::new);
    public static final RegistryObject<Block> PAN_FLAG = BLOCKS.register("pan_flag", PanFlag::new);
    public static final RegistryObject<Block> BI_FLAG = BLOCKS.register("bi_flag", BiFlag::new);
    public static final RegistryObject<Block> GAY_FLAG = BLOCKS.register("gay_flag", GayFlag::new);
    public static final RegistryObject<Block> USA_FLAG = BLOCKS.register("usa_flag", USAFlag::new);
    public static final RegistryObject<Block> GERMAN_FLAG = BLOCKS.register("german_flag", GermanFlag::new);

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
