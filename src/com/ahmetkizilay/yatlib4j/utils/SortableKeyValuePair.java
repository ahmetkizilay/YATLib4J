package com.ahmetkizilay.yatlib4j.utils;

public class SortableKeyValuePair implements Comparable<SortableKeyValuePair>{
	public String key;
	public String value;
	
	public SortableKeyValuePair(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(SortableKeyValuePair o) {
		return this.key.compareTo(o.key);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SortableKeyValuePair) {
			SortableKeyValuePair that = (SortableKeyValuePair) obj;
			return this.key.equals(that.key);
		}
		else {
			return false;
		}
	}
	
	
	
}
