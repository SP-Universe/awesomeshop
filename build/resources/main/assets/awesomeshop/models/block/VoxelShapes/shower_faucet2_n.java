Stream.of(
Block.makeCuboidShape(3, 8, 13, 5, 12, 14),
Block.makeCuboidShape(11, 9, 12.8, 13, 11, 15.8),
Block.makeCuboidShape(3, 9, 12.8, 5, 11, 15.8),
Block.makeCuboidShape(11, 8, 13, 13, 12, 14),
Block.makeCuboidShape(10, 9, 12.99, 14, 11, 13.991),
Block.makeCuboidShape(2, 9, 12.99, 6, 11, 13.991),
Block.makeCuboidShape(5, 9.5, 14.5, 11, 10.5, 15.5),
Block.makeCuboidShape(1, 8, 15, 2, 12, 16),
Block.makeCuboidShape(14, 8, 15, 15, 12, 16),
Block.makeCuboidShape(2, 7, 15, 14, 13, 16)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});