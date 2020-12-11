Stream.of(
Block.makeCuboidShape(13, 8, 11, 14, 12, 13),
Block.makeCuboidShape(12.8, 9, 3, 15.8, 11, 5),
Block.makeCuboidShape(12.8, 9, 11, 15.8, 11, 13),
Block.makeCuboidShape(13, 8, 3, 14, 12, 5),
Block.makeCuboidShape(12.99, 9, 2, 13.991, 11, 6),
Block.makeCuboidShape(12.99, 9, 10, 13.991, 11, 14),
Block.makeCuboidShape(14.5, 9.5, 5, 15.5, 10.5, 11),
Block.makeCuboidShape(15, 8, 14, 16, 12, 15),
Block.makeCuboidShape(15, 8, 1, 16, 12, 2),
Block.makeCuboidShape(15, 7, 2, 16, 13, 14)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});