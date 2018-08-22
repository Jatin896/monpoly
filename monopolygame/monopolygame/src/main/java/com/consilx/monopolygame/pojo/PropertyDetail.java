package com.consilx.monopolygame.pojo;

/**
 * This class is used to have property details which we want to send it as
 * response.
 * 
 * @author jatin
 *
 */
public class PropertyDetail {
	private String owner;
	private String propertyName;
	private String currentRentLevel;
	private String colour;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getCurrentRentLevel() {
		return currentRentLevel;
	}

	public void setCurrentRentLevel(String currentRentLevel) {
		this.currentRentLevel = currentRentLevel;
	}

}
