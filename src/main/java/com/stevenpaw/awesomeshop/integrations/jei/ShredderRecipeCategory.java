package com.stevenpaw.awesomeshop.integrations.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.recipe.ShredderRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class ShredderRecipeCategory implements IRecipeCategory<ShredderRecipe> {
    public static final ResourceLocation ID = new ResourceLocation(AwesomeShop.MOD_ID, "shredder");
    private final String title = "Shredder";
    private final IDrawable background;
    private final IDrawableAnimated arrow;
    private final IDrawableAnimated fire;
    private final IDrawable icon;

    public ShredderRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation location = new ResourceLocation(AwesomeShop.MOD_ID, "textures/gui/jei/shredder.png");
        background = guiHelper.drawableBuilder(location, 0, 0, 81, 62)
                .addPadding(0, 0, 0, 0)
                .build();
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(BlockInit.SHREDDER.get()));

        this.arrow = guiHelper.drawableBuilder(location, 95, 0, 22, 14)
                .buildAnimated(100, IDrawableAnimated.StartDirection.LEFT, false);

        this.fire = guiHelper.drawableBuilder(location, 81, 0, 14, 14)
                .buildAnimated(600, IDrawableAnimated.StartDirection.TOP, true);

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
    public void draw(ShredderRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
        arrow.draw(matrixStack, 29, 23);
        fire.draw(matrixStack, 7, 42);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ShredderRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();

        guiStacks.init(0, true, 6, 21);
        guiStacks.init(1, false, 57, 21);
        guiStacks.set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        guiStacks.set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
