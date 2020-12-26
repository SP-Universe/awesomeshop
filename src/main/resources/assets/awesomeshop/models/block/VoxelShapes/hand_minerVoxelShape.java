Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 12, 16),
Block.makeCuboidShape(3, 12, 3, 13, 14, 13),
Block.makeCuboidShape(5, 14, 5, 11, 16, 11)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});