Stream.of(
Block.makeCuboidShape(0, 3, 7, 1, 12, 9),
Block.makeCuboidShape(5, 1, 7, 11, 2, 9),
Block.makeCuboidShape(4, 0, 6, 12, 1, 10),
Block.makeCuboidShape(15, 3, 7, 16, 12, 9),
Block.makeCuboidShape(0, 2, 7, 16, 3, 9),
Block.makeCuboidShape(0, 12, 7, 16, 13, 9),
Block.makeCuboidShape(1, 3, 8, 15, 12, 10),
Block.makeCuboidShape(5, 4, 9, 11, 7, 11)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});