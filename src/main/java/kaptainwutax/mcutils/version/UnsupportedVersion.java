package kaptainwutax.mcutils.version;

public class UnsupportedVersion extends RuntimeException {

	public UnsupportedVersion(MCVersion version, String type) {
		super("Minecraft " + version + " does not support " + type);
	}

}
