package com.stevenpaw.awesomeshop.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.stevenpaw.awesomeshop.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class AwesomeShopRecipe extends AbstractSingleItemRecipe {

    public AwesomeShopRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeType.AWESOMESHOP, ModRecipeSerializer.AWESOMESHOP.get(), id, group, ingredient, result);
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