Stream.of(
Block.makeCuboidShape(5, 11, -16, 26, 21, 16),
Block.makeCuboidShape(-10, 11, 14, 26, 15, 21),
Block.makeCuboidShape(-10, 11, -1, 5, 21, 16),
Block.makeCuboidShape(-8, 0, 14, -6, 10, 16),
Block.makeCuboidShape(22, 0, 14, 24, 10, 16),
Block.makeCuboidShape(17, 0, -10, 19, 10, -8),
Block.makeCuboidShape(-7, 11, -6, 5, 21, -1),
Block.makeCuboidShape(0, 11, -13, 5, 21, -6),
Block.makeCuboidShape(-4, 11, -10, 0, 21, -6)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});