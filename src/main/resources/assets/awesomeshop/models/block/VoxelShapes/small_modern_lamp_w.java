Stream.of(
Block.makeCuboidShape(4.5, 8, 4.5, 11.5, 15, 11.5),
Block.makeCuboidShape(5, 0, 4, 11, 1, 12),
Block.makeCuboidShape(5, 5, 4, 11, 6, 12),
Block.makeCuboidShape(5, 1, 4, 11, 5, 5),
Block.makeCuboidShape(5, 1, 11, 11, 5, 12),
Block.makeCuboidShape(7, 5.5, 7, 9, 8.5, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});