Stream.of(
Block.makeCuboidShape(9, 0, 4, 13, 1, 12),
Block.makeCuboidShape(10, 1, 5, 12, 2, 11),
Block.makeCuboidShape(10, 3, 0, 12, 12, 1),
Block.makeCuboidShape(10, 3, 15, 12, 12, 16),
Block.makeCuboidShape(10, 12, 0, 12, 13, 16),
Block.makeCuboidShape(10, 2, 0, 12, 3, 16),
Block.makeCuboidShape(11, 3, 1, 13, 12, 15),
Block.makeCuboidShape(12, 4, 5, 14, 7, 11),
Block.makeCuboidShape(2, 0, 1, 6, 1, 12),
Block.makeCuboidShape(2, 0, 13, 5, 1, 15)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});