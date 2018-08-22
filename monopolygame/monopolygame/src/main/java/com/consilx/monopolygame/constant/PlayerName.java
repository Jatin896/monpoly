package com.consilx.monopolygame.constant;
/**
 * Player Name Enum.
 * @author jatin
 *
 */
public enum PlayerName {
	PLAYER_A("Player A"),PLAYER_B("Player B"),PLAYER_C("Player C");
	private String playerName;

	private PlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getValue() {
		return playerName;
	}
}
