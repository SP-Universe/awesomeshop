Stream.of(
Block.makeCuboidShape(7, 3, 15, 9, 12, 16),
Block.makeCuboidShape(7, 1, 5, 9, 2, 11),
Block.makeCuboidShape(6, 0, 4, 10, 1, 12),
Block.makeCuboidShape(7, 3, 0, 9, 12, 1),
Block.makeCuboidShape(7, 2, 0, 9, 3, 16),
Block.makeCuboidShape(7, 12, 0, 9, 13, 16),
Block.makeCuboidShape(8, 3, 1, 10, 12, 15),
Block.makeCuboidShape(9, 4, 5, 11, 7, 11)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});