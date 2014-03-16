package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import action.SaveDataListener;

/**
 * This is the window class which contains and displays the content panes.
 * Add panes to the window before the this.pack if you want the window
 * to scale nicely. The dimensions of the window can be set using
 * this.setPreferredSize(), but you shouldn't have to.
 * 
 * @author John
 *
 */

public class Window extends JFrame {

	// create your content panes here
	static ContentPane pregame = new ContentPane("Pregame", new String[]{"Team Name", "Team Number"}, new String[]{"Nutrons", "125"});
	static ContentPane auto = new ContentPane("Auto", new String[]{"Balls Started With", "Balls Shot"}, new String[]{"3", "2"});
	static ContentPane teleop = new ContentPane("Teleop", new String[]{"Balls Shot", "Assists", "Truss Shots"}, new String[]{"4", "2", "1"});
	JButton submitDataButton = new JButton("Submit Data");
	
	public Window() {
        super("FRC Scout"); // title
        // book keeping stuff
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        // add your content panes after here
        this.add(pregame);
        this.add(auto);
        this.add(teleop);
        // add save button
        submitDataButton.addActionListener(new SaveDataListener());
        this.add(submitDataButton);
        // pack the content panes and show the window
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
	public static ContentPane[] getContentPanes() {
		return new ContentPane[]{pregame, auto, teleop};
	}
	
}
