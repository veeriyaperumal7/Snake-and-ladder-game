package com.veeriyaperumal.model;

public class Snake {
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

	private Position head;
	private Position tail;

	public Position getHead() {
		return head;
	}

	public void setHead(Position head) {
		this.head = head;
	}

	public Position getTail() {
		return tail;
	}

	public void setTail(Position tail) {
		this.tail = tail;
	}

}
