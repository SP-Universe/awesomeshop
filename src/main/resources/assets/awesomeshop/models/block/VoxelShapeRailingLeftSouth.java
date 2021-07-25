Stream.of(
Block.makeCuboidShape(0.4999999999999982, -11, 10.299999999999999, 1.4999999999999982, 5, 11.299999999999999),
Block.makeCuboidShape(0.4999999999999982, -8, 7, 1.4999999999999982, 8, 8),
Block.makeCuboidShape(0.4999999999999982, -14.2, 13.5, 1.4999999999999982, 1.8000000000000007, 14.5),
Block.makeCuboidShape(0.4999999999999982, -5, 4, 1.4999999999999982, 11, 5),
Block.makeCuboidShape(0.4999999999999982, -1.6999999999999993, 0.7000000000000011, 1.4999999999999982, 14.299999999999999, 1.700000000000001)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});