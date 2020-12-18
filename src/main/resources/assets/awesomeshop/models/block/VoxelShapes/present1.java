Stream.of(
Block.makeCuboidShape(7, 0, 2.5, 9, 10.4, 13.5),
Block.makeCuboidShape(3, 6, 3, 13, 10, 13),
Block.makeCuboidShape(3.25, 0, 3.25, 12.75, 7, 12.75),
Block.makeCuboidShape(2.5, 0, 7, 13.5, 10.5, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});