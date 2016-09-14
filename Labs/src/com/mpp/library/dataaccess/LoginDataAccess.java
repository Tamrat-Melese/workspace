package mpp.library.dataaccess;

public interface LoginDataAccess<K, V> {

	public V add(K password, V user);

	public V get(K key);

}
