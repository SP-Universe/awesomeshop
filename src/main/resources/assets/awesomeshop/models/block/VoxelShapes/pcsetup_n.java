Stream.of(
Block.makeCuboidShape(4, 0, 9, 12, 1, 13),
Block.makeCuboidShape(5, 1, 10, 11, 2, 12),
Block.makeCuboidShape(15, 3, 10, 16, 12, 12),
Block.makeCuboidShape(0, 3, 10, 1, 12, 12),
Block.makeCuboidShape(0, 12, 10, 16, 13, 12),
Block.makeCuboidShape(0, 2, 10, 16, 3, 12),
Block.makeCuboidShape(1, 3, 11, 15, 12, 13),
Block.makeCuboidShape(5, 4, 12, 11, 7, 14),
Block.makeCuboidShape(4, 0, 2, 15, 1, 6),
Block.makeCuboidShape(1, 0, 2, 3, 1, 5)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});