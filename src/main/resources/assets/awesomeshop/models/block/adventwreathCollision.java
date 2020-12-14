Stream.of(
Block.makeCuboidShape(3, 0, 6, 5, 2, 10),
Block.makeCuboidShape(6, 0, 3, 10, 2, 5),
Block.makeCuboidShape(11, 0, 6, 13, 2, 10),
Block.makeCuboidShape(6, 0, 11, 10, 2, 13),
Block.makeCuboidShape(7.5, 2, 3.5, 8.5, 6, 4.5),
Block.makeCuboidShape(3.5, 2, 7.5, 4.5, 6, 8.5),
Block.makeCuboidShape(11.5, 2, 7.5, 12.5, 6, 8.5),
Block.makeCuboidShape(7.5, 2, 11.5, 8.5, 6, 12.5),
Block.makeCuboidShape(3, 0, 3, 13, 2, 13)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});