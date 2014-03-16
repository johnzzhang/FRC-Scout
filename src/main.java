import data.DataWriter;
import gui.Window;

/**
 * The main class of the program. Nothing to see here.
 * 
 * @author John
 *
 */

public class main {
	
	static Window window;
	static DataWriter writer;
	
	public static void main(String[] args) {
		window = new Window();
		writer = new DataWriter();
		writer.write("text.txt", new String[]{"hello", "goodbye"});
	}
	
}
