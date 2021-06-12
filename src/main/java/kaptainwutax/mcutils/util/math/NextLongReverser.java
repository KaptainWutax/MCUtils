package kaptainwutax.mcutils.util.math;

import kaptainwutax.seedutils.rand.JRand;

import java.util.ArrayList;
import java.util.List;

public class NextLongReverser {

	/**
	 * Adds seeds which give nextLongs congruent to your structure seed to a list.
	 * Has a precondition that structureSeed is 48 bits (its upper 16 bits as a long are 0)
	 *
	 * @param structureSeed the 48 bit version of the seed
	 * @param seedList      a list to add the seeds to
	 */
	public static void addSeedsToList(long structureSeed, List<Long> seedList) {
		long lowerBits = structureSeed & 0xffff_ffffL;
		long upperBits = structureSeed >>> 32;
		//Did the lower bits affect the upper bits
		if ((lowerBits & 0x8000_0000L) != 0)
			upperBits += 1; //restoring the initial value of the upper bits

		//TODO I can only guarantee the algorithm's correctness for bitsOfDanger = 0 but believe 1 should still always work, needs to be confirmed!!!

		//The algorithm is meant to have bitsOfDanger = 0, but this runs into overflow issues.
		//By using a different small value, we introduce small numerical error which probably cannot break things
		//while keeping everything in range of a long and avoiding nasty BigDecimal/BigInteger overhead
		int bitsOfDanger = 1;

		long lowMin = lowerBits << 16 - bitsOfDanger;
		long lowMax = ((lowerBits + 1) << 16 - bitsOfDanger) - 1;
		long upperMin = ((upperBits << 16) - 107048004364969L) >> bitsOfDanger;

		//hardcoded matrix multiplication again
		long m1lv = Math.floorDiv(lowMax * -33441 + upperMin * 17549, 1L << 31 - bitsOfDanger) + 1; //I cancelled out a common factor of 2 in this line
		long m2lv = Math.floorDiv(lowMin * 46603 + upperMin * 39761, 1L << 32 - bitsOfDanger) + 1;

		long seed;

		// (0,0) -> 0.6003265380859375
		seed = (-39761 * m1lv + 35098 * m2lv);
		if ((46603 * m1lv + 66882 * m2lv) + 107048004364969L >>> 16 == upperBits) {
			if (seed >>> 16 == lowerBits)
				seedList.add((254681119335897L * seed + 120305458776662L) & 0xffff_ffff_ffffL); //pull back 2 LCG calls
		}
		//(1,0) -> 0.282440185546875
		seed = (-39761 * (m1lv + 1) + 35098 * m2lv);
		if ((46603 * (m1lv + 1) + 66882 * m2lv) + 107048004364969L >>> 16 == upperBits) {
			if (seed >>> 16 == lowerBits)
				seedList.add((254681119335897L * seed + 120305458776662L) & 0xffff_ffff_ffffL); //pull back 2 LCG calls
		}
		//(0,1) -> 0.1172332763671875
		seed = (-39761 * m1lv + 35098 * (m2lv + 1));
		if ((46603 * m1lv + 66882 * (m2lv + 1)) + 107048004364969L >>> 16 == upperBits) {
			if (seed >>> 16 == lowerBits)
				seedList.add((254681119335897L * seed + 120305458776662L) & 0xffff_ffff_ffffL); //pull back 2 LCG calls
		}
		//(1,1) -> 0.0
	}

	/**
	 * Returns of list of seeds which give nextLongs congruent to your structure seed.
	 * Has a precondition that structureSeed is 48 bits (its upper 16 bits as a long are 0)
	 *
	 * @param structureSeed the 48 bit version of the seed
	 */
	public static ArrayList<Long> getSeeds(long structureSeed) {
		ArrayList<Long> seeds = new ArrayList<>(2);
		addSeedsToList(structureSeed, seeds);
		return seeds;
	}

	/**
	 * Adds nextLongs congruent to your structure seed to a list.
	 * Has a precondition that structureSeed is 48 bits (its upper 16 bits as a long are 0)
	 *
	 * @param structureSeed the 48 bit version of the seed
	 * @param nextLongs     a list to add the nextLongs to
	 */
	public static void addNextLongEquivalents(long structureSeed, List<Long> nextLongs) {
		//this technically does some redundant operations
		for (long seed : getSeeds(structureSeed)) {
			nextLongs.add(new JRand(seed, false).nextLong());
		}
	}

	/**
	 * Returns of nextLongs congruent to your structure seed.
	 * Has a precondition that structureSeed is 48 bits (its upper 16 bits as a long are 0)
	 *
	 * @param structureSeed the 48 bit version of the seed
	 */
	public static ArrayList<Long> getNextLongEquivalents(long structureSeed) {
		ArrayList<Long> nextLongs = new ArrayList<>(2);
		addNextLongEquivalents(structureSeed, nextLongs);
		return nextLongs;
	}
}
