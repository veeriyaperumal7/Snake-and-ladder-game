package com.veeriyaperumal.game;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
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
		startGameLevel2();
	}

	private void startGameLevel2() {//Finding minimum path to reach....
		int targetNumber = gameViewModel.getTargetPositionNumber();
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{0,0});
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int currentPosition=arr[0];
			int count=arr[1];
			
			if(currentPosition==targetNumber) {
				System.out.println("The minimum path to reach finish point is : "+ count);
				return;
			}
			
			for(int i=1;i<=6;i++) {
				
				if(gameViewModel.isSnake(currentPosition+i)!=-1) {
					continue;
				}
				int ladder = gameViewModel.isLadder(currentPosition+i);
				if(ladder!=-1) {
					queue.add(new int[] {ladder,count+1});
				}else if(currentPosition+i<=targetNumber) {
					queue.add(new int[] {currentPosition+i,count+1});
				}
			}
			
		}
		
	}

	private void startGame() {
          
		Player[] players = gameViewModel.getPlayers();
		int targetNumber = gameViewModel.getTargetPositionNumber();
		System.out.println("Game was started : ");
		Random random = new Random();
		int diceResult, snakeBiteValue, ladderValue,consecutiveCount=0;
		outerLoop: while (true) {
			for(int i=0;i<players.length;i++) {
				Player player=players[i];
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
				if(diceResult==6) { // If player role dice 6 give chance again ,when consecutive 3 chance if greater go to next player...
					if(consecutiveCount<3) {
						consecutiveCount++;
						i--;
					}else {
						consecutiveCount=0;
					}
				}
			}
		}
	}

}
