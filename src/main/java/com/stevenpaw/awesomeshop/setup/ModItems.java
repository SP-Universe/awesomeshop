package com.stevenpaw.awesomeshop.setup;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
    public static final RegistryObject<Item> AWESOMNIUM_INGOT = Registration.ITEMS.register("awesomnium_ingot", () ->
            new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    static void register() {}
}
