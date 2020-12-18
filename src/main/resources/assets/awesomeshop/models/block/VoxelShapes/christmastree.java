Stream.of(
Block.makeCuboidShape(2, 20, 2, 14, 32, 14),
Block.makeCuboidShape(0, 8, 0, 16, 20, 16),
Block.makeCuboidShape(-3, 0, -3, 19, 8, 19)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});