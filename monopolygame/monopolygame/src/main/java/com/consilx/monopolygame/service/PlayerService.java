package com.consilx.monopolygame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.consilx.monopolygame.helper.BoardData;
import com.consilx.monopolygame.pojo.PlayerDetail;

/**
 * This class is used to get information related to player.In future can be used
 * to manipulate information of player.
 * 
 * @author jatin
 *
 */
@Service
public class PlayerService implements IPlayerService {
	/**
	 * This method is used to get all the details of player.As of now showing only
	 * name and money of player.It can be enhanced later on(e.g Property List of
	 * Player).
	 */
	@Override
	public List<PlayerDetail> getAllPlayerDetails() {
		// TODO Auto-generated method stub
		List<PlayerDetail> playerList = new ArrayList<PlayerDetail>();
		BoardData.totalPlayerMap.forEach((playerName, playerObj) -> {
			PlayerDetail playerDetail = new PlayerDetail();
			playerDetail.setName(playerObj.getName());
			playerDetail.setBalance(playerObj.getMoney());
			playerList.add(playerDetail);
		});
		return playerList;
	}
}
