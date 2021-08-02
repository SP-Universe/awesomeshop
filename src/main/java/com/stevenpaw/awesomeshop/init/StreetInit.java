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

    //All Roadsign-Codes depend on https://www.verkehrszeichen-online.org/verkehrsschilder_in_deutschland_stvo.pdf

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AwesomeShop.MOD_ID);

    public static final RegistryObject<Block> SIGN_PAINTER = BLOCKS.register("sign_painter", SignPainterBlock::new);

    //RoadSigns
    public static final RegistryObject<Block> ROADSIGN_POLE = BLOCKS.register("roadsign_pole", RoadSignPole::new);
    public static final RegistryObject<Block> EMPTY_ROADSIGN = BLOCKS.register("roadsigns/empty_roadsign", RoadSign::new);

    public static final RegistryObject<Block> ROADSIGN_101 = BLOCKS.register("roadsigns/roadsign_101", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_102 = BLOCKS.register("roadsigns/roadsign_102", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_103_10 = BLOCKS.register("roadsigns/roadsign_103_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_103_20 = BLOCKS.register("roadsigns/roadsign_103_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_105_10 = BLOCKS.register("roadsigns/roadsign_105_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_105_20 = BLOCKS.register("roadsigns/roadsign_105_20", RoadSign::new);

    public static final RegistryObject<Block> ROADSIGN_205 = BLOCKS.register("roadsigns/roadsign_205", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_206 = BLOCKS.register("roadsigns/roadsign_206", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_209_10 = BLOCKS.register("roadsigns/roadsign_209_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_209_20 = BLOCKS.register("roadsigns/roadsign_209_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_209_30 = BLOCKS.register("roadsigns/roadsign_209_30", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_211_10 = BLOCKS.register("roadsigns/roadsign_211_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_211_20 = BLOCKS.register("roadsigns/roadsign_211_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_214_10 = BLOCKS.register("roadsigns/roadsign_214_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_214_20 = BLOCKS.register("roadsigns/roadsign_214_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_215 = BLOCKS.register("roadsigns/roadsign_215", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_222_10 = BLOCKS.register("roadsigns/roadsign_222_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_222_20 = BLOCKS.register("roadsigns/roadsign_222_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_250 = BLOCKS.register("roadsigns/roadsign_250", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_267 = BLOCKS.register("roadsigns/roadsign_267", RoadSign::new);

    public static final RegistryObject<Block> ROADSIGN_274_50 = BLOCKS.register("roadsigns/roadsign_274_50", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_51 = BLOCKS.register("roadsigns/roadsign_274_51", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_52 = BLOCKS.register("roadsigns/roadsign_274_52", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_53 = BLOCKS.register("roadsigns/roadsign_274_53", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_54 = BLOCKS.register("roadsigns/roadsign_274_54", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_55 = BLOCKS.register("roadsigns/roadsign_274_55", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_56 = BLOCKS.register("roadsigns/roadsign_274_56", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_58 = BLOCKS.register("roadsigns/roadsign_274_58", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_59 = BLOCKS.register("roadsigns/roadsign_274_59", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_60 = BLOCKS.register("roadsigns/roadsign_274_60", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_61 = BLOCKS.register("roadsigns/roadsign_274_61", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_62 = BLOCKS.register("roadsigns/roadsign_274_62", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_274_63 = BLOCKS.register("roadsigns/roadsign_274_63", RoadSign::new);

    public static final RegistryObject<Block> ROADSIGN_282 = BLOCKS.register("roadsigns/roadsign_282", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_301 = BLOCKS.register("roadsigns/roadsign_301", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_306 = BLOCKS.register("roadsigns/roadsign_306", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_330_1 = BLOCKS.register("roadsigns/roadsign_330_1", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_330_2 = BLOCKS.register("roadsigns/roadsign_330_2", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_331_1 = BLOCKS.register("roadsigns/roadsign_331_1", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_331_2 = BLOCKS.register("roadsigns/roadsign_331_2", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_350_10 = BLOCKS.register("roadsigns/roadsign_350_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_350_20 = BLOCKS.register("roadsigns/roadsign_350_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_358 = BLOCKS.register("roadsigns/roadsign_358", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_378 = BLOCKS.register("roadsigns/roadsign_378", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_625_10 = BLOCKS.register("roadsigns/roadsign_625_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_720 = BLOCKS.register("roadsigns/roadsign_720", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_10 = BLOCKS.register("roadsigns/roadsign_1002_10", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_11 = BLOCKS.register("roadsigns/roadsign_1002_11", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_12 = BLOCKS.register("roadsigns/roadsign_1002_12", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_13 = BLOCKS.register("roadsigns/roadsign_1002_13", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_14 = BLOCKS.register("roadsigns/roadsign_1002_14", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_20 = BLOCKS.register("roadsigns/roadsign_1002_20", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_21 = BLOCKS.register("roadsigns/roadsign_1002_21", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_22 = BLOCKS.register("roadsigns/roadsign_1002_22", RoadSign::new);
    public static final RegistryObject<Block> ROADSIGN_1002_24 = BLOCKS.register("roadsigns/roadsign_1002_24", RoadSign::new);
}
