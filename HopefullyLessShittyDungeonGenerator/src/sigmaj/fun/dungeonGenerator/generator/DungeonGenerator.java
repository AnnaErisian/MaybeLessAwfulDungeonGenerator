package sigmaj.fun.dungeonGenerator.generator;

import java.awt.EventQueue;

import sigmaj.fun.dungeon.Dungeon;
import sigmaj.fun.dungeonGenerator.ui.DGControlWindow;
import sigmaj.fun.dungeonGenerator.ui.DGWindow;

public class DungeonGenerator {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				final DGWindow dungeonWindow = new DGWindow();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new DGControlWindow(dungeonWindow);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
	}
	
	/**
	 * create a new dungeon
	 */
	public static Dungeon makeDungeon(DungeonSettings dgs)
	{
		return new Dungeon((int)(Math.random()*100) + 20, (int)(Math.random()*100) + 20);
	}

}
