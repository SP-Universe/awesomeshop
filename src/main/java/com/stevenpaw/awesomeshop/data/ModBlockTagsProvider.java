package com.stevenpaw.awesomeshop.data;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.setup.ModBlocks;
import com.stevenpaw.awesomeshop.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, AwesomeShop.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(ModTags.Blocks.ORES_AWESOMNIUM).add(ModBlocks.AWESOMNIUM_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_AWESOMNIUM);
        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_AWESOMNIUM).add(ModBlocks.AWESOMNIUM_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_AWESOMNIUM);
    }
}
