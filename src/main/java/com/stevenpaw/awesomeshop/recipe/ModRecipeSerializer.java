package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializer {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AwesomeShop.MOD_ID);


    public static final RegistryObject<IRecipeSerializer<?>> SHREDDER = RECIPE_SERIALIZERS.register("shredder",
            () -> new ShredderRecipe.Serializer());
}
