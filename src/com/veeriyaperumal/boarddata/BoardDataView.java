package com.veeriyaperumal.boarddata;

import java.util.Scanner;

import com.veeriyaperumal.model.Position;
import com.veeriyaperumal.model.Snake;
import com.veeriyaperumal.model.Ladder;
import com.veeriyaperumal.model.Player;

public class BoardDataView {
	private BoardDataViewModel boardDataViewModel;
	Scanner read = new Scanner(System.in);

	public BoardDataView() {
		this.boardDataViewModel = new BoardDataViewModel(this);
	}

	public void collectGameData() {
		boardDataViewModel.setBoardSize(getBoardSize());
		boardDataViewModel.setSnakeData(getSnakes());
		boardDataViewModel.setLadderData(getLadders());
		boardDataViewModel.setPlayerData(getPlayers());
	}

	private Ladder[] getLadders() {
		System.out.print("Enter how many ladders : ");
		int ladderCount = read.nextInt();
		Ladder[] ladders = new Ladder[ladderCount];
		for (int i = 0; i < ladderCount; i++) {
			Ladder ladder = new Ladder();
			System.out.println("Enter ladder start details : ");
			ladder.setStartPostionNumber(read.nextInt());
			System.out.println("Enter ladder end details : ");
			ladder.setEndPositionNumber(read.nextInt());
			if(ladder.getStartPostionNumber()>ladder.getEndPositionNumber()) {
				System.out.println("Ladder start position is greater than end position.So give again....");
				i--;
				continue;
			}
			ladders[i] = ladder;
		}
		return ladders;
	}

	private Player[] getPlayers() {
		System.out.print("Enter how many Players : ");
		int playerCount = read.nextInt();
		Player[] players = new Player[playerCount];
		for (int i = 0; i < playerCount; i++) {
			Player player = new Player();
			System.out.println("Enter player name : ");
			player.setName(read.next());
			players[i] = player;
		}
		return players;
	}

	private Snake[] getSnakes() {
		System.out.print("Enter how many snakes : ");
		int snakeCount = read.nextInt();
		Snake[] snakes = new Snake[snakeCount];
		for (int i = 0; i < snakeCount; i++) {
			Snake snake = new Snake();
			System.out.println("Enter snake head position number : ");
			snake.setStartPostionNumber(read.nextInt());
			System.out.println("Enter snake tail position number : ");
			snake.setEndPositionNumber(read.nextInt());
			if(snake.getStartPostionNumber()<snake.getEndPositionNumber()) {
				System.out.println("Snake start position is less than end position.So give again....");
				i--;
				continue;
			}
			
			snakes[i] = snake;
		}
		return snakes;
	}

	private Position getBoardSize() {
		Position size = new Position();
		while (true) {
			System.out.print("Enter how many board row : ");
			size.setRow(read.nextInt());
			if (size.getRow() % 2 != 0) {
				System.out.println("Even rows only accepted...");
				continue;
			}
			break;
		}
		System.out.print("Enter how many board column : ");
		size.setCol(read.nextInt());
		return size;
	}

}
