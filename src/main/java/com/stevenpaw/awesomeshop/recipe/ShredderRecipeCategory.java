package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class ShredderRecipeCategory implements IRecipeCategory<ShredderRecipe> {
    public static final ResourceLocation ID = new ResourceLocation(AwesomeShop.MOD_ID, "shredder");
    private final String title = "Shredder";
    private final IDrawable background;
    private final IDrawable icon;

    public ShredderRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation texture = new ResourceLocation(AwesomeShop.MOD_ID, "textures/gui/containers/shredder.png");
        this.background = guiHelper.createDrawable(texture, 0, 0, 176, 86);
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.SHREDDER.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<ShredderRecipe> getRecipeClass() {
        return ShredderRecipe.class;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setIngredients(ShredderRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ShredderRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();

        guiStacks.init(0, true, 79, 10);
        guiStacks.init(1, false, 79, 56);
        guiStacks.set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        guiStacks.set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
