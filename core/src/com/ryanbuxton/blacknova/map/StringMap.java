package com.ryanbuxton.blacknova.map;

import java.awt.Point;
import java.util.ArrayList;

public class StringMap {
	private String[][] map;
	public String clearChar;
	
	public StringMap(int height, int width, String clearChar) {
		this.clearChar = clearChar;
		map = new String[height][width];
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length; x++) {
				map[y][x] = clearChar;
			}
		}
	}
	
	public String get(int x, int y) {
		if(x >= map[0].length || x < 0 || y >= map.length || y < 0) return clearChar;
		return map[(map.length-1) - y][x];
	}
	public void set(int x, int y, String s) {
		map[(map.length-1) - y][x] = s;
	}
	
	public void printMap() {
		for(int y = map.length - 1; y >= 0; y--) {
			for(int x = 0; x < map[y].length; x++) {
				System.out.print(get(x, y));
			}
			System.out.println("");
		}
	}
	
	public void setAll(String[][] n) {
		this.map = n;
	}
	public void setAllChar(char[][] c) {
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length; x++) {
				set(x, y, c[(map.length-1) - y][x] + "");
			}
		}
	}
	
	public void replaceAllOccur(String s, String n) {
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length; x++) {
				if(get(x,y).equals(s)) set(x,y,n);
			}
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
	
	/*
	 * Converts halls that have halls all around them to rooms to make things more interesting.
	 * Probably shouldnt be called before all other rooms have been pathed together.
	 */
	public void hallToRoom() {
		for(int y = map.length - 2; y > 0; y--) {
			for(int x = 1; x < map.length - 1; x++) {
				if(get(x, y).toString().equals("H") && get(x+1, y).toString().equals("H") && get(x-1, y).toString().equals("H")
						&& get(x, y+1).toString().equals("H") && get(x, y-1).toString().equals("H")) {
					set(x, y, "R");
				}
			}
		}
	}
	
	public String[][] getAsArray(){
		return map;
	}
}
