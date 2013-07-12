package com.ahmetkizilay.yatlib4j.datatypes;

import net.minidev.json.JSONObject;

public class Language {
	private String name;
	private String code;
	private String status;
	
	private String jsonString;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getJSONString() {
		return this.jsonString;
	}
	
	public void setJSONString(String jsonString) {
		this.jsonString = jsonString;
	}
	
	public static Language fromJSON(JSONObject jsonObject) {
		return fromJSON(jsonObject, false);
	}
	
	public static Language fromJSON(JSONObject jsonObject, boolean keepData) {
		Language language = new Language();
		language.setCode((String) jsonObject.get("code"));
		language.setName((String) jsonObject.get("name"));
		language.setStatus((String) jsonObject.get("status"));
		if(keepData) {
			language.setJSONString(jsonObject.toJSONString());			
		}
		
		return language;
	}
}
