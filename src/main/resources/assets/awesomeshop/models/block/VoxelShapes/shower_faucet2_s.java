Stream.of(
Block.makeCuboidShape(11, 8, 2, 13, 12, 3),
Block.makeCuboidShape(3, 9, 0.1999999999999993, 5, 11, 3.1999999999999993),
Block.makeCuboidShape(11, 9, 0.1999999999999993, 13, 11, 3.1999999999999993),
Block.makeCuboidShape(3, 8, 2, 5, 12, 3),
Block.makeCuboidShape(2, 9, 2.0090000000000003, 6, 11, 3.01),
Block.makeCuboidShape(10, 9, 2.0090000000000003, 14, 11, 3.01),
Block.makeCuboidShape(5, 9.5, 0.5, 11, 10.5, 1.5),
Block.makeCuboidShape(14, 8, 0, 15, 12, 1),
Block.makeCuboidShape(1, 8, 0, 2, 12, 1),
Block.makeCuboidShape(2, 7, 0, 14, 13, 1)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});