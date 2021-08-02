package com.stevenpaw.awesomeshop.integrations.jei;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.BlockInit;
import com.stevenpaw.awesomeshop.init.StreetInit;
import com.stevenpaw.awesomeshop.recipe.SignPainterRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SignPainterRecipeCategory implements IRecipeCategory<SignPainterRecipe> {
    public static final ResourceLocation ID = new ResourceLocation(AwesomeShop.MOD_ID, "sign_painter");
    private final String title = "Sign Painter";
    private final IDrawable background;
    private final IDrawable icon;

    public SignPainterRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation location = new ResourceLocation(AwesomeShop.MOD_ID, "textures/gui/jei/sign_painter.png");
        background = guiHelper.drawableBuilder(location, 0, 0, 81, 30)
                .addPadding(0, 0, 0, 0)
                .build();
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(StreetInit.SIGN_PAINTER.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<SignPainterRecipe> getRecipeClass() {
        return SignPainterRecipe.class;
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
    public void setIngredients(SignPainterRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, SignPainterRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();

        guiStacks.init(0, true, 4, 4);
        guiStacks.init(1, false, 55, 4);
        guiStacks.set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        guiStacks.set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
