package com.ryanbuxton.blacknova.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class ChunkMap {
	private StringMap cm;
	
	public ChunkMap(int width, int height) {
		cm = new StringMap(width, height, "-");
		
		Random gen = new Random();
		Point start = new Point(gen.nextInt(width), gen.nextInt(height));
		Point end = new Point(gen.nextInt(width), gen.nextInt(height));
		int g = 0;
		while(!(start.distance(end) >= width * 1.0)) {
			start = new Point(gen.nextInt(width), gen.nextInt(height));
			end = new Point(gen.nextInt(width), gen.nextInt(height));
			g++;
		}
		System.out.println("genned " + g + " end dist " + start.distance(end));
		cm.set(start.x, start.y, "S");
		cm.set(end.x, end.y, "E");
		
		System.out.println("pre halls");
		cm.printMap();
		
		System.out.println("after halls");
		ArrayList<Point> halls = new ArrayList<Point>();
		halls.addAll(cm.path(start, end, "H"));
		cm.printMap();
		
		System.out.println("pre room halls");
		ArrayList<Point> rooms = new ArrayList<Point>();
		int numRooms = gen.nextInt(width);
		for(int i = 0; i < numRooms; i++) {
			Point room = new Point(gen.nextInt(width), gen.nextInt(height));
			if(!cm.get(room.x, room.y).equals("S") && !cm.get(room.x, room.y).equals("R") && !cm.get(room.x, room.y).equals("E")) {
				cm.set(room.x, room.y, "R");
				rooms.add(room);
			}
			
		}
		cm.printMap();
		
		System.out.println("after room halls");
		System.out.print("number of halls after each run: ");
		for(int i = 0; i < rooms.size(); i++) {
			halls.addAll(cm.path(rooms.get(i), halls.get(gen.nextInt(halls.size())), "H"));
			System.out.print(i + "> " + halls.size() + ", ");
		}
		System.out.println();
		cm.printMap();
	}
	
	
}
