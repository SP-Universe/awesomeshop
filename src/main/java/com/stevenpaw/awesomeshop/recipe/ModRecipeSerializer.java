package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializer {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AwesomeShop.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> SHREDDER = RECIPE_SERIALIZERS.register("shredder",
            () -> new ShredderRecipe.Serializer());

    public static final RegistryObject<AbstractSingleItemRecipe.Serializer<AwesomeShopRecipe>> AWESOMESHOP = RECIPE_SERIALIZERS.register("awesomeshop",
            () -> new AbstractSingleItemRecipe.Serializer<>(AwesomeShopRecipe::new));
}
