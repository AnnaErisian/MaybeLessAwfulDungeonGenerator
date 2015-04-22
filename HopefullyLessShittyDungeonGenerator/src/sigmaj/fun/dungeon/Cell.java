package sigmaj.fun.dungeon;

import java.awt.Color;
import java.awt.Graphics;

import sigmaj.fun.dungeonGenerator.ui.CellArtist;

public class Cell{
	
	public int x, y, tag1, tag2;
	
	private CellArtist artist;
	
	private static final Color DEFAULT_ZONE_COLOR = Color.black;
	
	public Cell(int xCoord, int yCoord)
	{
		this(xCoord, yCoord, 0, 0);
	}
	
	public Cell(int xCoord, int yCoord, int t1, int t2)
	{
		x = xCoord;
		y = yCoord;
		tag1 = t1;
		tag2 = t2;
		artist = new CellArtist(this);
		
	}
	
	public void setTag1(int newVal) { tag1 = newVal; }
	public void setTag2(int newVal) { tag2 = newVal; }
	public int getTag1() { return tag1; }
	public int getTag2() { return tag2; }
	
	public void draw(Graphics g, int scale)
	{
		artist.draw(g, scale, DEFAULT_ZONE_COLOR);
	}
	
	public void draw(Graphics g, int scale, Color zoneColor)
	{
		artist.draw(g, scale, zoneColor);
	}
}
