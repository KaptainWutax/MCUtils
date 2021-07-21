package kaptainwutax.mcutils.util.pos;

import kaptainwutax.mcutils.util.data.SpiralIterator;
import kaptainwutax.mcutils.util.math.Vec3i;

import java.util.function.Function;

@SuppressWarnings("unused")
public class RPos extends Vec3i {

	private final int regionSize;

	public RPos(int x, int z, int regionSize) {
		super(x, 0, z);
		this.regionSize = regionSize;
	}

	public RPos add(CPos pos) {
		return this.add(pos.getX(), pos.getZ());
	}

	public RPos subtract(CPos pos) {
		return this.subtract(pos.getX(), pos.getZ());
	}

	public RPos shl(int amount) {
		return this.shl(amount, amount);
	}

	public RPos shr(int amount) {
		return this.shr(amount, amount);
	}

	public RPos add(int x, int z) {
		return new RPos(this.getX() + x, this.getZ() + z, this.regionSize);
	}

	public RPos subtract(int x, int z) {
		return new RPos(this.getX() - x, this.getZ() - z, this.regionSize);
	}

	public RPos shl(int bx, int bz) {
		return new RPos(this.getX() << bx, this.getZ() << bz, this.regionSize);
	}

	public RPos shr(int bx, int bz) {
		return new RPos(this.getX() >> bx, this.getZ() >> bz, this.regionSize);
	}

	/**
	 * Recalculate the region based on the new size
	 *
	 * @param regionSize the size to calulcate the new base in
	 * @return a new RPos
	 */
	public RPos changeRegionSize(int regionSize) {
		int x = this.getX() * this.regionSize;
		x = x < 0 ? x - regionSize + 1 : x;
		int z = this.getZ() * this.regionSize;
		z = z < 0 ? z - regionSize + 1 : z;
		return new RPos(x / regionSize, z / regionSize, regionSize);
	}

	public int getRegionSize() {
		return this.regionSize;
	}

	public BPos toBlockPos() {
		return new BPos(this.getX() * this.getRegionSize(), 0, this.getZ() * this.getRegionSize());
	}

	public CPos toChunkPos() {
		return new CPos(this.getX() * this.getRegionSize(), this.getZ() * this.getRegionSize());
	}

	/**
	 * Interface to create a RPos from ((x,y,z),regionSize) by discarding y
	 * call RPos.Builder.create(regionSize)
	 */
	@FunctionalInterface
	public interface Builder {
		RPos create(int x, int z);

		static SpiralIterator.Builder<RPos> create(int regionSize) {
			return (x,y,z)->new RPos(x,z,regionSize);
		}
	}
}
