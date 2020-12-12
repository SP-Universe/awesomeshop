Stream.of(
Block.makeCuboidShape(4.5, 8, 4.5, 11.5, 15, 11.5),
Block.makeCuboidShape(4, 0, 5, 12, 1, 11),
Block.makeCuboidShape(4, 5, 5, 12, 6, 11),
Block.makeCuboidShape(4, 1, 5, 5, 5, 11),
Block.makeCuboidShape(11, 1, 5, 12, 5, 11),
Block.makeCuboidShape(7, 5.5, 7, 9, 8.5, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});