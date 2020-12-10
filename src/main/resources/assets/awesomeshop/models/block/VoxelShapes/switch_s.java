Stream.of(
Block.makeCuboidShape(5, 1, 6, 11, 4, 7),
Block.makeCuboidShape(5, 0, 6, 11, 1, 9),
Block.makeCuboidShape(5, 1, 8, 11, 4, 9),
Block.makeCuboidShape(4, 1, 7, 12, 5, 8)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});