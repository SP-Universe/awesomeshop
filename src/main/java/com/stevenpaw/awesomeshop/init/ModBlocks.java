package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
    public static final RegistryObject<Block> CRYSTALLIUM_BLOCK = BLOCKS.register("crystallium_block", AwesomniumBlock::new);

    public static final RegistryObject<Block> SHREDDER = BLOCKS.register("shredder", Shredder::new);
    public static final RegistryObject<Block> DRUGAR_FLAG = BLOCKS.register("drugar_flag", DrugarFlag::new);
    public static final RegistryObject<Block> ADVENT_WREATH_0 = BLOCKS.register("advent_wreath_0", AdventWreath0::new);
    public static final RegistryObject<Block> ADVENT_WREATH_1 = BLOCKS.register("advent_wreath_1", AdventWreath1::new);
    public static final RegistryObject<Block> ADVENT_WREATH_2 = BLOCKS.register("advent_wreath_2", AdventWreath2::new);
    public static final RegistryObject<Block> ADVENT_WREATH_3 = BLOCKS.register("advent_wreath_3", AdventWreath3::new);
    public static final RegistryObject<Block> ADVENT_WREATH_4 = BLOCKS.register("advent_wreath_4", AdventWreath4::new);
}
