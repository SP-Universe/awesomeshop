Stream.of(
Block.makeCuboidShape(0.025000000000000355, 13.75, 12.75, 15.975, 14.75, 16.75),
Block.makeCuboidShape(0, 1, 0, 16, 2, 4),
Block.makeCuboidShape(0, 4.2, 3.2, 16, 5.2, 7.2),
Block.makeCuboidShape(0, 7.4, 6.4, 16, 8.4, 10.4),
Block.makeCuboidShape(0, 10.6, 9.6, 16, 11.6, 13.6)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});