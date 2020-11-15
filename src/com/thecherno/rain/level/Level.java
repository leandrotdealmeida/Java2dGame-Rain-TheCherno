package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
		
	}
	
	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {		
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScrool, int yScroll, Screen screen) {
		screen.setOffset(xScrool, yScroll);
		int x0 = xScrool >> 4;
		int x1 = (xScrool + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >>4;
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}		
	}
	
	public Tile getTile(int x, int y) {
		if(tiles[x + y * width] == 0) return Tile.grass;
		return Tile.voidTile;		
	}
}
