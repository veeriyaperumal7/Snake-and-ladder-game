package com.veeriyaperumal.boarddata;

import com.veeriyaperumal.model.Ladder;
import com.veeriyaperumal.model.Player;
import com.veeriyaperumal.model.Position;
import com.veeriyaperumal.model.Snake;
import com.veeriyaperumal.repository.Repository;

public class BoardDataViewModel {

	private BoardDataView boardDataView;
//	private int boardRowCount;
//	private int boardColumnCount;

	BoardDataViewModel(BoardDataView boardDataView) {
		this.boardDataView = boardDataView;
	}

	void setBoardSize(Position boardSize) {
		Repository.getInstance().setBoardSize(boardSize);
	}

	public void setSnakeData(Snake[] snakes) {
		Repository.getInstance().setSnakeData(snakes);

	}

	public void setPlayerData(Player[] players) {
		Repository.getInstance().setPlayerData(players);

	}

	public void setLadderData(Ladder[] ladders) {
		Repository.getInstance().setLadderData(ladders);

	}

}
