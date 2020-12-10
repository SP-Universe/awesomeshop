Stream.of(
Block.makeCuboidShape(9, 1, 5, 10, 4, 11),
Block.makeCuboidShape(7, 0, 5, 10, 1, 11),
Block.makeCuboidShape(7, 1, 5, 8, 4, 11),
Block.makeCuboidShape(8, 1, 4, 9, 5, 12)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});