package com.veeriyaperumal.model;

public class Ladder {
	private Position start;
	private Position end;
	private int startPostionNumber, endPositionNumber;

	public int getStartPostionNumber() {
		return startPostionNumber;
	}

	public void setStartPostionNumber(int startPostionNumber) {
		this.startPostionNumber = startPostionNumber;
	}

	public int getEndPositionNumber() {
		return endPositionNumber;
	}

	public void setEndPositionNumber(int endPositionNumber) {
		this.endPositionNumber = endPositionNumber;
	}

	public Position getStart() {
		return start;
	}

	public void setStart(Position start) {
		this.start = start;
	}

	public Position getEnd() {
		return end;
	}

	public void setEnd(Position end) {
		this.end = end;
	}

}
