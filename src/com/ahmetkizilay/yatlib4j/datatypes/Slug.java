package com.ahmetkizilay.yatlib4j.datatypes;

import net.minidev.json.JSONObject;

public class Slug {
	private String name;
	private String slug;
	private int size;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public static Slug fromJSONObject(JSONObject jsonObject) {
		Slug instance = new Slug();
		instance.setName((String) jsonObject.get("name"));
		instance.setSlug((String) jsonObject.get("slug"));
		instance.setSize((int) jsonObject.get("size"));
		
		return instance;
	}
	
	
}
