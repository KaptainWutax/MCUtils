package kaptainwutax.mcutils.state;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum Dimension {

	OVERWORLD("overworld", 0),
	NETHER("nether", 1),
	END("end", -1)
	;

	private static final Map<String, Dimension> STRING_TO_DIMENSION = Arrays.stream(values())
			.collect(Collectors.toMap(Dimension::toString, o -> o));
	public final int id;
	private final String name;

	Dimension(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public static Dimension fromString(String name) {
		return STRING_TO_DIMENSION.get(name);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}
}
