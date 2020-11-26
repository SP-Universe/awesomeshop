package com.stevenpaw.awesomeshop.recipes;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;

public class IExampleRecipe extends IRecipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(AwesomeShop.MOD_ID, "example");

    @Nonnull
    @Override
    default IRecipeType<?> getType()
    {
        return Registry.RECIPE_TYPE.getValueForKey(RECIPE_TYPE_ID);
    }
}
