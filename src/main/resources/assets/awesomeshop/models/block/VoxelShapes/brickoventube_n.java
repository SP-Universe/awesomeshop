Stream.of(
Block.makeCuboidShape(5, 0, 15, 11, 18, 16),
Block.makeCuboidShape(5, 0, 12, 11, 18, 13),
Block.makeCuboidShape(10, 0, 13, 11, 18, 15),
Block.makeCuboidShape(5, 0, 13, 6, 18, 15)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});