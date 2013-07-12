package com.ahmetkizilay.yatlib4j.datatypes;

public class Coordinates {
	private float[] coordinates;
	private String type;
	
	public float[] getCoordinates() {
		return this.coordinates;
	}
	
	/***
	 * The longitude and latitude of the Tweet's location, as an collection in the form of [longitude, latitude].<p>
	 * @param coordinates
	 */
	public void setCoordinates(float[] coordinates) {
		this.coordinates = coordinates;
	}
	
	public String getType() {
		return this.type;
	}
	
	/***
	 * The type of data encoded in the coordinates property. This will be "Point" for Tweet coordinates fields.<p>
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}
