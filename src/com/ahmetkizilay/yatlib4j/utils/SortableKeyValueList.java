package com.ahmetkizilay.yatlib4j.utils;

import java.util.ArrayList;
import java.util.Collections;

public class SortableKeyValueList {
	private ArrayList<SortableKeyValuePair> kvList = new ArrayList<SortableKeyValuePair>();
	
	public SortableKeyValueList() {		
	}
	
	public void add(String key, String value) {
		SortableKeyValuePair newPair = new SortableKeyValuePair(key, value);
		int index = kvList.indexOf(newPair);
		if(index == -1) {
			kvList.add(newPair);
		}
		else {
			kvList.set(index, newPair);
		}
	}

	public ArrayList<SortableKeyValuePair> getList() {
		Collections.sort(kvList);
		return this.kvList;
	}
}
