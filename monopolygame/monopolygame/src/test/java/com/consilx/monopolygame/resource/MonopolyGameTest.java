package com.consilx.monopolygame.resource;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.consilx.monopolygame.MonopolygameApplicationTest;
import com.consilx.monopolygame.pojo.Player;
import com.consilx.monopolygame.service.IBanker;
import com.consilx.monopolygame.service.IBoard;
import com.consilx.monopolygame.service.IPlayerService;
/**
 * This class is used to test all the operations of Player.Play game,Get player
 * and property details.
 * @author jatin
 *
 */
public class MonopolyGameTest extends MonopolygameApplicationTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	IPlayerService playerService;

	@Mock
	IBanker banker;

	@Mock
	IBoard board;
	/**
	 * This method is used to play game and get Player and Property Details
	 * @throws Exception
	 */
	@Test
	public void playGameCheckResults() throws Exception {
		Player playerTemp = null;
		int diceNo = 0;
		Mockito.when(board.moveOn(playerTemp, diceNo)).thenReturn(playerTemp);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player A").param("diceNo", "3").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andReturn();
		RequestBuilder requestBuilder111 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player B").param("diceNo", "3").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder111).andReturn();
		RequestBuilder requestBuilder3 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player C").param("diceNo", "2").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder3).andReturn();

		RequestBuilder requestBuilder19 = MockMvcRequestBuilders.get("/api/monopoly/getAllPlayerDetails")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder19).andReturn();
		RequestBuilder requestBuilder4 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player A").param("diceNo", "3").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder4).andReturn();
		RequestBuilder requestBuilder5 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player B").param("diceNo", "4").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder5).andReturn();
		RequestBuilder requestBuilder6 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player C").param("diceNo", "2").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder6).andReturn();
		RequestBuilder requestBuilder29 = MockMvcRequestBuilders.get("/api/monopoly/getAllPlayerDetails")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder29).andReturn();
		RequestBuilder requestBuilder7 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player A").param("diceNo", "9").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder7).andReturn();
		RequestBuilder requestBuilder8 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")

				.param("playerName", "Player B").param("diceNo", "6").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder8).andReturn();
		RequestBuilder requestBuilder9 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player C").param("diceNo", "3").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder9).andReturn();
		RequestBuilder requestBuilder39 = MockMvcRequestBuilders.get("/api/monopoly/getAllPlayerDetails")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder39).andReturn();
		RequestBuilder requestBuilder10 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player A").param("diceNo", "4").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder10).andReturn();
		RequestBuilder requestBuilder11 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player B").param("diceNo", "1").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder11).andReturn();
		RequestBuilder requestBuilder12 = MockMvcRequestBuilders.get("/api/monopoly/moveOn")
				.param("playerName", "Player C").param("diceNo", "8").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder12).andReturn();
		RequestBuilder requestBuilder15 = MockMvcRequestBuilders.get("/api/monopoly/players")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result4 = mockMvc.perform(requestBuilder15).andReturn();
		System.out.println(result4.getResponse().getContentAsString());
		RequestBuilder requestBuilder16 = MockMvcRequestBuilders.get("/api/monopoly/properties")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result5 = mockMvc.perform(requestBuilder16).andReturn();
		System.out.println(result5.getResponse().getContentAsString());
	}
}
