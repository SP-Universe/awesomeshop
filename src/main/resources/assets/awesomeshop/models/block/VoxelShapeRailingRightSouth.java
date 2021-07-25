Stream.of(
Block.makeCuboidShape(14.499999999999998, -11, 10.299999999999999, 15.499999999999998, 5, 11.299999999999999),
Block.makeCuboidShape(14.499999999999998, -8, 7, 15.499999999999998, 8, 8),
Block.makeCuboidShape(14.499999999999998, -14.2, 13.5, 15.499999999999998, 1.8000000000000007, 14.5),
Block.makeCuboidShape(14.499999999999998, -5, 4, 15.499999999999998, 11, 5),
Block.makeCuboidShape(14.499999999999998, -1.6999999999999993, 0.7000000000000011, 15.499999999999998, 14.299999999999999, 1.700000000000001)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});