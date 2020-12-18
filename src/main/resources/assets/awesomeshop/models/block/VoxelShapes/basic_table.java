Stream.of(
Block.makeCuboidShape(13, 0, 1, 15, 15, 3),
Block.makeCuboidShape(1, 0, 1, 3, 15, 3),
Block.makeCuboidShape(0, 14, 0, 16, 16, 16),
Block.makeCuboidShape(1, 0, 13, 3, 15, 15),
Block.makeCuboidShape(13, 0, 13, 15, 15, 15)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});