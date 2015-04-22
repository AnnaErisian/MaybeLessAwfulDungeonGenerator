package sigmaj.fun.dungeonGenerator.ui;

import java.awt.Color;
import java.awt.Graphics;

import sigmaj.fun.dungeon.Cell;

/**
 * Draws a cell
 * @author Jake
 *
 */
public class CellArtist {
	
	Cell client;
	
	public CellArtist(Cell dude)
	{
		client = dude;
	}
	
	public void draw(Graphics g, int scale, Color zoneColor)
	{
		g.fillRect(client.x * (scale + 1), client.y * (scale + 1), scale, scale);
		//System.out.println("Draw " + scale + " X " + scale + " rectangle at " + client.x*(scale+1) + " , " + client.y*(scale+1));
	}
}
