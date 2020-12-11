Stream.of(
Block.makeCuboidShape(2, 8, 3, 3, 12, 5),
Block.makeCuboidShape(0.1999999999999993, 9, 11, 3.1999999999999993, 11, 13),
Block.makeCuboidShape(0.1999999999999993, 9, 3, 3.1999999999999993, 11, 5),
Block.makeCuboidShape(2, 8, 11, 3, 12, 13),
Block.makeCuboidShape(2.0090000000000003, 9, 10, 3.01, 11, 14),
Block.makeCuboidShape(2.0090000000000003, 9, 2, 3.01, 11, 6),
Block.makeCuboidShape(0.5, 9.5, 5, 1.5, 10.5, 11),
Block.makeCuboidShape(0, 8, 1, 1, 12, 2),
Block.makeCuboidShape(0, 8, 14, 1, 12, 15),
Block.makeCuboidShape(0, 7, 2, 1, 13, 14)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});