package learning.thread;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapL<K,V> extends AbstractMap<K,V> {

	private List<K> keys = new ArrayList<K>();
	
	private List<V> values = new ArrayList<V>();
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		
		Iterator<K> keyIterator = keys.iterator();
		Iterator<V> valueIterator = values.iterator();
		
		while(keyIterator.hasNext() && valueIterator.hasNext())
		{
			K key = keyIterator.next();
			V value = valueIterator.next();
			Map.Entry<K, V> entry = new SimpleEntry<K, V>(key,value);
			set.add(entry);
		}
		return set;
	}

	public V put(K key,V value){
		V oldValue = null;
		int index = this.keys.indexOf(key);
		if(index >=0 )
		{
			oldValue = this.values.get(index);
			this.values.set(index, value);
		}else{
			this.keys.add(key);
			this.values.add(value);
		}
	    return oldValue;	
	}
	
	/**
	 * 取数的逻辑，先取出list中key的索引，再根据索引去value 的list中把值取出来
	 */
	public V get(Object k){
		V value = null;
		int index = this.keys.indexOf(k);
		if(index >=0 ){
			value = this.values.get(index);
		}
		return value;
	}
	
	/**
	 * map清除的时候键、值的list清除
	 */
	public void clear(){
		this.keys.clear();
		this.values.clear();
	}
	
	public static void main(String[] args) {
		HashMapL<String,String> test = new HashMapL<String,String>();
		test.put("111", "2222");
		System.out.println(test.get("111"));
	}

}
