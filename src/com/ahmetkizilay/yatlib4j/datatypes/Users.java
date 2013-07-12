package com.ahmetkizilay.yatlib4j.datatypes;

import java.math.BigInteger;

import net.minidev.json.JSONObject;

public class Users {
	private boolean contributorsEnabled;
	private String createdAt;
	private boolean defaultProfile;
	private boolean defaultProfileImage;
	private String description;
	private Entities entities;
	private int favoritesCount;
	private Boolean followRequestSent;
	private Boolean following;
	private int followersCount;
	private int friendsCount;
	private boolean geoEnabled;
	private BigInteger id;
	private String idStr;
	private boolean isTranslator;
	private String lang;
	private int listedCount;
	private String location;
	private String name;
	private Boolean notifications;
	private String profileBackgroundColor;
	private String profileBackgroundImageUrl;
	private String profileBackgroundImageUrlHttps;
	private boolean profileBackgroundTile;
	private String profileBannerUrl;
	private String profileImageUrl;
	private String profileImageUrlHttps;
	private String profileLinkColor;
	private String profileSidebarBorderColor;
	private String profileSidebarFillColor;
	private String profileTextColor;
	private boolean profileUseBackgroundImage;
	private boolean mProtected;
	private String screenName;
	
	private String rawJSONData;
	public String getRawJSONData() {
		return this.rawJSONData;
	}
	
	public String getIdStr() {
		return this.idStr;
	}
	
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	
	public boolean isProtected() {
		return this.mProtected;
	}
	
	public void setProtected(boolean bProtected) {
		this.mProtected = bProtected;
	}
	
	public void setRawJSONData(String rawJSONString) {
		this.rawJSONData = rawJSONString;
	}
	
	public String getScreenName() {
		return this.screenName;		
	}
	
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public static Users fromJSONString(String jsonString) {
		Users newUser = new Users();
		newUser.rawJSONData = jsonString;
		
		return newUser;
	}
	
	public static Users fromJSONObject(JSONObject jsonUser) {
		return fromJSONObject(jsonUser, false);
	}
	
	public static Users fromJSONObject(JSONObject jsonUser, boolean includeData) {
		Users newUser = new Users();
		newUser.idStr = (String) jsonUser.get("id_str");
		newUser.mProtected = (boolean) jsonUser.get("protected");
		newUser.screenName = (String) jsonUser.get("screen_name");
		if(includeData) {
			newUser.rawJSONData = jsonUser.toJSONString();
		}
		return newUser;
	}
	
	
	
}
