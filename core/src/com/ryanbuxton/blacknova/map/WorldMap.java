package com.ryanbuxton.blacknova.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import com.ryanbuxton.blacknova.map.chunks.EmptyChunk;
import com.ryanbuxton.blacknova.map.chunks.RoomChunk;

public class WorldMap {
	private StringMap csm;
	private ChunkMap cm;
	private StringMap worldStringMap;
	
	public WorldMap(int width, int height, int chunkHeight, int chunkWidth) {
		csm = new StringMap(width, height, "-");
		cm = new ChunkMap(width, height, new EmptyChunk(chunkHeight, chunkWidth));
		
		Random gen = new Random();
		Point start = new Point(gen.nextInt(width), gen.nextInt(height));
		Point end = new Point(gen.nextInt(width), gen.nextInt(height));
		int g = 0;
		while(!(start.distance(end) >= width * 1.0)) {
			start = new Point(gen.nextInt(width), gen.nextInt(height));
			end = new Point(gen.nextInt(width), gen.nextInt(height));
			g++;
		}
		System.out.println("generate start and end rooms " + g + " times and final ending distance is: " + start.distance(end));
		csm.set(start.x, start.y, "S");
		csm.set(end.x, end.y, "E");
		
		//System.out.println("pre halls");
		//csm.printMap();
		
		//System.out.println("after halls");
		ArrayList<Point> halls = new ArrayList<Point>();
		halls.addAll(csm.path(start, end, "H"));
		//csm.printMap();
		
		//System.out.println("pre room halls");
		ArrayList<Point> rooms = new ArrayList<Point>();
		int numRooms = (width/4) + gen.nextInt(width);
		for(int i = 0; i < numRooms; i++) {
			Point room = new Point(gen.nextInt(width), gen.nextInt(height));
			if(!csm.get(room.x, room.y).equals("S") && !csm.get(room.x, room.y).equals("R") && !csm.get(room.x, room.y).equals("E")) {
				csm.set(room.x, room.y, "R");
				rooms.add(room);
			}
			
		}
		//csm.printMap();
		
		//System.out.println("after room halls");
		System.out.print("number of halls after each run: ");
		for(int i = 0; i < rooms.size(); i++) {
			halls.addAll(csm.path(rooms.get(i), halls.get(gen.nextInt(halls.size())), "H"));
			System.out.print(i + "> " + halls.size() + ", ");
		}
		System.out.println("END.");
		//csm.set(0, 0, "?"); //keystone that shit
		//csm.set(7, 7, "!");
		//csm.printMap();
		
		System.out.println("Final room map in string form:");
		csm.hallToRoom();
		csm.printMap();
		
		System.out.println("Now creating chunkmap from string map . . .");
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				switch(csm.get(x, y).toCharArray()[0]) {
					case 'R':
						cm.set(x, y, new RoomChunk(chunkWidth, chunkHeight, csm, x, y, RoomChunk.DEFAULT));
						break;
					case 'H':
						cm.set(x, y, new RoomChunk(chunkWidth, chunkHeight, csm, x, y, RoomChunk.HALL_ROOM));
						break;
					case 'S':
						cm.set(x, y, new RoomChunk(chunkWidth, chunkHeight, csm, x, y, RoomChunk.START_ROOM));
						break;
					case 'E':
						cm.set(x, y, new RoomChunk(chunkWidth, chunkHeight, csm, x, y, RoomChunk.END_ROOM));
						break;
					case '-':
						cm.set(x, y, new EmptyChunk(chunkWidth, chunkHeight));
						break;
				}
			}
		}//TODO: somethings not right here and Im not sure what ugh
		
		worldStringMap = new StringMap(height * chunkHeight, width * chunkWidth, " ");
		System.out.println("world map " + worldStringMap.getAsArray().length + " by " + worldStringMap.getAsArray()[0].length);
		for(int chunkY = 0; chunkY < height; chunkY++) {
			for(int chunkX = 0; chunkX < width; chunkX++) {
				//now we have the indiviual chunk and we want to break that into the smaller peices.
				StringMap chunkMap = cm.get(chunkX, chunkY).getMap();
				//System.out.println("THIS CHUNK IS " + chunkMap.getAsArray().length + " by " + chunkMap.getAsArray()[0].length);
				
				for(int y = 0; y < chunkMap.getAsArray().length; y++) {
					//System.out.print("y = " + (y + (chunkY * chunkHeight)) + " | ");
					for(int x = 0; x < chunkMap.getAsArray()[y].length; x++) {
						//System.out.print((x + (chunkX * chunkWidth)) + " ");
						worldStringMap.set(x + (chunkX * chunkWidth), y + (chunkY * chunkHeight), chunkMap.get(x, y));
					}
					//System.out.println("");
				}
				
			}
		}
		worldStringMap.printMap();
	}
	
	public StringMap getWorldStringMap() {
		return worldStringMap;
	}
	public String toString() {
		String s = "";
		for(int y = 0; y < worldStringMap.getAsArray().length; y++) {
			for(int x = 0; x < worldStringMap.getAsArray()[y].length; x++) {
				s += worldStringMap.get(x, y);
			}
			s+= " \n";
		}
		return s;
	}
	
}
