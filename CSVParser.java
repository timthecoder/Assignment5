/* TODO: Replace these file comments with a description of what your program
 * does.
 */
import acm.program.*;
import java.io.*;
import java.util.*;
import acm.util.*;

public class CSVParser extends ConsoleProgram {
	
	private static final String file = "food-origins.csv";
	public void run() {
		/* This starter code is designed to test a fieldsIn method that breaks a
		 * line from a CSV file apart into tokens and returns an ArrayList of them.
		 * You don't have to implement this program this way, but we strongly
		 * recommend it.
		 * 
		 * TODO: Delete this run method and replace it with one that prompts the
		 * user for a filename and column number, calls the extractColumn
		 * method that you'll be writing, and prints out all the cells in that
		 * column.
		 */
		
		
		extractColumn(file,0);
		
		/*while (true) {
			String line = readLine("file name: ");
			ArrayList<String> fields = fieldsIn(line);
			
			for (int i = 0; i < fields.size(); i++) {
				println("Field " + i + ": [" + fields.get(i) + "]");
			}
		}
		*/
	}
	
	/**
	 * Given a line from a CSV file, parses each field out of the line and returns
	 * an ArrayList containing all of them.
	 * 
	 * @param line The line of the file to parse.
	 * @return A list of all the fields in that line.
	 */
	private ArrayList<String> fieldsIn(String line) {
		// TODO: Optionally implement this. Definitely delete this comment. :-)
		
		ArrayList<String> result = new ArrayList<String>();
		
		
			result.add(line.substring(0, line.indexOf(",")));
			line = line.substring(line.indexOf(",")+1).trim();
			if(line.contains("\"")){
				line = line.replace("\"", " ").trim();
			}
			result.add(line);
		
		
		return result;
	}
	
	/**
	 * Given the name of a CSV file and a column index, returns the contents of
	 * that column in the CSV file as an ArrayList.
	 * <p>
	 * This method can assume that the file to read is properly formatted and
	 * that the specified column index is in-bounds. However, the method
	 * cannot necessarily assume that the file exists. If the specified file
	 * does not exist, this method should return null as a sentinel value.
	 * 
	 * @param filename The name of the file to open.
	 * @param columnIndex The index of the column to extract.
	 * @return A list of all the fields in the indicated column.
	 */
	private ArrayList<String> extractColumn(String filename, int columnIndex) {
		// TODO: Replace this comment with your implementation of extractColumn.
		// We recommend that you start by implementing fieldsIn and only then
		// moving on to this method.
		ArrayList<String> result = new ArrayList<String>();
		try{
			BufferedReader rd = new BufferedReader(new FileReader("filename"));
			
			while(true){
				String line = rd.readLine();
				
				if(line == null)break;
				
				println(line);
				
			}
			
		
		
		
		}catch(IOException ex){
			
			throw new ErrorException(ex);
		}
		
		
		return null;
	}
}
