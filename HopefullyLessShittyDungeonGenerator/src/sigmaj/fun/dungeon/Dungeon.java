package sigmaj.fun.dungeon;

import java.awt.Graphics;

import sigmaj.fun.dungeonGenerator.ui.DGDrawingCanvas;

public class Dungeon extends sigmaj.util.ArrayMatrix<Cell>{
	
	public Dungeon()
	{
		super();
	}
	
	public Dungeon(int rows, int columns)
	{
		super(rows, columns);
		fillLastColumnsWithEmptyCells(columns);
	}
	
	@Override
	public void addRows(int number)
	{
		super.addRows(number);
		fillLastRowsWithEmptyCells(number);
	}
	
	@Override
	public void addColumns(int number)
	{
		super.addColumns(number);
		fillLastColumnsWithEmptyCells(number);
	}
	
	private void fillLastColumnsWithEmptyCells(int number)
	{
		int rowCount = rows();
		int columnCount = columns();
		
		for(int i = 0; i < rowCount; i++)
		{
			for(int j = columns() - number; j < columnCount; j++)
			{
				set(i,j,new Cell(i,j));
			}
		}
		
	}
	
	private void fillLastRowsWithEmptyCells(int number)
	{
		int rowCount = rows();
		int columnCount = columns();
		
		for(int i = 0; i < columnCount; i++)
		{
			for(int j = rowCount - number; j < rowCount; j++)
			{
				//Mistake: Switched loops, but didn't switch variables.
				//was trying to set col/row instead of row/col
				set(j,i,new Cell(j,i));
			}
		}
		
	}

	public void draw(Graphics g, int scale) {
		int rowCount = rows();
		int columnCount = columns();

		g.clearRect(0, 0, (DGDrawingCanvas.scale+1) * rowCount, (DGDrawingCanvas.scale+1) * columnCount);
		for(int i = 0; i < rowCount; i++)
		{
			for(int j = 0; j < columnCount; j++)
			{
				Cell c = get(i, j);
				c.draw(g, DGDrawingCanvas.scale);
			}
		}
	}
}
