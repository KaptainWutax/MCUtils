package kaptainwutax.mcutils.state;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public enum Dimension {

	OVERWORLD("overworld", 0),
	NETHER("the_nether", -1),
	END("the_end", 1);

	private final int id;
	private final String name;
	private static final Map<String, Dimension> STRING_TO_DIMENSION = Arrays.stream(values())
			.collect(Collectors.toMap(Dimension::toString, o -> o));
	private static final Map<Integer, Dimension> ID_TO_DIMENSION = Arrays.stream(values())
			.collect(Collectors.toMap(Dimension::getId, o -> o));


	Dimension(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public static Dimension fromString(String name) {
		return STRING_TO_DIMENSION.get(name);
	}

	public static Dimension fromId(int id) {
		return ID_TO_DIMENSION.get(id);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}
}
