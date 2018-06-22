package com.ryanbuxton.blacknova.map.chunks;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.ryanbuxton.blacknova.map.ChunkMap;
import com.ryanbuxton.blacknova.map.StringMap;

public class RoomChunk implements Chunk {
	private StringMap myMap;
	public final static int DEFAULT = 0;
	public final static int START_ROOM = 1;
	public final static int END_ROOM = 2;
	public final static int HALL_ROOM = 3;
	
	public RoomChunk(int width, int height, StringMap chunkMap, int myX, int myY, int type) {
		myMap = new StringMap(width, height, " ");
		
		char[][] load = new char[height][width];
		Scanner in = new Scanner("");
		try {
			if(width == 8 && height == 8) {
				if(type == DEFAULT) in = new Scanner(Gdx.files.internal("maps/room_8x8.txt").file());
				else if(type == START_ROOM) in = new Scanner(Gdx.files.internal("maps/start_8x8.txt").file());
				else if(type == END_ROOM) in = new Scanner(Gdx.files.internal("maps/end_8x8.txt").file());
				else if(type == HALL_ROOM) in = new Scanner(Gdx.files.internal("maps/hall_8x8.txt").file());
			}
			else if(width == 16 && height == 16) {
				if(type == DEFAULT) in = new Scanner(Gdx.files.internal("maps/room_16x16.txt").file());
				else if(type == START_ROOM) in = new Scanner(Gdx.files.internal("maps/start_16x16.txt").file());
				else if(type == END_ROOM) in = new Scanner(Gdx.files.internal("maps/end_16x16.txt").file());
				else if(type == HALL_ROOM) in = new Scanner(Gdx.files.internal("maps/hall_16x16.txt").file());
			}
		} catch (FileNotFoundException e) {
			Gdx.app.log("ERROR", "Couldnt load a room map!");
		}
		int i = 0;
		while(in.hasNextLine()){
			String line = in.nextLine();
			while(line.length() != width) {
				line += " ";
			}
			load[i] = line.toCharArray();
			i++;
			//if(type == HALL_ROOM) System.out.println(i + " has " + load.length);
		}
		myMap.setAllChar(load);
		
		
		//context yourself now
		String connections = "";
		if(!chunkMap.get(myX-1, myY).equals(chunkMap.clearChar)) {
			myMap.replaceAllOccur("L", " ");
			myMap.replaceAllOccur("Q", "W");
			connections += "left ";
		}
		if(!chunkMap.get(myX+1, myY).equals(chunkMap.clearChar)) {
			myMap.replaceAllOccur("R", " ");
			myMap.replaceAllOccur("O", "W");
			connections += "right ";
		}
		if(!chunkMap.get(myX, myY+1).equals(chunkMap.clearChar)) {
			myMap.replaceAllOccur("T", " ");
			myMap.replaceAllOccur("N", "W");
			connections += "top ";
		}
		if(!chunkMap.get(myX, myY-1).equals(chunkMap.clearChar)) {
			myMap.replaceAllOccur("B", " ");
			myMap.replaceAllOccur("P", "W");
			connections += "bottom ";
		}
		
		//now all conditionals to walls
		myMap.replaceAllOccur("L", "W");
		myMap.replaceAllOccur("R", "W");
		myMap.replaceAllOccur("T", "W");
		myMap.replaceAllOccur("B", "W");
		
		myMap.replaceAllOccur("N", " ");
		myMap.replaceAllOccur("O", " ");
		myMap.replaceAllOccur("P", " ");
		myMap.replaceAllOccur("Q", " ");
		
		
		//System.out.println("ROOMCHUNK (" + myX + ", " + myY + ") connected on " + connections + " TYPE " + type);
		//myMap.printMap();
		//System.out.println("----------------------------------------------------------------------------------");
		
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
