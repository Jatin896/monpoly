package com.consilx.monopolygame.pojo;

/**
 * This class is used to have player details which we want to send it as
 * response.
 * @author jatin
 *
 */
public class PlayerDetail {
	private String name;
	private int balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
