package com.consilx.monopolygame.helper;

import java.util.Map;

import org.springframework.stereotype.Service;
import com.consilx.monopolygame.constant.PropertyName;
import com.consilx.monopolygame.constant.RentLevel;
import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.pojo.Tile;

/**
 * This class is used to have rules of the game.If any new rule we can enhance
 * here.
 * 
 * @author jatin
 *
 */
@Service
public class RuleOfTheGame {
	int totalValueOfProperty = 0;

	/**
	 * This method is used to check whether player is on special tile or not.
	 * 
	 * @param player
	 * @return
	 */
	public static boolean isPlayerOnSpecialTile(Player player) {
		if (null != player && null != player.getCurrentPosition()
				&& PropertyName.SPECIAL_TILE.getValue().equalsIgnoreCase(player.getCurrentPosition().getName())) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to increase or decrease rent level of properties.
	 * 
	 * @param player
	 * @param totalPlayerMap
	 */
	public static void increaseOrDecreaseLevelOfPlayers(Player player, Map<String, Player> totalPlayerMap) {
		if (!totalPlayerMap.isEmpty()) {
			totalPlayerMap.forEach((playerName, playerObj) -> {
				if (playerName.equalsIgnoreCase(player.getName())) {
					if (null != playerObj.getPropertyList() && !playerObj.getPropertyList().isEmpty()) {
						player.getPropertyList().forEach((tileObj) -> {
							if (tileObj.getCurrentRentLevel() < RentLevel.MAX_LEVEL.getValue())
								tileObj.setCurrentRentLevel(tileObj.getCurrentRentLevel() + 1);
						});
					}
				} else {
					if (null != playerObj.getPropertyList() && !playerObj.getPropertyList().isEmpty()) {
						playerObj.getPropertyList().forEach((tileObj) -> {
							if (tileObj.getCurrentRentLevel() > RentLevel.MIN_LEVEL.getValue())
								tileObj.setCurrentRentLevel(tileObj.getCurrentRentLevel() - 1);
						});
					}
				}
			});
		}
	}

	/**
	 * This method is used to check whether player is bank rupt or not.
	 * 
	 * @param player
	 * @param rentBuyMoney
	 * @return
	 */
	public boolean isPlayerBankRupt(Player player, int rentBuyMoney) {
		totalValueOfProperty = totalValueOfProperty + player.getMoney();
		if (null != player.getPropertyList() && !player.getPropertyList().isEmpty()) {
			player.getPropertyList().forEach((property) -> {
				totalValueOfProperty = totalValueOfProperty + property.getPrice();
			});
		}
		if (totalValueOfProperty < rentBuyMoney) {
			totalValueOfProperty = 0;
			return true;
		}
		totalValueOfProperty = 0;
		return false;
	}

	/**
	 * This method is used to increase rent level
	 * 
	 * @param property
	 */
	public static void increaseRentLevel(Tile property) {
		if (property.getCurrentRentLevel() < RentLevel.MAX_LEVEL.getValue()) {
			property.setCurrentRentLevel(property.getCurrentRentLevel() + 1);
		}
	}

	/**
	 * This method is used to check whether to continue game or not.How many players
	 * are left?
	 * 
	 * @param totalPlayerMap
	 * @return
	 */
	public static boolean continueGameOrNot(Map<String, Player> totalPlayerMap) {
		if (totalPlayerMap.size() > 1) {
			return true;
		}
		return false;
	}
}
