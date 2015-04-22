package sigmaj.fun.dungeonGenerator.ui;

import java.awt.Color;
import java.util.HashMap;

/**
 * Draws a cell
 * @author Jake
 *
 */
public class ZoneArtist extends HashMap<Integer, Color>{
	
	public boolean hasZone(int index)
	{
		return containsKey(new Integer(index));
	}
	
	public void add(int i, Color c)
	{
		add(new Integer(i), c);
	}
	
	public Color get(int i)
	{
		return get(new Integer(i));
	}
}
