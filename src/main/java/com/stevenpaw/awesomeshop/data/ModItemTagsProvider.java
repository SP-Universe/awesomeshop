package com.stevenpaw.awesomeshop.data;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.setup.ModItems;
import com.stevenpaw.awesomeshop.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, blockTagProvider, AwesomeShop.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        copy(ModTags.Blocks.ORES_AWESOMNIUM, ModTags.Items.ORES_AWESOMNIUM);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_AWESOMNIUM, ModTags.Items.STORAGE_BLOCKS_AWESOMNIUM);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.INGOTS_AWESOMNIUM).add(ModItems.AWESOMNIUM_INGOT.get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag((ModTags.Items.INGOTS_AWESOMNIUM));
    }
}
