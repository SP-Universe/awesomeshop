Stream.of(
Block.makeCuboidShape(6.068018933131122, 0.010000000000000009, 2.9718232460118355, 10.310658933131123, 1.99, 4.921573246011835),
Block.makeCuboidShape(3, 0, 6, 5, 2, 10),
Block.makeCuboidShape(6, 0, 3, 10, 2, 5),
Block.makeCuboidShape(11, 0, 6, 13, 2, 10),
Block.makeCuboidShape(6, 0, 11, 10, 2, 13),
Block.makeCuboidShape(5, 0.09999999999999998, 5, 11, 1.1, 11),
Block.makeCuboidShape(5.87868, 0.01, 11, 10.12132, 1.99, 12.94975),
Block.makeCuboidShape(11, 0.01, 5.87868, 12.94975, 1.99, 10.12132),
Block.makeCuboidShape(11, 0.01, 5.87868, 12.94975, 1.99, 10.12132)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});