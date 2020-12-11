Stream.of(
Block.makeCuboidShape(-0.75, 13.75, 0.025000000000000355, 3.25, 14.75, 15.975),
Block.makeCuboidShape(12, 1, 0, 16, 2, 16),
Block.makeCuboidShape(8.8, 4.2, 0, 12.8, 5.2, 16),
Block.makeCuboidShape(5.6, 7.4, 0, 9.6, 8.4, 16),
Block.makeCuboidShape(2.4000000000000004, 10.6, 0, 6.4, 11.6, 16)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});