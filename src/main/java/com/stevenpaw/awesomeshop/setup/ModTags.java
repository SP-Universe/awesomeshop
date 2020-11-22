package com.stevenpaw.awesomeshop.setup;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks
    {
        public static final ITag.INamedTag<Block> ORES_AWESOMNIUM = forge("ores/awesomnium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_AWESOMNIUM = forge("storage_blocks/awesomnium");

        private static ITag.INamedTag<Block> forge(String path)
        {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path)
        {
            return BlockTags.makeWrapperTag(new ResourceLocation(AwesomeShop.MOD_ID, path).toString());
        }
    }

    public static final class Items
    {
        public static final ITag.INamedTag<Item> ORES_AWESOMNIUM = forge("ores/awesomnium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_AWESOMNIUM = forge("storage_blocks/awesomnium");

        public static final ITag.INamedTag<Item> INGOTS_AWESOMNIUM = forge("ingots/awesomnium");

        private static ITag.INamedTag<Item> forge(String path)
        {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path)
        {
            return ItemTags.makeWrapperTag(new ResourceLocation(AwesomeShop.MOD_ID, path).toString());
        }
    }
}
