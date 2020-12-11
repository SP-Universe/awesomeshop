Stream.of(
Block.makeCuboidShape(3, 0, 2, 13, 1, 14),
Block.makeCuboidShape(4, 0, 1, 12, 1, 2),
Block.makeCuboidShape(4, 0, 14, 12, 1, 15)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});