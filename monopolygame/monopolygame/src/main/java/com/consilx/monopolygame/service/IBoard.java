package com.consilx.monopolygame.service;
/**
 * Interface for the board to add or remove player.
 */
import java.util.Map;

import com.consilx.monopolygame.pojo.Player;

public interface IBoard {
	public Player moveOn(Player playerTemp, int diceNo);
	public Map<String, Player> removePlayer(Player removePlayer);

}
