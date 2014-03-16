package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * This is the DataWriter class. It will write data in the form of a String[]
 * to a specified file path.
 * 
 * @author John
 *
 */

public class DataWriter {
	
	public void write(String filePath, String[] data) {
	    try {
	        File file = new File(filePath);
	        FileOutputStream is = new FileOutputStream(file);
	        OutputStreamWriter osw = new OutputStreamWriter(is);    
	        Writer w = new BufferedWriter(osw);
	        for(String datum : data) {
	        	w.write(datum);
	        	w.write(" , ");
	        }
	        w.close();
	    } catch (IOException e) {
	        System.err.println("Problem writing to the file.");
	    }
	}
	
}
