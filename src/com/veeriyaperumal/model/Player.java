package com.veeriyaperumal.model;

public class Player {
	private String name;
	private Position currentPosition;
	private int currentPositionNumber;

	public int getCurrentPositionNumber() {
		return currentPositionNumber;
	}

	public void setCurrentPositionNumber(int currentPositionNumber) {
		this.currentPositionNumber = currentPositionNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
}
