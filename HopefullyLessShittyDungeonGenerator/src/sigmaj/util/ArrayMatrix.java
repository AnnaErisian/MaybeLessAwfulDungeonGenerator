package sigmaj.util;

import java.util.Iterator;


public class ArrayMatrix<E> implements Matrix<E>, Iterable<E>{
	
	private static final int DEFAULT_SIZE = 10;
	
	private int rowCount, columnCount;
	private E[][] data;

	@SuppressWarnings("unchecked")
	public ArrayMatrix() {
		rowCount = 0;
		columnCount = 0;
		data = (E[][]) new Object[DEFAULT_SIZE][DEFAULT_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayMatrix(int columns, int rows) {
		rowCount = columns;
		columnCount = rows;
		data = (E[][]) new Object[columns][rows];
	}
	
	@Override
	public void addRow() {
		addRows(1);
	}

	@Override
	public void addRows(int number) {
		ensureRowCapacity(rowCount + number);
		rowCount += number;
	}

	@Override
	public void addColumn() {
		addColumns(1);
	}

	@Override
	public void addColumns(int number) {
		ensureColumnCapacity(columnCount + number);
		columnCount += number;
		
	}

	@Override
	public void set(int row, int column, E object) {
		if(row < 0)
		{
			throw new IndexOutOfBoundsException("Row index (" + row + ") less than 0.");
		} else if(column < 0)
		{
			throw new IndexOutOfBoundsException("Column index (" + column + ") less than 0.");
		} else if(row >= rowCount)
		{
			throw new IndexOutOfBoundsException("Row Index: " + row + ", Number of rows: " + rowCount);
		} else if(column >= columnCount)
		{
			throw new IndexOutOfBoundsException("Column Index: " + column + ", Number of columns: " + columnCount);
		} else
		{
			data[row][column] = object;
		}
	}

	@Override
	public E get(int row, int column) {
		if(row < 0)
		{
			throw new IndexOutOfBoundsException("Row index (" + row + ") less than 0.");
		} else if(column < 0)
		{
			throw new IndexOutOfBoundsException("Column index (" + column + ") less than 0.");
		} else if(row >= rowCount)
		{
			throw new IndexOutOfBoundsException("Row Index: " + row + ", Number of rows: " + rowCount);
		} else if(column >= columnCount)
		{
			throw new IndexOutOfBoundsException("Column Index: " + column + ", Number of columns: " + columnCount);
		} else
		{
			return data[row][column];
		}
	}

	@Override
	public int rows() {
		return rowCount;
	}

	@Override
	public int columns() {
		return columnCount;
	}

	@Override
	public int size() {
		return rowCount * columnCount;
	}
	
	private void ensureRowCapacity(int rows)
	{
		if(data.length < rows)
		{
			int newLength = rows * 2;
			
			@SuppressWarnings("unchecked")
			E[][] newArray = (E[][]) new Object[newLength][data[0].length];
			System.arraycopy(data, 0, newArray, 0, data.length);
			data = newArray;
		}
	}
	
	private void ensureColumnCapacity(int cols)
	{
		if(data[0].length < cols)
		{
			int newLength = cols * 2;
			
			@SuppressWarnings("unchecked")
			E[][] newArray = (E[][]) new Object[data.length][newLength];
			
			int numRows = data.length;
			int oldNumCols = data[0].length;
			
			for(int i = 0; i < numRows; i++)
			{
				System.arraycopy(data[i], 0, newArray[i], 0, oldNumCols);
			}
			
			data = newArray;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	public class Iter implements Iterator<E>
	{
		
		private int xCurr = 0;
		private int yCurr = 0;

		@Override
		public boolean hasNext() {
			return xCurr < columnCount || yCurr < rowCount;
		}

		@Override
		public E next() {
			E temp = data[xCurr][yCurr];
			
			xCurr++;
			if(xCurr == columnCount)
			{
				xCurr = 0;
				yCurr++;
			}
			return temp;
		}
		
	}

}
