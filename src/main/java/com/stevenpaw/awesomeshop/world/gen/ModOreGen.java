package com.stevenpaw.awesomeshop.world.gen;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

/**
 * Ore generation
 * @author TechOFreak
 * Add OreGenerationExample.registerOres(); to your main class's setup method
 */

@Mod.EventBusSubscriber
public class ModOreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres(){
        //field_241882_a is for generating in stone, granite, diorite, and andesite
        //field_241883_b is for generating in netherrack
        //field_241884_c is for generating in netherrack, basalt and blackstone

        //Overworld Ore Register
        //Spawn Awesomnium Ores
        overworldOres.add(register("awesomnium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.AWESOMNIUM_ORE.get().getDefaultState(), 5)) //Vein Size
                .range(40).square() //Spawn height start
                .func_242731_b(1))); //Chunk spawn frequency

        //Spawn Ducatium Ores
        overworldOres.add(register("ducatium_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.DUCATIUM_ORE.get().getDefaultState(), 3)) //Vein Size
                .range(25).square() //Spawn height start
                .func_242731_b(1))); //Chunk spawn frequency

        /*
        //Nether Ore Register
        netherOres.add(register("example_nether_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.field_241883_b, YOUR_ORE_BLOCK.getDefaultState(), 4)) //Vein Size
                .func_242733_d(64).func_242728_a() //Spawn height start
                .func_242731_b(64))); //Chunk spawn frequency

        //The End Ore Register
        endOres.add(register("example_end_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), YOUR_ORE_BLOCK.getDefaultState(), 4)) //Vein Size
                .func_242733_d(128).func_242728_a() //Spawn height start
                .func_242731_b(64))); //Chunk spawn frequency

         */
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)){
            for(ConfiguredFeature<?, ?> ore : endOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, AwesomeShop.MOD_ID + ":" + name, configuredFeature);
    }

}