Stream.of(
Block.makeCuboidShape(8, 0, 0, 16, 1, 16),
Block.makeCuboidShape(15, 1, 3, 16, 9, 13),
Block.makeCuboidShape(8, 9, 0, 16, 10, 16),
Block.makeCuboidShape(8, 10, 2, 16, 11, 14),
Block.makeCuboidShape(10, 11, 4, 16, 12, 12),
Block.makeCuboidShape(15, 12, 5, 16, 18, 11),
Block.makeCuboidShape(12, 12, 5, 13, 18, 11),
Block.makeCuboidShape(13, 12, 5, 15, 18, 6),
Block.makeCuboidShape(13, 12, 10, 15, 18, 11),
Block.makeCuboidShape(6, 9, 4, 8, 10, 12),
Block.makeCuboidShape(6, 8, 3, 7, 9, 5),
Block.makeCuboidShape(6, 8, 11, 7, 9, 13),
Block.makeCuboidShape(8, 1, 13, 16, 9, 16),
Block.makeCuboidShape(7, 1, 1, 8, 10, 4),
Block.makeCuboidShape(7, 1, 12, 8, 10, 15),
Block.makeCuboidShape(8, 1, 0, 16, 9, 3),
Block.makeCuboidShape(7, 0, 1, 8, 1, 15),
Block.makeCuboidShape(5, 0, 5, 6, 1, 11),
Block.makeCuboidShape(6, 0, 3, 7, 1, 13),
Block.makeCuboidShape(7, 3, 4, 8, 4, 12),
Block.makeCuboidShape(7, 1, 9, 8, 3, 10),
Block.makeCuboidShape(7, 1, 6, 8, 3, 7)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});