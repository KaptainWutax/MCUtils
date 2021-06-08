package kaptainwutax.mcutils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kaptainwutax.mcutils.rand.seed.StructureSeed.toRandomWorldSeeds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StructureSeedTest {
	@Test
	@DisplayName("toRandomWorldSeeds")
	public void testToRandomWorldSeeds() {
		long seed=1L;
		List<Long> randomSeed=toRandomWorldSeeds(seed);
		assertEquals(1, randomSeed.size());
		assertEquals(randomSeed.get(0),8897424013823836161L);
	}

	@Test
	@DisplayName("toRandomWorldSeeds2")
	public void testToRandomWorldSeeds2() {
		long seed=6;
		List<Long> randomSeed=toRandomWorldSeeds(seed);
		assertEquals(2, randomSeed.size());
		assertEquals(-4286300945349869562L,randomSeed.get(0));
		assertEquals(1653665488175104006L,randomSeed.get(1));
	}

	@Test
	@DisplayName("toRandomWorldSeeds3")
	public void testToRandomWorldSeeds3() {
		long seed=4286578711L;
		List<Long> randomSeed=toRandomWorldSeeds(seed);
		assertEquals(0, randomSeed.size());
	}
}
