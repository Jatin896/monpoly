package com.consilx.monopolygame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.consilx.monopolygame.helper.BoardData;
import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.pojo.Tile;

/**
 * This class is used to do all transactions of player money.
 * 
 * @author jatin
 *
 */
@Service
public class Banker implements IBanker {
	/**
	 * This method is used to add owner to the property and add property to owner's
	 * account.
	 */
	public Player addOwnAndProprList(Tile property, Player player) {
		if (null != property && null != player) {
			property.setOwnerOfProperty(player);
			if (null != player.getPropertyList() && !player.getPropertyList().isEmpty()) {
				player.getPropertyList().add(property);
			} else {
				List<Tile> propertyList = new ArrayList<Tile>();
				propertyList.add(property);
				player.setPropertyList(propertyList);
			}
		}
		return player;
	}
	/**
	 * This method is used to add money to player's account
	 */
	public Player addMoneyToPlayerAccount(Player propertyOwner, int addMoney) {
		propertyOwner.setMoney(propertyOwner.getMoney() + addMoney);
		return propertyOwner;
	}

	/**
	 * This method is used to deduct money from Player account.
	 */
	public Player deductMoneyFromPlayerAccount(Player rentPayer, int deductmoney) {
		rentPayer.setMoney(rentPayer.getMoney() - deductmoney);
		return rentPayer;
	}
	/**
	 * This method is used to get owner of the property.
	 */
	public Player getOwnerOfTheProperty(Tile property) {
		return property.getOwnerOfProperty();
	}
	/**
	 * This method is used to add money to the bank.
	 */
	public void addMoneyToBank(int money) {
		BoardData.toltalMoneyOfbank = BoardData.toltalMoneyOfbank + money;
	}
}
