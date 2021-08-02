package com.stevenpaw.awesomeshop.data;

import com.stevenpaw.awesomeshop.data.client.ItemGenerator;
import com.stevenpaw.awesomeshop.data.client.RoadSignGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        if(event.includeClient()) {
            generator.addProvider(new ItemGenerator(generator, event.getExistingFileHelper()));
            generator.addProvider(new RoadSignGenerator(generator, event.getExistingFileHelper()));
        }
    }
}
