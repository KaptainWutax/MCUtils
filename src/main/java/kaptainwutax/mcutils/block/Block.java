package kaptainwutax.mcutils.block;

import kaptainwutax.mcutils.util.data.Identifier;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.mcutils.version.VersionMap;

import java.util.HashMap;
import java.util.Map;

public class Block {


	private final int id;
	private final Identifier name;
	private final int meta;
	public Block(int id, String name) {
		this(id, name, 0);
	}
	public Block(int id, String name, int meta) {
		this.id = id;
		this.name = new Identifier(name);
		this.meta = meta;
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
