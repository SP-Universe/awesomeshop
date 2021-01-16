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

public class CrystallumInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);

    //RAW CRYSTALLUM
    public static final RegistryObject<Block> RAW_CRYSTALLUM = BLOCKS.register
            ("crystallum/raw_crystallum", Crystallum::new);

    //CRYSTALLUM
    public static final RegistryObject<Block> BLACK_CRYSTALLUM = BLOCKS.register
            ("crystallum/black_crystallum", Crystallum::new);
    public static final RegistryObject<Block> RED_CRYSTALLUM = BLOCKS.register
            ("crystallum/red_crystallum", Crystallum::new);
    public static final RegistryObject<Block> GREEN_CRYSTALLUM = BLOCKS.register
            ("crystallum/green_crystallum", Crystallum::new);
    public static final RegistryObject<Block> BROWN_CRYSTALLUM = BLOCKS.register
            ("crystallum/brown_crystallum", Crystallum::new);
    public static final RegistryObject<Block> BLUE_CRYSTALLUM = BLOCKS.register
            ("crystallum/blue_crystallum", Crystallum::new);
    public static final RegistryObject<Block> PURPLE_CRYSTALLUM = BLOCKS.register
            ("crystallum/purple_crystallum", Crystallum::new);
    public static final RegistryObject<Block> CYAN_CRYSTALLUM = BLOCKS.register
            ("crystallum/cyan_crystallum", Crystallum::new);
    public static final RegistryObject<Block> LIGHT_GRAY_CRYSTALLUM = BLOCKS.register
            ("crystallum/light_gray_crystallum", Crystallum::new);
    public static final RegistryObject<Block> GRAY_CRYSTALLUM = BLOCKS.register
            ("crystallum/gray_crystallum", Crystallum::new);
    public static final RegistryObject<Block> PINK_CRYSTALLUM = BLOCKS.register
            ("crystallum/pink_crystallum", Crystallum::new);
    public static final RegistryObject<Block> LIME_CRYSTALLUM = BLOCKS.register
            ("crystallum/lime_crystallum", Crystallum::new);
    public static final RegistryObject<Block> YELLOW_CRYSTALLUM = BLOCKS.register
            ("crystallum/yellow_crystallum", Crystallum::new);
    public static final RegistryObject<Block> LIGHT_BLUE_CRYSTALLUM = BLOCKS.register
            ("crystallum/light_blue_crystallum", Crystallum::new);
    public static final RegistryObject<Block> MAGENTA_CRYSTALLUM = BLOCKS.register
            ("crystallum/magenta_crystallum", Crystallum::new);
    public static final RegistryObject<Block> ORANGE_CRYSTALLUM = BLOCKS.register
            ("crystallum/orange_crystallum", Crystallum::new);
    public static final RegistryObject<Block> WHITE_CRYSTALLUM = BLOCKS.register
            ("crystallum/white_crystallum", Crystallum::new);


    //CRYSTALLUM-STAIRS
    public static final RegistryObject<Block> BLACK_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/black_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> RED_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/red_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> GREEN_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/green_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> BROWN_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/brown_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> BLUE_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/blue_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> PURPLE_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/purple_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> CYAN_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/cyan_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> LIGHT_GRAY_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/light_gray_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> GRAY_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/gray_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> PINK_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/pink_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> LIME_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/lime_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> YELLOW_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/yellow_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> LIGHT_BLUE_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/light_blue_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> MAGENTA_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/magenta_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> ORANGE_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/orange_crystallum_stairs", CrystallumStairs::new);
    public static final RegistryObject<Block> WHITE_CRYSTALLUM_STAIRS = BLOCKS.register
            ("crystallum_stairs/white_crystallum_stairs", CrystallumStairs::new);

    //CRYSTALLUM-SLABS
    public static final RegistryObject<Block> BLACK_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/black_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> RED_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/red_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> GREEN_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/green_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> BROWN_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/brown_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> BLUE_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/blue_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> PURPLE_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/purple_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> CYAN_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/cyan_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> LIGHT_GRAY_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/light_gray_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> GRAY_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/gray_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> PINK_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/pink_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> LIME_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/lime_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> YELLOW_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/yellow_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> LIGHT_BLUE_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/light_blue_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> MAGENTA_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/magenta_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> ORANGE_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/orange_crystallum_slab", CrystallumSlabs::new);
    public static final RegistryObject<Block> WHITE_CRYSTALLUM_SLAB = BLOCKS.register
            ("crystallum_slabs/white_crystallum_slab", CrystallumSlabs::new);
}
