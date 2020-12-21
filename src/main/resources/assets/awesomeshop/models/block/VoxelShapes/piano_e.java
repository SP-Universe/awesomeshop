Stream.of(
Block.makeCuboidShape(-16, 11, -10, 16, 21, 11),
Block.makeCuboidShape(14, 11, -10, 21, 15, 26),
Block.makeCuboidShape(-1, 11, 11, 16, 21, 26),
Block.makeCuboidShape(14, 0, 22, 16, 10, 24),
Block.makeCuboidShape(14, 0, -8, 16, 10, -6),
Block.makeCuboidShape(-10, 0, -3, -8, 10, -1),
Block.makeCuboidShape(-6, 11, 11, -1, 21, 23),
Block.makeCuboidShape(-13, 11, 11, -6, 21, 16),
Block.makeCuboidShape(-10, 11, 16, -6, 21, 20)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});