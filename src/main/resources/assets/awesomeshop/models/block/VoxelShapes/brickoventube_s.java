Stream.of(
Block.makeCuboidShape(5, 0, 0, 11, 18, 1),
Block.makeCuboidShape(5, 0, 3, 11, 18, 4),
Block.makeCuboidShape(5, 0, 1, 6, 18, 3),
Block.makeCuboidShape(10, 0, 1, 11, 18, 3)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});