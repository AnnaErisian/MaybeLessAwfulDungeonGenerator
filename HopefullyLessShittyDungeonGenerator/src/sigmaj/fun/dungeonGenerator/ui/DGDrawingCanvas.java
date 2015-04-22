package sigmaj.fun.dungeonGenerator.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import sigmaj.fun.dungeon.Dungeon;

@SuppressWarnings("serial")
public class DGDrawingCanvas extends JPanel {
	
	public static int scale = 8;
	
	private Dungeon dungeon;

	/**
	 * Create the panel.
	 */
	public DGDrawingCanvas() {
		this(new Dungeon(100,100));
	}
	

	/**
	 * Create the panel.
	 */
	public DGDrawingCanvas(Dungeon dung) {
		super();
		dungeon = dung; //this is not about the quality of my code.  At all.
		setPreferredSize(new Dimension((dungeon.rows()) * (scale + 1), (dungeon.columns()) * (scale + 1)));
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getParent().getWidth(), getParent().getHeight());
		dungeon.draw(g, scale);
	}
	
	/**
	 * sets the dungeon to draw next
	 */
	public void setDungeon(Dungeon dng)
	{
		dungeon = dng;
		setPreferredSize(new Dimension((dungeon.rows()) * (scale + 1), (dungeon.columns()) * (scale + 1)));
		repaint();
	}
}
