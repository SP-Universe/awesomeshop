Stream.of(
Block.makeCuboidShape(0, 11, 2, 16, 21, 16),
Block.makeCuboidShape(16, 11, 2, 26, 21, 16),
Block.makeCuboidShape(-10, 11, 2, 0, 21, 16),
Block.makeCuboidShape(5, 11, 16, 16, 21, 32),
Block.makeCuboidShape(0, 11, 16, 5, 21, 27),
Block.makeCuboidShape(-5, 11, 16, 0, 21, 22),
Block.makeCuboidShape(-10, 11, 16, -5, 21, 17),
Block.makeCuboidShape(-10, 11, -5, 26, 15, 2),
Block.makeCuboidShape(16, 11, 16, 26, 21, 32)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});