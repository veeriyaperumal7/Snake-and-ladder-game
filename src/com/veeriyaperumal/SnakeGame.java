package com.veeriyaperumal;

import com.veeriyaperumal.game.GameView;

public class SnakeGame {
	private GameView gameView;

	private SnakeGame() {
		this.gameView = new GameView();
	}

	public static void main(String[] args) {
		SnakeGame game = new SnakeGame();
		System.out.println("Welcome to snake and ladder game\n");
		game.gameView.start();
	}

}
