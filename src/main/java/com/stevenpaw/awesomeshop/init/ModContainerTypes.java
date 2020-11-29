package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;

import com.stevenpaw.awesomeshop.blocks.Shredder;
import com.stevenpaw.awesomeshop.container.ShredderContainer;
import com.stevenpaw.awesomeshop.tileentity.ShredderTileEntity;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static ContainerType<ShredderContainer> containerTypeContainerFurnace;
    public static TileEntityType<ShredderTileEntity> tileEntityTypeMBE31;  // Holds the type of our tile entity; needed for the TileEntityData constructor

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        ModBlocks.SHREDDER = new Shredder().setRegistryName("shredder");
        blockRegisterEvent.getRegistry().register(ModBlocks.SHREDDER.get());
    }
}
