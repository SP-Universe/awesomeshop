Stream.of(
Block.makeCuboidShape(12.75, 13.75, 0.025000000000000355, 16.75, 14.75, 15.975),
Block.makeCuboidShape(0, 1, 0, 4, 2, 16),
Block.makeCuboidShape(3.1999999999999993, 4.2, 0, 7.199999999999999, 5.2, 16),
Block.makeCuboidShape(6.4, 7.4, 0, 10.4, 8.4, 16),
Block.makeCuboidShape(9.6, 10.6, 0, 13.6, 11.6, 16)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});