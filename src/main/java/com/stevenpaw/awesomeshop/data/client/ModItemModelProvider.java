package com.stevenpaw.awesomeshop.data.client;

import com.stevenpaw.awesomeshop.AwesomeShop;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, AwesomeShop.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
       // withExistingParent("awesomnium_block", modLoc("block/awesomnium_block"));
       // withExistingParent("awesomnium_ore", modLoc("block/awesomnium_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "awesomnium_ingot");
    }


    private ItemModelBuilder builder(ModelFile itemGenerated, String name)
    {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
