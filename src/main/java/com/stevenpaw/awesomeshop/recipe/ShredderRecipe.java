package com.stevenpaw.awesomeshop.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.stevenpaw.awesomeshop.init.BlockInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ShredderRecipe extends AbstractCookingRecipe {
    public static int time;

    @SuppressWarnings("static-access")
    public ShredderRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {

        super(ModRecipeType.SHREDDER, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
        this.time = cookTimeIn;
    }

    @Override
    public ItemStack getIcon() {

        return new ItemStack(BlockInit.SHREDDER.get());

    }

    @Override
    public IRecipeSerializer<?> getSerializer() {

        return ModRecipeSerializer.SHREDDER.get();

    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShredderRecipe> {

        @Override
        @SuppressWarnings("deprecation")
        public ShredderRecipe read(ResourceLocation recipeId, JsonObject json) {

            String s = JSONUtils.getString(json, "group", "");
            JsonElement jsonelement = (JsonElement) (JSONUtils.isJsonArray(json, "ingredient")
                    ? JSONUtils.getJsonArray(json, "ingredient")
                    : JSONUtils.getJsonObject(json, "ingredient"));
            Ingredient ingredient = Ingredient.deserialize(jsonelement);
            ItemStack itemstack;

            if (!json.has("result")) {

                throw new JsonSyntaxException("Missing result, expected to find a string or object");

            }

            if (json.get("result").isJsonObject()) {

                itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));

            } else {

                String s1 = JSONUtils.getString(json, "result");
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {

                    return new IllegalStateException("Item: " + s1 + " does not exist");

                }));

            }

            float f = JSONUtils.getFloat(json, "experience", 0.0F);
            int i = JSONUtils.getInt(json, "cookingtime", ShredderRecipe.time);
            return new ShredderRecipe(recipeId, s, ingredient, itemstack, f, i);

        }

        @Override
        public ShredderRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {

            String s = buffer.readString(32767);
            Ingredient ingredient = Ingredient.read(buffer);
            ItemStack itemstack = buffer.readItemStack();
            float f = buffer.readFloat();
            int i = buffer.readVarInt();
            return new ShredderRecipe(recipeId, s, ingredient, itemstack, f, i);

        }

        @Override
        public void write(PacketBuffer buffer, ShredderRecipe recipe) {

            buffer.writeString(recipe.group);
            recipe.ingredient.write(buffer);
            buffer.writeItemStack(recipe.result);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.cookTime);

        }

    }
}
