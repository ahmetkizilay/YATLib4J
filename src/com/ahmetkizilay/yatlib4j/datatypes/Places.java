package com.ahmetkizilay.yatlib4j.datatypes;

import java.util.Hashtable;

public class Places {
	private Hashtable<String, String> attributes;
	private BoundingBox boundingBox;
	private String country;
	private String countryCode;
	private String fullName;
	private String id;
	private String name;
	private String placeType;
	private String url;

	public Hashtable<String, String> getAttributes() {
		return attributes;
	}
	
	/***
	 * Contains a hash of variant information about the place. See About Geo Place Attributes.<p>
	 * 
	 * @param attributes
	 */
	public void setAttributes(Hashtable<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
	
	/***
	 * A bounding box of coordinates which encloses this place.<p>
	 * 
	 * @param boundingBox
	 */
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}
	
	public String getCountry() {
		return country;
	}
	
	/***
	 * Name of the country containing this place.<p>
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	/***
	 * Shortened country code representing the country containing this place.<p>
	 * 
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	/***
	 * Full human-readable representation of the place's name.<p>
	 * 
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getId() {
		return id;
	}
	
	/***
	 * ID representing this place. Note that this is represented as a string, not an integer.<p>
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	/***
	 * Short human-readable representation of the place's name.<p>
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPlaceType() {
		return placeType;
	}
	
	/***
	 * The type of location represented by this place.<p>
	 * 
	 * @param placeType
	 */
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	
	public String getUrl() {
		return url;
	}
	
	/***
	 * URL representing the location of additional place metadata for this place.<p>
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
