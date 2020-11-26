package com.stevenpaw.awesomeshop.recipes;

import com.stevenpaw.awesomeshop.init.ModBlocks;
import com.stevenpaw.awesomeshop.init.ModRecipeSerializers;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class ShredderRecipe implements IRecipe<RecipeWrapper> {
    public static final IRecipeType<ShredderRecipe> shredder = IRecipeType.register("shredder");

    private final IRecipeType<?> type;
    private final ResourceLocation id;
    final Ingredient input;
    final ItemStack output;
    final int shredderTime;

    public ShredderRecipe(ResourceLocation resourceLocation, Ingredient input, ItemStack output, int shredderTime) {
        type = shredder;
        id = resourceLocation;
        this.input = input;
        this.output = output;
        this.shredderTime = shredderTime;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        if(this.input.test(inv.getStackInSlot(0))) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.output;
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.SHREDDER_RECIPE_SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(null, this.input);
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.SHREDDER.get());
    }

    public int getCookTime() {
        return shredderTime;
    }
}
