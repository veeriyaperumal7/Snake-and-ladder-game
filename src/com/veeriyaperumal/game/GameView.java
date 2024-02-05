package com.veeriyaperumal.game;

import java.util.Random;

import com.veeriyaperumal.boarddata.BoardDataView;
import com.veeriyaperumal.model.Player;

public class GameView {

	private BoardDataView boardDataView;
	private GameViewModel gameViewModel;

	public GameView() {
		this.boardDataView = new BoardDataView();
		this.gameViewModel = new GameViewModel(this);
	}

	public void start() {
		boardDataView.collectGameData();
		startGame();
	}

	private void startGame() {

		Player[] players = gameViewModel.getPlayers();
		int targetNumber = gameViewModel.getTargetPositionNumber();
		System.out.println("Game was started : ");
		Random random = new Random();
		int diceResult, snakeBiteValue, ladderValue;
		outerLoop: while (true) {
			for (Player player : players) {
				System.out.println(player.getName() + " is playing rolling a dice.");
				diceResult = random.nextInt(6);
				System.out.println("Dice number was : " + diceResult);
				player.setCurrentPositionNumber(player.getCurrentPositionNumber() + diceResult);
				System.out.println(
						player.getName() + "current position number is : " + player.getCurrentPositionNumber());
				snakeBiteValue = gameViewModel.isSnake(player.getCurrentPositionNumber());
				ladderValue = gameViewModel.isLadder(player.getCurrentPositionNumber());

				if (snakeBiteValue != -1) {
					player.setCurrentPositionNumber(snakeBiteValue);
					System.out.println("Result : Snake was bite and goes to " + player.getCurrentPositionNumber());
				} else if (ladderValue != -1) {
					player.setCurrentPositionNumber(ladderValue);
					System.out.println("Result : Claimbed in ladder and goes to " + player.getCurrentPositionNumber());
				} else if (player.getCurrentPositionNumber() == targetNumber) {
					System.out.println("Result : " + player.getName() + " win the game.");
					break outerLoop;
				} else if (player.getCurrentPositionNumber() > targetNumber) {
					player.setCurrentPositionNumber(player.getCurrentPositionNumber() - diceResult);
					System.out.println("Result : Not able to move because dice value greater than required value..");
				} else {
					System.out.println("Result : That is a safe move....");
				}
				System.out.println("===========================================");
			}
		}
	}

}
