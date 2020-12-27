package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.container.AwesomeChestContainer;
import com.stevenpaw.awesomeshop.container.PresentContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, AwesomeShop.MOD_ID);

    public static final RegistryObject<ContainerType<AwesomeChestContainer>> AWESOME_CHEST = CONTAINER_TYPES
            .register("awesome_chest", () -> IForgeContainerType.create(AwesomeChestContainer::new));

    public static final RegistryObject<ContainerType<PresentContainer>> PRESENT = CONTAINER_TYPES
            .register("present", () -> IForgeContainerType.create(PresentContainer::new));
}
