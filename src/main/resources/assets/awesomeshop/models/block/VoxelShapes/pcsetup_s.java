Stream.of(
Block.makeCuboidShape(4, 0, 3, 12, 1, 7),
Block.makeCuboidShape(5, 1, 4, 11, 2, 6),
Block.makeCuboidShape(0, 3, 4, 1, 12, 6),
Block.makeCuboidShape(15, 3, 4, 16, 12, 6),
Block.makeCuboidShape(0, 12, 4, 16, 13, 6),
Block.makeCuboidShape(0, 2, 4, 16, 3, 6),
Block.makeCuboidShape(1, 3, 3, 15, 12, 5),
Block.makeCuboidShape(5, 4, 2, 11, 7, 4),
Block.makeCuboidShape(1, 0, 10, 12, 1, 14),
Block.makeCuboidShape(13, 0, 11, 15, 1, 14)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});