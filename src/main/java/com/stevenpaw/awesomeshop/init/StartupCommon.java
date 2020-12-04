package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.blocks.Shredder;
import com.stevenpaw.awesomeshop.container.ShredderContainer;
import com.stevenpaw.awesomeshop.tileentity.ShredderTileEntity;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartupCommon {
    public static Block shredder;  // this holds the unique instance of your block
    public static BlockItem shredderItem; // and the corresponding item form that block

    public static TileEntityType<ShredderTileEntity> shredderTileEntity;  // Holds the type of our tile entity; needed for the TileEntityData constructor
    public static ContainerType<ShredderContainer> shredderContainerType;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        shredder = new Shredder().setRegistryName("shredder");
        blockRegisterEvent.getRegistry().register(shredder);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        // We need to create a BlockItem so the player can carry this block in their hand and it can appear in the inventory
        final int MAXIMUM_STACK_SIZE = 1;  // player can only hold 1 of this block in their hand at once

        Item.Properties itemSimpleProperties = new Item.Properties()
                .maxStackSize(MAXIMUM_STACK_SIZE)
                .group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
        shredderItem = new BlockItem(shredder, itemSimpleProperties);
        shredderItem.setRegistryName(shredder.getRegistryName());
        itemRegisterEvent.getRegistry().register(shredderItem);
    }

    @SubscribeEvent
    public static void onTileEntityTypeRegistration(final RegistryEvent.Register<TileEntityType<?>> event) {
        shredderTileEntity = TileEntityType.Builder.create(ShredderTileEntity::new, shredder)
                .build(null);
        // you probably don't need a datafixer --> null should be fine
        shredderTileEntity.setRegistryName("awesomeshop:shredder_tile_entity_type");
        event.getRegistry().register(shredderTileEntity);
    }

    @SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event)
    {
        shredderContainerType = IForgeContainerType.create(ShredderContainer::createContainerClientSide);
        shredderContainerType.setRegistryName("shredder_container");
        event.getRegistry().register(shredderContainerType);
    }

}