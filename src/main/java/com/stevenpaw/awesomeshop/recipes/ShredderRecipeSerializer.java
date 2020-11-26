package com.stevenpaw.awesomeshop.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ShredderRecipeSerializer<T extends ShredderRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T>{

    private final ShredderRecipeSerializer.IFactory<T> factory;

    public ShredderRecipeSerializer(ShredderRecipeSerializer.IFactory<T> factory) {
        this.factory = factory;
    }

    @Override
    @Nonnull
    public T read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        // group
        String groupString = JSONUtils.getString(json, "group", "");

        // ingredient
        JsonElement ingredientJSON = JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient");
        Ingredient ingredient = Ingredient.deserialize(ingredientJSON);

        // result
        ItemStack resultItemStack;
        if (!json.has("result")) {
            resultItemStack = ItemStack.EMPTY;
        }
        else if (json.get("result").isJsonObject()) {
            resultItemStack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
        } else {
            String resultString = JSONUtils.getString(json, "result");
            ResourceLocation resultRS = new ResourceLocation(resultString);
            resultItemStack = new ItemStack(ForgeRegistries.ITEMS.getValue(resultRS));
        }

        // cookTime
        int cookTime = JSONUtils.getInt(json, "furnaceTime", 200);

        return this.factory.create(recipeId, groupString, ingredient, resultItemStack, cookTime);
    }

    @Nullable
    @Override
    public T read(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
        // group
        String groupString = buffer.readString(32767);

        // ingredient
        Ingredient ingredient = Ingredient.read(buffer);

        // result
        ItemStack itemstack = buffer.readItemStack();

        // cookTime
        int cookTime = buffer.readVarInt();

        return this.factory.create(recipeId, groupString, ingredient, itemstack, cookTime);
    }

    @Override
    public void write(PacketBuffer buffer, T recipe) {

        // ingredient
        recipe.input.write(buffer);

        // result
        buffer.writeItemStack(recipe.output);

        // cookTime
        buffer.writeVarInt(recipe.shredderTime);
    }

    public interface IFactory<T extends ShredderRecipe> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result, int cookTime);
    }

    public ShredderRecipeSerializer.IFactory<T> getFactory() {
        return factory;
    }
}