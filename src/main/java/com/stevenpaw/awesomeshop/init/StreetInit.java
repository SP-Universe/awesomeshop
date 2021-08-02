package com.stevenpaw.awesomeshop.init;

import com.stevenpaw.awesomeshop.AwesomeShop;
import com.stevenpaw.awesomeshop.objects.blocks.*;
import com.stevenpaw.awesomeshop.objects.blocks.ModernLamp.*;
import com.stevenpaw.awesomeshop.objects.blocks.decoblocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StreetInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);

    public static final RegistryObject<Block> SIGN_PAINTER = BLOCKS.register("sign_painter", SignPainterBlock::new);

    //RoadSigns
    public static final RegistryObject<Block> ROADSIGN_POLE = BLOCKS.register("roadsign_pole", RoadSignPole::new);
    public static final RegistryObject<Block> ROADSIGN_EMPTY = BLOCKS.register("roadsigns/roadsign_empty", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_STOP = BLOCKS.register("roadsigns/roadsign_stop", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_RIGHTOFWAY = BLOCKS.register("roadsigns/roadsign_rightofway", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_NOTRESPASSING = BLOCKS.register("roadsigns/roadsign_notrespassing", RoadSign::new);
}
