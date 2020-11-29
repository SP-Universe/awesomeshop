package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
            ForgeRegistries.TILE_ENTITIES, AwesomeShop.MOD_ID);

    public static final RegistryObject<TileEntityType<ShredderTileEntity>> SHREDDER = TILE_ENTITY_TYPES
            .register("shredder", () -> TileEntityType.Builder.create(ShredderTileEntity::new, ModBlocks.SHREDDER.get()).build(null));
}
