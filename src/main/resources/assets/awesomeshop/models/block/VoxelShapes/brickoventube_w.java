Stream.of(
Block.makeCuboidShape(15, 0, 5, 16, 18, 11),
Block.makeCuboidShape(12, 0, 5, 13, 18, 11),
Block.makeCuboidShape(13, 0, 5, 15, 18, 6),
Block.makeCuboidShape(13, 0, 10, 15, 18, 11)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});