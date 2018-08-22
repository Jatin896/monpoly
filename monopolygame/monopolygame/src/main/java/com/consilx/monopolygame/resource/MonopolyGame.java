package com.consilx.monopolygame.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.pojo.PlayerDetail;
import com.consilx.monopolygame.pojo.PropertyDetail;
import com.consilx.monopolygame.service.IBoard;
import com.consilx.monopolygame.service.IPlayerService;
import com.consilx.monopolygame.service.IPropertyService;

/**
 * This class will act as a resource for game in which players will play the
 * game and can also get details of player and property details.
 * 
 * @author jatin
 *
 */
@RestController
@RequestMapping("/api/monopoly")
public class MonopolyGame {

	@Autowired
	private IBoard board;
	@Autowired
	private IPlayerService playerService;

	@Autowired
	private IPropertyService propertyService;

	/**
	 * This method is used to move on in the game.User will be entering the Player
	 * Name and Dice No
	 * 
	 * @param playerName
	 * @param diceNo
	 * @return
	 */
	@GetMapping("/moveOn")
	public ResponseEntity<PlayerDetail> moveOn(@RequestParam(value = "playerName", required = true) String playerName,
			@RequestParam(value = "diceNo", required = true) String diceNo) {
		Player player = new Player();
		player.setName(playerName);
		player = board.moveOn(player, Integer.parseInt(diceNo));
		// Creating Player Detail obj as we do not want to pass all the information in
		PlayerDetail playerDetail = new PlayerDetail();
		playerDetail.setName(player.getName());
		playerDetail.setBalance(player.getMoney());
		return new ResponseEntity<PlayerDetail>(playerDetail, HttpStatus.OK);
	}

	/**
	 * This method is used to get all the details of Players.
	 * 
	 * @return
	 */
	@GetMapping("/players")
	public ResponseEntity<List<PlayerDetail>> getAllPlayerDetails() {
		return new ResponseEntity<List<PlayerDetail>>(playerService.getAllPlayerDetails(), HttpStatus.OK);
	}

	/**
	 * This method is used to get all the property details on Board like
	 * owner,current level and color.
	 * 
	 * @return
	 */
	@GetMapping("/properties")
	public ResponseEntity<List<PropertyDetail>> getAllPropertyDetails() {
		return new ResponseEntity<List<PropertyDetail>>(propertyService.getAllPropertyDetails(), HttpStatus.OK);
	}

}
