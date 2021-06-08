package kaptainwutax.mcutils.version;

import java.util.*;

public class VersionMap<V> extends AbstractMap<MCVersion, V> {

	protected List<Entry<V>> entries = new ArrayList<>();

	@Override
	public Set<Map.Entry<MCVersion, V>> entrySet() {
		return new LinkedHashSet<>(this.entries);
	}

	public VersionMap<V> add(MCVersion key, V value) {
		this.put(key, value);
		return this;
	}

	@Override
	public V put(MCVersion key, V value) {
		for (Entry<V> e : this.entries) {
			if (e.getKey() == key) return e.setValue(value);
		}

		this.entries.add(new Entry<>(key, value));
		this.sort();
		return null;
	}

	/**
	 * Compute a map with all the previous element from all previous version (the latest element overrides the oldest),
	 * the V generic must be a map else this will fail
	 * @param version the latest version to get items from
	 * @param <E> the key type of your map
	 * @param <K> the value type of your map
	 * @return a map with all elements until the version (latest wins)
	 */
	@SuppressWarnings("unchecked")
	public <E,K> Map<E,K> getMapUntil(MCVersion version) {
		Map<E,K> value = null;
		ArrayList<Entry<V>> entries=new ArrayList<>(this.entries);
		// very important to do it b against a (we want older to newest...)
		entries.sort((a,b)->b.getKey().compareTo(a.getKey()));
		for (Entry<V> e : entries) {
			if (e.getKey().isNewerThan(version)) continue;
			if (value==null){
				value = (Map<E,K>) e.getValue();
			}else{
				for (Map.Entry<E,K> entry:((Map<E,K>) e.getValue()).entrySet()){
					// we can override old elements since the entries are sorted from oldest to newest
					value.put(entry.getKey(),entry.getValue());
				}
			}
		}

		return value;
	}

	public V getAsOf(MCVersion version) {
		V value = null;

		for (Entry<V> e : this.entries) {
			if (e.getKey().isNewerThan(version)) break;
			value = e.getValue();
		}

		return value;
	}

	public V getLatest() {
		if (this.isEmpty()) return null;
		return this.entries.get(this.entries.size() - 1).getValue();
	}

	public MCVersion getLatestVersion() {
		if (this.isEmpty()) return null;
		return this.entries.get(this.entries.size() - 1).getKey();
	}

	public V getOldest() {
		if (this.isEmpty()) return null;
		return this.entries.get(0).getValue();
	}

	public MCVersion getOldestVersion() {
		if (this.isEmpty()) return null;
		return this.entries.get(0).getKey();
	}

	protected void sort() {
		this.entries.sort((o1, o2) -> o1.getKey().isOlderThan(o2.getKey()) ? -1 : o1.getKey().isEqualTo(o2.getKey()) ? 0 : 1);
	}

	public static class Entry<V> implements Map.Entry<MCVersion, V> {
		private final MCVersion key;
		private V value;

		public Entry(MCVersion key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public MCVersion getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V value) {
			V old = this.getValue();
			this.value = value;
			return old;
		}

		@Override
		public boolean equals(Object o) {
			return false;
		}

		@Override
		public int hashCode() {
			return this.key.hashCode() * 31 + this.value.hashCode();
		}
	}

}
