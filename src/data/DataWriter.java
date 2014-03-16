package data;

import gui.ContentPane;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * This is the DataWriter class. It will write data in the form of a String[]
 * to a specified file path.
 * 
 * @author John
 *
 */

public class DataWriter {
	
	public static String[] matchLabelWithField(ContentPane pane) {
		String[] matchedData = new String[pane.getLabels().length];
		for(int i = 0; i < pane.getLabels().length; i++) {
			matchedData[i] = pane.getLabels()[i] + " : " + pane.getFields()[i];
		}
		return matchedData;
	}
	
	public void write(String filePath, String[] data) {
	    try {
	        File file = new File(filePath);
	        FileWriter fw = new FileWriter(file, true);    
	        Writer w = new BufferedWriter(fw);
	        for(String datum : data) {
	        	w.write(datum);
	        	w.write(" , ");
	        }
	        ((BufferedWriter) w).newLine();
	        w.close();
	    } catch (IOException e) {
	        System.err.println("Problem writing to the file.");
	    }
	}
	
}
