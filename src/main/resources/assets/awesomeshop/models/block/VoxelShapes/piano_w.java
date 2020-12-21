Stream.of(
Block.makeCuboidShape(0, 11, 5, 32, 21, 26),
Block.makeCuboidShape(-5, 11, -10, 2, 15, 26),
Block.makeCuboidShape(0, 11, -10, 17, 21, 5),
Block.makeCuboidShape(0, 0, -8, 2, 10, -6),
Block.makeCuboidShape(0, 0, 22, 2, 10, 24),
Block.makeCuboidShape(24, 0, 17, 26, 10, 19),
Block.makeCuboidShape(17, 11, -7, 22, 21, 5),
Block.makeCuboidShape(22, 11, 0, 29, 21, 5),
Block.makeCuboidShape(22, 11, -4, 26, 21, 0)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});