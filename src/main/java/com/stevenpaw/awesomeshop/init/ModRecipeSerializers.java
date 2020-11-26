package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.blocks.Shredder;
import com.stevenpaw.awesomeshop.recipes.ShredderRecipe;
import com.stevenpaw.awesomeshop.recipes.ShredderRecipeSerializer;

public class ModRecipeSerializers {
    // public static final DeferredRegister<IRecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MajCraft.MOD_ID);


    // public static final RegistryObject<ObsidianForgeRecipeSerializer<ObsidianForgeRecipe>> OBSIDIAN_FORGE_RECIPES = RECIPES.register("obsidian_forge",new ObsidianForgeRecipeSerializer<>(ObsidianForgeRecipe::new));


    public static final ShredderRecipeSerializer<ShredderRecipe> SHREDDER = ModUtil.Null();
}

final class ModUtil {
    @SuppressWarnings({"ConstantConditions", "SameReturnValue"})
    public static <T> T Null() {
        return null;
    }
}
