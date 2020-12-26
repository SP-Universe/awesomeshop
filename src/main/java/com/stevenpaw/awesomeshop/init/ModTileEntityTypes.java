package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.tileentity.HandMinerTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AwesomeShop.MOD_ID);

    public static final RegistryObject<TileEntityType<HandMinerTileEntity>> HAND_MINER = TILE_ENTITY_TYPES.register("hand_miner", () -> TileEntityType.Builder.create(HandMinerTileEntity::new, BlockInit.HAND_MINER.get()).build(null));
}
