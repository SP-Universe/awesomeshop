package com.stevenpaw.awesomeshop.data.client;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.init.StreetInit;
import com.stevenpaw.awesomeshop.objects.blocks.decoblocks.RoadSign;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class RoadSignGenerator extends BlockStateProvider {
    public RoadSignGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, AwesomeShop.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        StreetInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {

            if(block.getRegistryName().toString().startsWith("awesomeshop:roadsigns/roadsign_")){
                simpleRoadSign(block);
            }
        });
    }

    public void simpleRoadSign(Block blockIn){
        ModelFile roadSign = models()
                .withExistingParent("awesomeshop:block/" + blockIn.getRegistryName().getPath(), "awesomeshop:block/roadsigns/roadsign")
                .texture("1", modLoc("blocks/" + blockIn.getRegistryName().getPath()));

        models().withExistingParent("awesomeshop:item/" + blockIn.getRegistryName().getPath(), "awesomeshop:block/" + blockIn.getRegistryName().getPath());
        //models().getBuilder("block/roadsigns/").texture(AwesomeShop.MOD_ID,"blocks/" + blockIn.getRegistryName().getPath());

        getVariantBuilder(blockIn)
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(roadSign)
                        .rotationY((int) state.get(RoadSign.FACING).getOpposite().getHorizontalAngle())
                        .build()
                );
    }
}
