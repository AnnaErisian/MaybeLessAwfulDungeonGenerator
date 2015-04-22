package sigmaj.fun.dungeonGenerator.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

import sigmaj.fun.dungeon.Dungeon;
import sigmaj.fun.dungeonGenerator.generator.DungeonGenerator;
import sigmaj.fun.dungeonGenerator.generator.DungeonSettings;

public class DGControlWindow {

	/** frame that is this window's propery */
	private JFrame frame;
	
	/** dungeon display window controlled by this window */
	private DGWindow dungeonWindow;
	
	/** Settings for new dungeon creation */
	private DungeonSettings dgSettings;
	
	/**
	 * Create the application.
	 */
	public DGControlWindow(DGWindow dungeonWindow) {
		this.dungeonWindow = dungeonWindow;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JButton btnGenerateNew = new JButton("New Dungeon");
		frame.getContentPane().add(btnGenerateNew);
		btnGenerateNew.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Dungeon tempDungeon = DungeonGenerator.makeDungeon(dgSettings);
				System.out.println(tempDungeon);
				dungeonWindow.setDungeon(tempDungeon);
			}
		});
		
		JButton btnSmoothToOpen = new JButton("Smooth to open");
		frame.getContentPane().add(btnSmoothToOpen);
		
		JButton btnSmoothToClosed = new JButton("Smooth to closed");
		frame.getContentPane().add(btnSmoothToClosed);
		
		frame.setVisible(true);
	}

}