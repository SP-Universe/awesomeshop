Stream.of(
Block.makeCuboidShape(2, 11, 0, 16, 21, 16),
Block.makeCuboidShape(2, 11, -10, 16, 21, 0),
Block.makeCuboidShape(2, 11, 16, 16, 21, 26),
Block.makeCuboidShape(16, 11, 0, 32, 21, 11),
Block.makeCuboidShape(16, 11, 11, 27, 21, 16),
Block.makeCuboidShape(16, 11, 16, 22, 21, 21),
Block.makeCuboidShape(16, 11, 21, 17, 21, 26),
Block.makeCuboidShape(-5, 11, -10, 2, 15, 26),
Block.makeCuboidShape(16, 11, -10, 32, 21, 0)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});