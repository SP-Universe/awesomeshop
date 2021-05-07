Stream.of(
Block.makeCuboidShape(0, 11, 0, 16, 21, 14),
Block.makeCuboidShape(-10, 11, 0, 0, 21, 14),
Block.makeCuboidShape(16, 11, 0, 26, 21, 14),
Block.makeCuboidShape(0, 11, -16, 11, 21, 0),
Block.makeCuboidShape(11, 11, -11, 16, 21, 0),
Block.makeCuboidShape(16, 11, -6, 21, 21, 0),
Block.makeCuboidShape(21, 11, -1, 26, 21, 0),
Block.makeCuboidShape(-10, 11, 14, 26, 15, 21),
Block.makeCuboidShape(-10, 11, -16, 0, 21, 0)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});