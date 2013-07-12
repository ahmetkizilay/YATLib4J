package com.ahmetkizilay.yatlib4j.datatypes;

import java.math.BigInteger;

/***
 * If there are no contributors for a status, then there will be an empty or<p>
 * "contributors" : {}. This field will only be populated if the user has<p>
 * contributors enabled on his or her account — this is a beta feature that<p>
 * is not yet generally available to all.<p>
 * 
 * @author ahmetkizilay
 *
 */
public class Contributor {
	private BigInteger id;
	private String idStr;
	private String screenName;
	
	
	public BigInteger getId() {
		return this.id;
	}
	
	/***
	 * The integer representation of the ID of the user who contributed to this Tweet.<p>
	 * 
	 * @param id
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public String getIdStr() {
		return this.idStr;
	}
	
	/***
	 * The string representation of the ID of the user who contributed to this Tweet.<p>
	 * @param idStr
	 */
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
	/***
	 * The screen name of the user who contributed to this Tweet.<p>
	 * @param screenName
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
}
