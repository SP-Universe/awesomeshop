Stream.of(
Block.makeCuboidShape(3, 0, 4, 7, 1, 12),
Block.makeCuboidShape(4, 1, 5, 6, 2, 11),
Block.makeCuboidShape(4, 3, 15, 6, 12, 16),
Block.makeCuboidShape(4, 3, 0, 6, 12, 1),
Block.makeCuboidShape(4, 12, 0, 6, 13, 16),
Block.makeCuboidShape(4, 2, 0, 6, 3, 16),
Block.makeCuboidShape(3, 3, 1, 5, 12, 15),
Block.makeCuboidShape(2, 4, 5, 4, 7, 11),
Block.makeCuboidShape(10, 0, 4, 14, 1, 15),
Block.makeCuboidShape(11, 0, 1, 14, 1, 3)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});