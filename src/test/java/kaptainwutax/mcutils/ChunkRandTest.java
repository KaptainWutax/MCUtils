package kaptainwutax.mcutils;

import kaptainwutax.mcutils.rand.ChunkRand;
import kaptainwutax.seedutils.lcg.rand.JRand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChunkRandTest {
	@Test
	@DisplayName("Test ChunkRand Debugger")
	public void testChunkRand() {
		ChunkRand chunkRand = new ChunkRand(1);
		ChunkRand.Debugger debugger1 = chunkRand.asChunkRandDebugger();
		JRand.Debugger debugger2 = debugger1.asDebugger();
		debugger1.nextSeed();
		assertEquals(1, debugger1.getGlobalCounter());
		assertEquals(0, debugger2.getGlobalCounter());
	}
}
