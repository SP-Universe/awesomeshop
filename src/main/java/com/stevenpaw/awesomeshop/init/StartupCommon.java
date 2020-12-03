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
    public static Block blockFurnace;  // this holds the unique instance of your block
    public static BlockItem itemBlockFurnace; // and the corresponding item form that block

    public static TileEntityType<ShredderTileEntity> tileEntityTypeMBE31;  // Holds the type of our tile entity; needed for the TileEntityData constructor
    public static ContainerType<ShredderContainer> containerTypeContainerFurnace;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        blockFurnace = new Shredder().setRegistryName("shredder");
        blockRegisterEvent.getRegistry().register(blockFurnace);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        // We need to create a BlockItem so the player can carry this block in their hand and it can appear in the inventory
        final int MAXIMUM_STACK_SIZE = 1;  // player can only hold 1 of this block in their hand at once

        Item.Properties itemSimpleProperties = new Item.Properties()
                .maxStackSize(MAXIMUM_STACK_SIZE)
                .group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
        itemBlockFurnace = new BlockItem(blockFurnace, itemSimpleProperties);
        itemBlockFurnace.setRegistryName(blockFurnace.getRegistryName());
        itemRegisterEvent.getRegistry().register(itemBlockFurnace);
    }

    @SubscribeEvent
    public static void onTileEntityTypeRegistration(final RegistryEvent.Register<TileEntityType<?>> event) {
        tileEntityTypeMBE31 = TileEntityType.Builder.create(ShredderTileEntity::new, blockFurnace)
                .build(null);
        // you probably don't need a datafixer --> null should be fine
        tileEntityTypeMBE31.setRegistryName("awesomeshop:shredder_tile_entity_type");
        event.getRegistry().register(tileEntityTypeMBE31);
    }

    @SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event)
    {
        containerTypeContainerFurnace = IForgeContainerType.create(ShredderContainer::createContainerClientSide);
        containerTypeContainerFurnace.setRegistryName("shredder_container");
        event.getRegistry().register(containerTypeContainerFurnace);
    }

}