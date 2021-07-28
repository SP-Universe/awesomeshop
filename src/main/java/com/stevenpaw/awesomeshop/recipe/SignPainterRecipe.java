package com.stevenpaw.awesomeshop.recipe;

import com.stevenpaw.awesomeshop.init.BlockInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SignPainterRecipe extends AbstractSingleItemRecipe {

    public SignPainterRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeType.SIGN_PAINTER, ModRecipeSerializer.SIGN_PAINTER.get(), id, group, ingredient, result);
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(0));
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(BlockInit.AWESOMESHOP.get().asItem());
    }
}