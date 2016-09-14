package mpp.library.dataaccess;

import java.util.HashMap;
import java.util.Map;

public class LoginDataAccessImpl<K, V> implements LoginDataAccess<K, V> {
	private Map<K, V> dataMap = new HashMap<K, V>();

	@Override
	public V get(K key) {
		return dataMap.get(key);
	}

	@Override
	public V add(K key, V value) {

		return dataMap.put(key, value);
	}
}
