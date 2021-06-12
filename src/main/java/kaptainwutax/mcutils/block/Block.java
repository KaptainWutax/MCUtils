package kaptainwutax.mcutils.block;

import kaptainwutax.mcutils.util.data.Identifier;
import kaptainwutax.mcutils.version.MCVersion;

public class Block {


	private final int id;
	private final Identifier name;
	private final int meta;
	private final MCVersion version;
	private final MCVersion implementedVersion;

	public Block(MCVersion version, int id, String name, MCVersion historic) {
		this(version, id, name, historic, 0);
	}

	public Block(MCVersion version, int id, String name, MCVersion historic, int meta) {
		this.version = version;
		this.id = id;
		this.name = new Identifier(name);
		this.implementedVersion = historic;
		this.meta = meta;
	}

	public MCVersion getImplementedVersion() {
		return implementedVersion;
	}

	public MCVersion getVersion() {
		return version;
	}

	public int getId() {
		return this.id;
	}

	public Identifier getIdentifier() {
		return this.name;
	}

	public String getRegistryName() {
		return this.name.toString();
	}

	public String getName() {
		return this.name.getPath();
	}

	public int getMeta() {
		return this.meta;
	}

	@Override
	public int hashCode() {
		return this.getRegistryName().hashCode() * 31 + this.meta;
	}

	@Override
	public String toString() {
		return this.getRegistryName();
	}


}
