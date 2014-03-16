package action;

import gui.ContentPane;
import gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.DataWriter;

public class SaveDataListener implements ActionListener {
	
	static DataWriter writer;
	
	public void actionPerformed(ActionEvent event) {
		writer = new DataWriter();
		for(ContentPane pane : Window.getContentPanes()) {
			writer.write("text.txt", DataWriter.matchLabelWithField(pane));
		}
	}

}
