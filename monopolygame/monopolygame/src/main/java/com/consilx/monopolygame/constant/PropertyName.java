package com.consilx.monopolygame.constant;
/**
 * Property Name Enum
 * @author jatin
 *
 */
public enum PropertyName {
	GO("Go"),COACHIN("Cochin"), OOTY("Ooty"), BOMBAY("Bombay"), AHMEDABAD("Ahmedabad"), CHENNAI("Chennai"), BANGALORE(
			"Bangalore"), DELHI("Delhi"), DARJEELING("Darjeeling"),SPECIAL_TILE("Special Tile");
	private String name;

	private PropertyName(String name) {
		this.name = name;
	}

	public String getValue() {
		return name;
	}
}
