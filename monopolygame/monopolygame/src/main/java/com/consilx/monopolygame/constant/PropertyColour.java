package com.consilx.monopolygame.constant;
/**
 * Property Color Enum.
 * @author jatin
 *
 */
public enum PropertyColour {
	GREEN("Green"),RED("Red"),BLUE("Blue"),YELLOW("Yellow");
	private String colour;

	private PropertyColour(String colour) {
		this.colour = colour;
	}

	public String getValue() {
		return colour;
	}
}
