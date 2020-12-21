Stream.of(
Block.makeCuboidShape(-10, 11, 0, 11, 21, 32),
Block.makeCuboidShape(-10, 11, -5, 26, 15, 2),
Block.makeCuboidShape(11, 11, 0, 26, 21, 17),
Block.makeCuboidShape(22, 0, 0, 24, 10, 2),
Block.makeCuboidShape(-8, 0, 0, -6, 10, 2),
Block.makeCuboidShape(-3, 0, 24, -1, 10, 26),
Block.makeCuboidShape(11, 11, 17, 23, 21, 22),
Block.makeCuboidShape(11, 11, 22, 16, 21, 29),
Block.makeCuboidShape(16, 11, 22, 20, 21, 26)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});