package com.ryanbuxton.blacknova.map.chunks;

import com.ryanbuxton.blacknova.map.StringMap;

public class EmptyChunk implements Chunk {
	private StringMap myMap;
	
	public EmptyChunk(int width, int height) {
		myMap = new StringMap(width, height, " ");
	}
	
	public StringMap getMap() {
		return myMap;
	}
	public String getAtMapLoc(int x, int y) {
		return myMap.get(x, y);
	}
	public String[] getRow(int y) {
		return myMap.getAsArray()[y];
	}
}
