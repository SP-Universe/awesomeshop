package com.stevenpaw.awesomeshop.integrations;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.integrations.jei.AwesomeShopRecipeCategory;
import com.stevenpaw.awesomeshop.integrations.jei.AwesomeShopRecipeTransferInfo;
import com.stevenpaw.awesomeshop.integrations.jei.ShredderRecipeCategory;
import com.stevenpaw.awesomeshop.integrations.jei.ShredderRecipeTransferInfo;
import com.stevenpaw.awesomeshop.recipe.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(AwesomeShop.MOD_ID, "plugin_" + AwesomeShop.MOD_ID);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockInit.SHREDDER.get()), ShredderRecipeCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(BlockInit.AWESOMESHOP.get()), AwesomeShopRecipeCategory.ID);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(new ShredderRecipeTransferInfo());
        registration.addRecipeTransferHandler(new AwesomeShopRecipeTransferInfo());
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().getConnection().getRecipeManager();
        registration.addRecipes(recipeManager.getRecipesForType(ModRecipeType.SHREDDER), ShredderRecipeCategory.ID);
        registration.addRecipes(recipeManager.getRecipesForType(ModRecipeType.AWESOMESHOP), AwesomeShopRecipeCategory.ID);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new ShredderRecipeCategory(registration.getJeiHelpers().getGuiHelper()),
                new AwesomeShopRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }
}
