package com.consilx.monopolygame.pojo;
/**
 * This class is used to have all the information related to property like(color,name,owner,rent level)
 */

import java.util.List;

public class Tile {
	private int price;
	private String name;
	private String colour;
	private int currentRentLevel = 1;
	private List<Integer> perLevelRentList;
	private Tile next;
	private Player ownerOfProperty;

	public Tile getNext() {
		return next;
	}

	public void setNext(Tile next) {
		this.next = next;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getCurrentRentLevel() {
		return currentRentLevel;
	}

	public void setCurrentRentLevel(int currentRentLevel) {
		this.currentRentLevel = currentRentLevel;
	}

	public List<Integer> getPerLevelRentList() {
		return perLevelRentList;
	}

	public void setPerLevelRentList(List<Integer> perLevelRentList) {
		this.perLevelRentList = perLevelRentList;
	}

	/**
	 * Over riding hashcode and equals method as Property name would be unique.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Player getOwnerOfProperty() {
		return ownerOfProperty;
	}

	public void setOwnerOfProperty(Player ownerOfProperty) {
		this.ownerOfProperty = ownerOfProperty;
	}
}
