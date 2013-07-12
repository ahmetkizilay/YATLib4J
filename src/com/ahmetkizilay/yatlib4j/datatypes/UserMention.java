package com.ahmetkizilay.yatlib4j.datatypes;

import java.math.BigInteger;

public class UserMention {
	private BigInteger id;
	private String idStr;
	private int[] indices;
	private String name;
	private String screenName;

	public BigInteger getId() {
		return id;
	}
	
	/***
	 * ID of the mentioned user, as an integer.<p>
	 * 
	 * @param id
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getIdStr() {
		return idStr;
	}
	
	/***
	 * If of the mentioned user, as a string.<p>
	 * 
	 * @param idStr
	 */
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	
	public int[] getIndices() {
		return indices;
	}
	
	/***
	 * An array of integers representing the offsets within the Tweet<p>
	 * text where the user reference begins and ends. The first integer<p>
	 * represents the location of the '@' character of the user mention.<p>
	 * The second integer represents the location of the first non-screenname<p>
	 * character following the user mention.<p>
	 * 
	 * @param indices
	 */
	public void setIndices(int[] indices) {
		this.indices = indices;
	}
	
	public String getName() {
		return name;
	}
	
	/***
	 * Display name of the referenced user.<p>
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	/***
	 * Screen name of the referenced user.<p>
	 * 
	 * @param screenName
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}
