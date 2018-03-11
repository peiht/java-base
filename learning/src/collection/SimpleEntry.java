package collection;

import java.util.Map;

public class SimpleEntry<K, V> implements Map.Entry<K, V>{

	private K key = null;
	private V value = null;
	
	public SimpleEntry(K k,V v){
		this.key = k;
		this.value = v;
	}
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

}
