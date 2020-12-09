Stream.of(
Block.makeCuboidShape(2, 0, 3, 14, 1, 13),
Block.makeCuboidShape(1, 0, 4, 2, 1, 12),
Block.makeCuboidShape(14, 0, 4, 15, 1, 12)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});