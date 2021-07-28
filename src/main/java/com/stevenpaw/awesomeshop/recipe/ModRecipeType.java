package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.recipe.ShredderRecipe;
import net.minecraft.item.crafting.IRecipeType;

public class ModRecipeType {

    public static final IRecipeType<ShredderRecipe> SHREDDER = IRecipeType.register("shredder");

    public static final IRecipeType<AwesomeShopRecipe> AWESOMESHOP = IRecipeType.register("awesomeshop");

    public static final IRecipeType<SignPainterRecipe> SIGN_PAINTER = IRecipeType.register("sign_painter");

}
