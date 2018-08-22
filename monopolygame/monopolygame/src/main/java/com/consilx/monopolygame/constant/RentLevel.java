package com.consilx.monopolygame.constant;
/**
 * Rent level Enum
 * @author jatin
 *
 */
public enum RentLevel {
	MAX_LEVEL(5),MIN_LEVEL(1);
	public int rentLevel;
	RentLevel(int rentLevel){
		this.rentLevel = rentLevel;
	}
	public int getValue() {
		return rentLevel;
	}

}
