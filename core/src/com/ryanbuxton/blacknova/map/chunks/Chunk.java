package com.ryanbuxton.blacknova.map.chunks;

import com.ryanbuxton.blacknova.map.ChunkMap;
import com.ryanbuxton.blacknova.map.StringMap;

public interface Chunk {
	public StringMap getMap();
	public String getAtMapLoc(int x, int y);
	public String[] getRow(int y);
}
