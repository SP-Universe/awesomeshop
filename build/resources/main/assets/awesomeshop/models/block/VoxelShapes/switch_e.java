Stream.of(
Block.makeCuboidShape(6, 1, 5, 7, 4, 11),
Block.makeCuboidShape(6, 0, 5, 9, 1, 11),
Block.makeCuboidShape(8, 1, 5, 9, 4, 11),
Block.makeCuboidShape(7, 1, 4, 8, 5, 12)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});