package com.ahmetkizilay.yatlib4j.datatypes;

public class BoundingBox {
	private float[][][] coordinates;
	private String type;
	
	public float[][][] getCoordinates() {
		return this.coordinates;
	}
	
	/***
	 * A series of longitude and latitude points, defining a box which will contain the<p>
	 * Place entity this bounding box is related to. Each point is an array in the form of<p>
	 * [longitude, latitude]. Points are grouped into an array per bounding box. Bounding box<p>
	 * arrays are wrapped in one additional array to be compatible with the polygon notation.<p>
	 * 
	 * @param coordinates
	 */
	public void setCoordinates(float[][][] coordinates) {
		this.coordinates = coordinates;
	}
	
	public String getType() {
		return this.type;
	}
	
	/***
	 * The type of data encoded in the coordinates property. This will be "Polygon" for bounding boxes.<p>
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
