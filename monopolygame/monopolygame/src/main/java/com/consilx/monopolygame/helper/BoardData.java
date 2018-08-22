package com.consilx.monopolygame.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.consilx.monopolygame.constant.PlayerName;
import com.consilx.monopolygame.constant.PropertyColour;
import com.consilx.monopolygame.constant.PropertyName;
import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.pojo.Tile;

/**
 * This method is used to load board data.
 * 
 * @author jatin
 *
 */
@Service
public class BoardData {
	public static CircularLinkedList<Tile> boardCircularList = null;
	public static Map<String, Player> totalPlayerMap = null;
	public static int toltalMoneyOfbank = 500000;
	/**
	 * static block which will be called while starting of application.Loading
	 * Player and board Data.
	 */
	static {
		loadBoardData();
	}
	/**
	 * Loading board data.
	 */
	private static void loadBoardData() {
		boardCircularList = new CircularLinkedList<Tile>();
		Tile head = new Tile();
		head.setName(PropertyName.GO.getValue());
		boardCircularList.append(head);
		Tile firstTile = new Tile();
		firstTile.setName(PropertyName.COACHIN.getValue());
		firstTile.setColour(PropertyColour.GREEN.getValue());
		firstTile.setPrice(120);
		List<Integer> perLevelRentListOfCoachin = new ArrayList<Integer>(6);
		perLevelRentListOfCoachin.add(0, 100);
		perLevelRentListOfCoachin.add(1, 160);
		perLevelRentListOfCoachin.add(2, 260);
		perLevelRentListOfCoachin.add(3, 440);
		perLevelRentListOfCoachin.add(4, 860);
		firstTile.setPerLevelRentList(perLevelRentListOfCoachin);
		boardCircularList.append(firstTile);
		Tile secondTile = new Tile();
		secondTile.setName(PropertyName.OOTY.getValue());
		secondTile.setColour(PropertyColour.GREEN.getValue());
		secondTile.setPrice(400);
		List<Integer> perLevelRentListOfOOty = new ArrayList<Integer>();
		perLevelRentListOfOOty.add(0, 300);
		perLevelRentListOfOOty.add(1, 400);
		perLevelRentListOfOOty.add(2, 560);
		perLevelRentListOfOOty.add(3, 810);
		perLevelRentListOfOOty.add(4, 1600);
		secondTile.setPerLevelRentList(perLevelRentListOfOOty);
		boardCircularList.append(secondTile);
		Tile thirdTile = new Tile();
		thirdTile.setName(PropertyName.BOMBAY.getValue());
		thirdTile.setColour(PropertyColour.RED.getValue());
		thirdTile.setPrice(500);
		List<Integer> perLevelRentListOfBombay = new ArrayList<Integer>();
		perLevelRentListOfBombay.add(0, 400);
		perLevelRentListOfBombay.add(1, 520);
		perLevelRentListOfBombay.add(2, 680);
		perLevelRentListOfBombay.add(3, 900);
		perLevelRentListOfBombay.add(4, 1800);
		thirdTile.setPerLevelRentList(perLevelRentListOfBombay);
		boardCircularList.append(thirdTile);
		Tile fourthTile = new Tile();
		fourthTile.setName(PropertyName.AHMEDABAD.getValue());
		fourthTile.setColour(PropertyColour.RED.getValue());
		fourthTile.setPrice(300);
		List<Integer> perLevelRentListOfAhmedabad = new ArrayList<Integer>();
		perLevelRentListOfAhmedabad.add(0, 200);
		perLevelRentListOfAhmedabad.add(1, 350);
		perLevelRentListOfAhmedabad.add(2, 480);
		perLevelRentListOfAhmedabad.add(3, 800);
		perLevelRentListOfAhmedabad.add(4, 1200);
		fourthTile.setPerLevelRentList(perLevelRentListOfAhmedabad);
		boardCircularList.append(fourthTile);
		Tile fifthTile = new Tile();
		fifthTile.setName(PropertyName.SPECIAL_TILE.getValue());
		boardCircularList.append(fifthTile);
		Tile sixTile = new Tile();
		sixTile.setName(PropertyName.CHENNAI.getValue());
		sixTile.setColour(PropertyColour.BLUE.getValue());
		sixTile.setPrice(700);
		List<Integer> perLevelRentListOfChennai = new ArrayList<Integer>();
		perLevelRentListOfChennai.add(0, 600);
		perLevelRentListOfChennai.add(1, 900);
		perLevelRentListOfChennai.add(2, 1250);
		perLevelRentListOfChennai.add(3, 1500);
		perLevelRentListOfChennai.add(4, 1900);
		sixTile.setPerLevelRentList(perLevelRentListOfChennai);
		boardCircularList.append(sixTile);
		Tile seventhTile = new Tile();
		seventhTile.setName(PropertyName.BANGALORE.getValue());
		seventhTile.setColour(PropertyColour.BLUE.getValue());
		seventhTile.setPrice(450);
		List<Integer> perLevelRentListOfBangalore = new ArrayList<Integer>();
		perLevelRentListOfBangalore.add(0, 300);
		perLevelRentListOfBangalore.add(1, 400);
		perLevelRentListOfBangalore.add(2, 560);
		perLevelRentListOfBangalore.add(3, 810);
		perLevelRentListOfBangalore.add(4, 1600);
		seventhTile.setPerLevelRentList(perLevelRentListOfBangalore);
		boardCircularList.append(seventhTile);
		Tile eighthTile = new Tile();
		eighthTile.setName(PropertyName.DELHI.getValue());
		eighthTile.setColour(PropertyColour.YELLOW.getValue());
		eighthTile.setPrice(500);
		List<Integer> perLevelRentListOfDelhi = new ArrayList<Integer>();
		perLevelRentListOfDelhi.add(0, 400);
		perLevelRentListOfDelhi.add(1, 520);
		perLevelRentListOfDelhi.add(2, 680);
		perLevelRentListOfDelhi.add(3, 900);
		perLevelRentListOfDelhi.add(4, 1800);
		eighthTile.setPerLevelRentList(perLevelRentListOfDelhi);
		boardCircularList.append(eighthTile);
		Tile ninthTile = new Tile();
		ninthTile.setName(PropertyName.DARJEELING.getValue());
		ninthTile.setColour(PropertyColour.YELLOW.getValue());
		ninthTile.setPrice(600);
		List<Integer> perLevelRentListOfDarjeeling = new ArrayList<Integer>();
		perLevelRentListOfDarjeeling.add(0, 400);
		perLevelRentListOfDarjeeling.add(1, 700);
		perLevelRentListOfDarjeeling.add(2, 1000);
		perLevelRentListOfDarjeeling.add(3, 1150);
		perLevelRentListOfDarjeeling.add(4, 1400);
		ninthTile.setPerLevelRentList(perLevelRentListOfDarjeeling);
		boardCircularList.append(ninthTile);
		// Initialize Players
		initializePlayer(head);

	}

	/**
	 * Loading Player Data.
	 * @param head
	 */
	private static void initializePlayer(Tile head) {
		// TODO Auto-generated method stub
		totalPlayerMap = new HashMap<String, Player>();
		Player playerA = new Player();
		playerA.setName(PlayerName.PLAYER_A.getValue());
		playerA.setMoney(2000);
		playerA.setCurrentPosition(head);
		totalPlayerMap.put(PlayerName.PLAYER_A.getValue(), playerA);
		Player playerB = new Player();
		playerB.setName(PlayerName.PLAYER_B.getValue());
		playerB.setMoney(2000);
		playerB.setCurrentPosition(head);
		totalPlayerMap.put(PlayerName.PLAYER_B.getValue(), playerB);
		Player playerC = new Player();
		playerC.setName(PlayerName.PLAYER_C.getValue());
		playerC.setMoney(2000);
		playerC.setCurrentPosition(head);
		totalPlayerMap.put(PlayerName.PLAYER_C.getValue(), playerC);
	}

}