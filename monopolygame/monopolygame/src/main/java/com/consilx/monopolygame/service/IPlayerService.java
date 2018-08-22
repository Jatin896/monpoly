package com.consilx.monopolygame.service;

import java.util.List;

import com.consilx.monopolygame.pojo.PlayerDetail;
/**
 * This interface is used to get information related to player.In future can be used
 * to manipulate information of player.
 * @author jatin
 *
 */
public interface IPlayerService {

	public List<PlayerDetail> getAllPlayerDetails();

}
