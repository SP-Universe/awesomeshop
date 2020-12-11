Stream.of(
Block.makeCuboidShape(0.025000000000000355, 13.75, -0.75, 15.975, 14.75, 3.25),
Block.makeCuboidShape(0, 1, 12, 16, 2, 16),
Block.makeCuboidShape(0, 4.2, 8.8, 16, 5.2, 12.8),
Block.makeCuboidShape(0, 7.4, 5.6, 16, 8.4, 9.6),
Block.makeCuboidShape(0, 10.6, 2.4000000000000004, 16, 11.6, 6.4)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});