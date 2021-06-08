package kaptainwutax.mcutils;

import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.block.Blocks;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlocksTest {
	@Test
	public void StatsTest() {
		Map<Integer, Block> v1_14 = Blocks.VERSIONED_REGISTRY.getMapUntil(MCVersion.v1_14);
		assertEquals(676, v1_14.size());
		Map<Integer, Block> v1_15 = Blocks.VERSIONED_REGISTRY.getMapUntil(MCVersion.v1_15);
		assertEquals(680, v1_15.size());
		Map<Integer, Block> v1_16 = Blocks.VERSIONED_REGISTRY.getMapUntil(MCVersion.v1_16);
		assertEquals(763, v1_16.size());
		Map<Integer, Block> v1_17 = Blocks.VERSIONED_REGISTRY.getMapUntil(MCVersion.v1_17);
		assertEquals(898, v1_17.size());
		assertEquals(898, Blocks.LATEST_REGISTRY.size());
		// this is because GRASS_PATH was renammed to DIRT_PATH (I don't know how to correctly handle it because as of
		// right now it look like DIRT_PATH is a new block in 1.17 and GRASS_PATH was never changed, I might need to add a deprecated field)
		assertEquals(899, Blocks.LATEST_ID_REGISTRY.size());
	}
}
