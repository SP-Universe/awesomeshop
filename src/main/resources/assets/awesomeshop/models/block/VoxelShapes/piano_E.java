Stream.of(
Block.makeCuboidShape(0, 11, 0, 14, 21, 16),
Block.makeCuboidShape(0, 11, 16, 14, 21, 26),
Block.makeCuboidShape(0, 11, -10, 14, 21, 0),
Block.makeCuboidShape(-16, 11, 5, 0, 21, 16),
Block.makeCuboidShape(-11, 11, 0, 0, 21, 5),
Block.makeCuboidShape(-6, 11, -5, 0, 21, 0),
Block.makeCuboidShape(-1, 11, -10, 0, 21, -5),
Block.makeCuboidShape(14, 11, -10, 21, 15, 26),
Block.makeCuboidShape(-16, 11, 16, 0, 21, 26)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});