Stream.of(
Block.makeCuboidShape(5, 1, 9, 11, 4, 10),
Block.makeCuboidShape(5, 0, 7, 11, 1, 10),
Block.makeCuboidShape(5, 1, 7, 11, 4, 8),
Block.makeCuboidShape(4, 1, 8, 12, 5, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});