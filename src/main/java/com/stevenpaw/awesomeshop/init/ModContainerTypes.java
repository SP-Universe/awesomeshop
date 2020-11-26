package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;

import com.stevenpaw.awesomeshop.container.ShredderContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, AwesomeShop.MOD_ID);

    public static final RegistryObject<ContainerType<ShredderContainer>> SHREDDER = CONTAINER_TYPES
            .register("example_chest", () -> IForgeContainerType.create(ShredderContainer::new));

}
