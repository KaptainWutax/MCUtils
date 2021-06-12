package kaptainwutax.mcutils.rand.seed;

import kaptainwutax.mcutils.rand.ChunkRand;

public class PositionSeed {
	private static final ChunkRand INTERNAL = new ChunkRand();

	@SuppressWarnings("IntegerMultiplicationImplicitCastToLong")
	public static long getPositionSeed(int x, int y, int z) {
		long i = (long) (x * 3129871) ^ (long) z * 116129781L ^ (long) y;
		i = i * i * 42317861L + i * 11L;
		return i >> 16;
	}

	public static long getBaseStoneSeed(long worldSeed, int x, int y, int z) {
		return INTERNAL.setBaseStoneSeed(worldSeed, x, y, z);
	}
}
