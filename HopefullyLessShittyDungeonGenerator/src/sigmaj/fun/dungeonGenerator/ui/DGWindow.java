package sigmaj.fun.dungeonGenerator.ui;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import sigmaj.fun.dungeon.Dungeon;

public class DGWindow {

	private JFrame mainFrame;
	private DGDrawingCanvas drawPanel;
	

	/**
	 * Create the application.
	 */
	public DGWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		mainFrame.getContentPane().add(scrollPane);
		
		drawPanel = new DGDrawingCanvas();
		scrollPane.setViewportView(drawPanel);
		mainFrame.setVisible(true);
	}
	
	/**
	 * sets the dungeon and redraws the scene
	 * @param dng
	 */
	public void setDungeon(Dungeon dng)
	{
		drawPanel.setDungeon(dng);
		drawPanel.repaint();
	}
	
}
