package com.veeriyaperumal.repository;

import com.veeriyaperumal.model.GameBoard;
import com.veeriyaperumal.model.Ladder;
import com.veeriyaperumal.model.Player;
import com.veeriyaperumal.model.Position;
import com.veeriyaperumal.model.Snake;

public class Repository {
	private int targetPositionNumber;
	private static Repository repository;
	private GameBoard board;

	public GameBoard getBoard() {
		return board;
	}

	public void setBoard(GameBoard board) {
		this.board = board;
	}

	private Repository() {
		board = new GameBoard();
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public void setBoardSize(Position boardSize) {
		board.setBoard(boardSize);
		targetPositionNumber = board.getBoard().length * board.getBoard()[0].length;
	}

	public void setSnakeData(Snake[] snakes) {
		board.setSnakes(snakes);
	}

	public void setPlayerData(Player[] players) {
		board.setPlayers(players);
	}

	public void setLadderData(Ladder[] ladders) {
		board.setLadders(ladders);
	}

	public int getTargetPositionNumber() {
		return targetPositionNumber;
	}

}
