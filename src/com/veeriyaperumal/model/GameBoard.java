package com.veeriyaperumal.model;

import java.util.HashMap;

public class GameBoard {

	private String[][] board;
	private HashMap<Integer, Integer> snakes;
	private HashMap<Integer, Integer> ladders;
	private Player[] players;
//	private Snake[] snakes;
//	private Ladder[] ladders;

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(Position size) {
		board = new String[size.getRow()][size.getCol()];
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public HashMap<Integer, Integer> getSnakes() {
		return snakes;
	}

	public void setSnakes(Snake[] snakes) {
		this.snakes = new HashMap<Integer, Integer>();
		for (Snake snake : snakes) {
			this.snakes.put(snake.getStartPostionNumber(), snake.getEndPositionNumber());
		}
	}

	public HashMap<Integer, Integer> getLadders() {
		return ladders;
	}

	public void setLadders(Ladder[] ladders) {
		this.ladders = new HashMap<Integer, Integer>();
		for (Ladder ladder : ladders) {
			this.ladders.put(ladder.getStartPostionNumber(), ladder.getEndPositionNumber());
		}
	}
}
