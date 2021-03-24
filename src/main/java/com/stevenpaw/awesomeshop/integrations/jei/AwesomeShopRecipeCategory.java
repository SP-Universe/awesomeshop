package com.stevenpaw.awesomeshop.recipe;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class AwesomeShopRecipeCategory implements IRecipeCategory<AwesomeShopRecipe> {
    public static final ResourceLocation ID = new ResourceLocation(AwesomeShop.MOD_ID, "awesomeshop");
    private final String title = "Awesomeshop";
    private final IDrawable background;
    private final IDrawable icon;

    public AwesomeShopRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation location = new ResourceLocation(AwesomeShop.MOD_ID, "textures/gui/jei/awesomeshop.png");
        background = guiHelper.drawableBuilder(location, 0, 0, 81, 30)
                .addPadding(0, 0, 0, 0)
                .build();
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.AWESOMESHOP.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<AwesomeShopRecipe> getRecipeClass() {
        return AwesomeShopRecipe.class;
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
    public void setIngredients(AwesomeShopRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, AwesomeShopRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();

        guiStacks.init(0, true, 6, 6);
        guiStacks.init(1, false, 57, 6);
        guiStacks.set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        guiStacks.set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
