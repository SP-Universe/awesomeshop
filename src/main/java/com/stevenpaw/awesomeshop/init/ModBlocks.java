package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.blocks.*;
import com.stevenpaw.awesomeshop.blocks.flags.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);

    // BLOCKS
    // public static final RegistryObject<Block> NAME_OF_BLOCK = BLOCKS.register("name_of_block", NameOfBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_ORE = BLOCKS.register("awesomnium_ore", AwesomniumOre::new);
    public static final RegistryObject<Block> DUCATIUM_ORE = BLOCKS.register("ducatium_ore", DucatiumOre::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK = BLOCKS.register("awesomnium_block", AwesomniumBlock::new);
    public static final RegistryObject<Block> AWESOMNIUM_BLOCK_DIAGONAL = BLOCKS.register("awesomnium_block_diagonal", AwesomniumBlockDiagonal::new);

    //public static final RegistryObject<Block> SHREDDER = BLOCKS.register("shredder", Shredder::new);
    public static final RegistryObject<Block> SHOWER_HEAD = BLOCKS.register("shower_head", ShowerHead::new);
    public static final RegistryObject<Block> SHOWER_FAUCET1 = BLOCKS.register("shower_faucet1", ShowerFaucet1::new);
    public static final RegistryObject<Block> SHOWER_FAUCET2 = BLOCKS.register("shower_faucet2", ShowerFaucet2::new);
    public static final RegistryObject<Block> SMALL_TV = BLOCKS.register("small_tv", SmallTV::new);
    public static final RegistryObject<Block> BRICK_OVEN = BLOCKS.register("brick_oven", BrickOven::new);
    public static final RegistryObject<Block> BRICK_OVEN_TUBE = BLOCKS.register("brick_oven_tube", BrickOvenTube::new);
    public static final RegistryObject<Block> DOORMAT = BLOCKS.register("doormat", Doormat::new);

    //Flags
    public static final RegistryObject<Block> DRUGAR_FLAG = BLOCKS.register("drugar_flag", DrugarFlag::new);
    public static final RegistryObject<Block> GERMAN_FLAG = BLOCKS.register("german_flag", GermanFlag::new);
    public static final RegistryObject<Block> USA_FLAG = BLOCKS.register("usa_flag", USAFlag::new);
    public static final RegistryObject<Block> GAY_FLAG = BLOCKS.register("gay_flag", GayFlag::new);
    public static final RegistryObject<Block> BI_FLAG = BLOCKS.register("bi_flag", BiFlag::new);
    public static final RegistryObject<Block> PAN_FLAG = BLOCKS.register("pan_flag", PanFlag::new);
}
