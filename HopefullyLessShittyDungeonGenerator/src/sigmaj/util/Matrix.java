package sigmaj.util;

public interface Matrix<E> {
	public void addRow();
	public void addRows(int number);
	public void addColumn();
	public void addColumns(int number);
	public void set(int row, int column, E object);
	public E get(int row, int column);
	public int rows();
	public int columns();
	public int size();
}
