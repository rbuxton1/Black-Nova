package com.ryanbuxton.blacknova.map;

import com.ryanbuxton.blacknova.map.chunks.Chunk;

public class ChunkMap {
	private Chunk[][] map;
	
	public ChunkMap(int height, int width, Chunk c) {
		map = new Chunk[height][width];
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length; x++) {
				map[y][x] = c;
			}
		}
	}
	
	public Chunk get(int x, int y) {
		return map[(map.length-1) - y][x];
	}
	public void set(int x, int y, Chunk o) {
		map[(map.length-1) - y][x] = o;
		//map[y][x] = o;
	}
	
	public void printMap() {
		for(int y = map.length - 1; y >= 0; y--) {
			for(int x = 0; x < map[y].length; x++) {
				System.out.print(get(x, y).toString());
			}
			System.out.println("");
		}
	}
}
