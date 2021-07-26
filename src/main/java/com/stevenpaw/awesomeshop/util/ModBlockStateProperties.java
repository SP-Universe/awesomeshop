package com.stevenpaw.awesomeshop.util;

import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class ModBlockStateProperties extends BlockStateProperties {
    public static final IntegerProperty LIGHTDIMMER = IntegerProperty.create("lightdimmer", 0, 3);
    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 15);
}
