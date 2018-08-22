package com.consilx.monopolygame.service;
/**
 * Inteface to to do all transactions of player money.
 */
import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.pojo.Tile;

public interface IBanker {
	public Player addOwnAndProprList(Tile property, Player player);
	public Player addMoneyToPlayerAccount(Player propertyOwner, int addMoney);
	public Player deductMoneyFromPlayerAccount(Player rentPayer, int deductmoney);
	public Player getOwnerOfTheProperty(Tile property);
	public void addMoneyToBank(int money);
}
