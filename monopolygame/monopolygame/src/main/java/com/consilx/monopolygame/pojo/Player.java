package com.consilx.monopolygame.pojo;

import java.util.List;

/**
 * Player class to have all the information of Player(Current
 * position,Properties)
 * 
 * @author jatin
 *
 */
public class Player {
	/**
	 * 
	 */
	private String name;

	private Tile currentPosition;

	private int money;

	private List<Tile> propertyList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tile getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Tile currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Tile> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Tile> propertyList) {
		this.propertyList = propertyList;
	}

	/**
	 * Overriding equals and hash code(Player name is unique.)
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
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
