package sigmaj.fun.dungeon;

import java.awt.Color;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Zone extends ArrayList<Cell>{
	
	private Color zoneColor;
	
	public Zone()
	{
		this(Color.WHITE);
	}
	
	public Zone(Color zc)
	{
		super();
		setColor(zc);
	}
	
	public void setColor(Color c)
	{
		if(c == null)
		{
			throw new NullPointerException();
		} else{
			zoneColor = c;
		}
	}
	
	public Color getColor()
	{
		return zoneColor;
	}
	
	/**
	 * changed return to be == equals so that removal by position is possible
	 */
	@Override
	public boolean remove(Object o)
	{
		int size = size();
		for(int i = 0; i < size; i++)
		{
			if(get(i) == o)
			{
				remove(i);
				return true;
			}
		}
		//not found
		return false;
		
	}
}
