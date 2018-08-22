package com.consilx.monopolygame.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consilx.monopolygame.constant.PropertyName;
import com.consilx.monopolygame.exception.FunctionalException;
import com.consilx.monopolygame.helper.BoardData;
import com.consilx.monopolygame.helper.RuleOfTheGame;
import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.pojo.Tile;

/**
 * This class is used as a Game board
 * 
 * @author jatin
 *
 */
@Service
public class Board implements IBoard {
	@Autowired
	private RuleOfTheGame ruleOfTheGame;
	@Autowired
	private IBanker banker;

	/**
	 * This method is used to capture Player movements after throwing dice.If a
	 * Player is bankrupt or on Go button validation(exception) has been thrown.
	 */
	public Player moveOn(Player playerTemp, int diceNo) {
		// TODO Auto-generated method stub
		Player player = null;
		if (RuleOfTheGame.continueGameOrNot(BoardData.totalPlayerMap)) {
			if (BoardData.totalPlayerMap.containsKey(playerTemp.getName())) {
				player = BoardData.totalPlayerMap.get(playerTemp.getName());
				movePlayerOnTheBoard(player, diceNo);
				if (null != player.getCurrentPosition()) {
					Tile curProperty = player.getCurrentPosition();
					if (!PropertyName.GO.getValue().equalsIgnoreCase(curProperty.getName())) {
						if (RuleOfTheGame.isPlayerOnSpecialTile(player)) {
							RuleOfTheGame.increaseOrDecreaseLevelOfPlayers(player, BoardData.totalPlayerMap);
						} else {
							int amount = 0;
							if (null != curProperty.getOwnerOfProperty()) {
								if (!playerTemp.getName()
										.equalsIgnoreCase(curProperty.getOwnerOfProperty().getName())) {
									amount = curProperty.getPerLevelRentList()
											.get(curProperty.getCurrentRentLevel() - 1);
								} else {
									throw new FunctionalException(
											"Player lands on same property which has been owned by him");
								}
							} else {
								amount = curProperty.getPrice();
							}
							if (!ruleOfTheGame.isPlayerBankRupt(player, amount)) {
								if (null != curProperty.getOwnerOfProperty()) {
									int rent = curProperty.getPerLevelRentList()
											.get(curProperty.getCurrentRentLevel() - 1);
									banker.addMoneyToPlayerAccount(curProperty.getOwnerOfProperty(), rent);
									banker.deductMoneyFromPlayerAccount(player, rent);
								} else {
									banker.addMoneyToBank(curProperty.getPrice());
									banker.deductMoneyFromPlayerAccount(player, curProperty.getPrice());
									player.getCurrentPosition().setOwnerOfProperty(player);
									banker.addOwnAndProprList(curProperty, player);
								}
							} else {
								removePlayer(player);
							}
						}
					} else {
						// System.out.println("Player is on Go");
						throw new FunctionalException("Player is on Go button");
					}
				}
			} else {
				throw new FunctionalException("Only Winner of the game is left");
			}
		}
		return player;
	}

	/**
	 * This method is used to remove the player from the game if player is bankrupt.
	 */
	public Map<String, Player> removePlayer(Player removePlayer) {
		if (BoardData.totalPlayerMap.containsKey(removePlayer.getName())) {
			BoardData.totalPlayerMap.remove(removePlayer.getName());
		}
		return BoardData.totalPlayerMap;
	}

	/**
	 * This method is used for the movement of player on the board.Placing player on
	 * his new position.
	 * 
	 * @param player
	 * @param diceNo
	 * @return
	 */
	public static Player movePlayerOnTheBoard(Player player, int diceNo) {
		int i = 0;
		Tile temp = player.getCurrentPosition();
		while (i != diceNo) {
			temp = temp.getNext();
			if (PropertyName.GO.getValue().equalsIgnoreCase(temp.getName())) {
				player.setMoney(player.getMoney() + 200);
			}
			i++;
		}
		player.setCurrentPosition(temp);
		return player;
	}

}
