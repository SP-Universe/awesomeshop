Stream.of(
Block.makeCuboidShape(0, 0, 5, 1, 18, 11),
Block.makeCuboidShape(3, 0, 5, 4, 18, 11),
Block.makeCuboidShape(1, 0, 10, 3, 18, 11),
Block.makeCuboidShape(1, 0, 5, 3, 18, 6)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});