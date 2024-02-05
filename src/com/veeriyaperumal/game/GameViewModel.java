package com.veeriyaperumal.game;

import java.util.HashMap;

import com.veeriyaperumal.model.Player;
import com.veeriyaperumal.repository.Repository;

public class GameViewModel {

	HashMap<Integer, Integer> snakes;
	HashMap<Integer, Integer> ladders;

	private GameView gameView;

	public GameViewModel(GameView gameView) {
		this.gameView = gameView;
	}

	public Player[] getPlayers() {
		return Repository.getInstance().getBoard().getPlayers();
	}

	public int getTargetPositionNumber() {
		return Repository.getInstance().getTargetPositionNumber();
	}

	public int isSnake(int positionNumber) {
		if (snakes == null) {
			snakes = Repository.getInstance().getBoard().getSnakes();
		}
		return snakes.getOrDefault(positionNumber, -1);
	}

	public int isLadder(int positionNumber) {
		if (ladders == null) {
			ladders = Repository.getInstance().getBoard().getLadders();
		}
		return ladders.getOrDefault(positionNumber, -1);
	}

}
