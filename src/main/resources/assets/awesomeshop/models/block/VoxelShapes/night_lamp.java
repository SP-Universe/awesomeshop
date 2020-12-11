Stream.of(
Block.makeCuboidShape(6, 11, 6, 10, 13, 10),
Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
Block.makeCuboidShape(7, 2, 7, 9, 11, 9),
Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
Block.makeCuboidShape(4, 6, 4, 12, 9, 5),
Block.makeCuboidShape(4, 6, 11, 12, 9, 12),
Block.makeCuboidShape(4, 6, 5, 5, 9, 11),
Block.makeCuboidShape(11, 6, 5, 12, 9, 11),
Block.makeCuboidShape(5, 9, 6, 6, 11, 10),
Block.makeCuboidShape(5, 9, 10, 11, 11, 11),
Block.makeCuboidShape(5, 9, 5, 11, 11, 6),
Block.makeCuboidShape(10, 9, 6, 11, 11, 10)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});