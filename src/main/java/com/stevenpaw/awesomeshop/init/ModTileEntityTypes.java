package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.tileentity.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AwesomeShop.MOD_ID);

    public static final RegistryObject<TileEntityType<HandMinerTileEntity>> HAND_MINER = TILE_ENTITY_TYPES.register("hand_miner", () -> TileEntityType.Builder
            .create(HandMinerTileEntity::new, BlockInit.HAND_MINER.get()).build(null));

    public static final RegistryObject<TileEntityType<AwesomeChestTileEntity>> EXAMPLE_CHEST = TILE_ENTITY_TYPES.register("awesome_chest", () -> TileEntityType.Builder
            .create(AwesomeChestTileEntity::new, BlockInit.AWESOME_CHEST.get()).build(null));

    public static final RegistryObject<TileEntityType<PresentTileEntity>> PRESENT = TILE_ENTITY_TYPES.register("present", () -> TileEntityType.Builder
            .create(PresentTileEntity::new, BlockInit.PRESENT.get()).build(null));

    public static final RegistryObject<TileEntityType<CardBoardBoxTileEntity>> CARDBOARD_BOX = TILE_ENTITY_TYPES.register("cardboard_box", () -> TileEntityType.Builder
            .create(CardBoardBoxTileEntity::new, BlockInit.CARDBOARD_BOX.get()).build(null));

    public static final RegistryObject<TileEntityType<ShredderTileEntity>> SHREDDER = TILE_ENTITY_TYPES.register("shredder", () -> TileEntityType.Builder
            .create(ShredderTileEntity::new, BlockInit.SHREDDER.get()).build(null));

    public static final RegistryObject<TileEntityType<TrashCanTileEntity>> TRASHCAN = TILE_ENTITY_TYPES.register("trashcan", () -> TileEntityType.Builder
            .create(TrashCanTileEntity::new, BlockInit.TRASHCAN.get()).build(null));
}
