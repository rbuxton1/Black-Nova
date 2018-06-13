package com.ryanbuxton.blacknova.map;

import java.awt.Point;
import java.util.ArrayList;

public class StringMap {
	private String[][] map;
	
	public StringMap(int height, int width, String clearChar) {
		map = new String[height][width];
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length; x++) {
				map[y][x] = clearChar;
			}
		}
	}
	
	public String get(int x, int y) {
		return map[(map.length-1) - y][x];
	}
	public void set(int x, int y, String s) {
		map[(map.length-1) - y][x] = s;
	}
	
	public void printMap() {
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length; x++) {
				System.out.print(get(x, y));
			}
			System.out.println("");
		}
	}
	
	public ArrayList<Point> path(Point cur, Point tar, String s) {
		ArrayList<Point> halls = new ArrayList<Point>();
		while(cur.x != tar.x || cur.y != tar.y) {
			if(cur.x != tar.x) {
				if(cur.x > tar.x) {
					cur.setLocation(cur.x - 1, cur.y);
					if(!get(cur.x, cur.y).equals("S") && !get(cur.x, cur.y).equals("R") && !get(cur.x, cur.y).equals("E")) {
						set(cur.x, cur.y, s);
						halls.add(cur);
					}
				}
				if(cur.x < tar.x) {
					cur.setLocation(cur.x + 1, cur.y);
					if(!get(cur.x, cur.y).equals("S") && !get(cur.x, cur.y).equals("R") && !get(cur.x, cur.y).equals("E")) {
						set(cur.x, cur.y, s);
						halls.add(cur);
					}
				}
			}
			if(cur.y != tar.y) {
				if(cur.y > tar.y) {
					cur.setLocation(cur.x, cur.y-1);
					if(!get(cur.x, cur.y).equals("S") && !get(cur.x, cur.y).equals("R") && !get(cur.x, cur.y).equals("E")) {
						set(cur.x, cur.y, s);
						halls.add(cur);
					}
				}
				if(cur.y < tar.y) {
					cur.setLocation(cur.x, cur.y+1);
					if(!get(cur.x, cur.y).equals("S") && !get(cur.x, cur.y).equals("R") && !get(cur.x, cur.y).equals("E")) {
						set(cur.x, cur.y, s);
						halls.add(cur);
					}
				}
			}
		}
		return halls;
	}
}
