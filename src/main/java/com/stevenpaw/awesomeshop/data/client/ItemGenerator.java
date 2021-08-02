package com.stevenpaw.awesomeshop.data.client;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemGenerator extends ItemModelProvider {

    public ItemGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AwesomeShop.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }

    public void registersingle(RegistryObject<Item> itemIn){
        singleTexture(itemIn.get().getRegistryName().getPath(),
                new ResourceLocation("item/generated"),"layer0", new ResourceLocation(AwesomeShop.MOD_ID, "items/" + itemIn.get().getRegistryName().getPath()));
    }
}
