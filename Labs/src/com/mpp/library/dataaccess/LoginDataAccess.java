package mpp.library.dataaccess;


public interface LoginDataAccess<K, V> {

	public V add(K password, V v);

	public V get(K key);

	// ArrayList<LoginTestData> testData = new ArrayList<>();

}
