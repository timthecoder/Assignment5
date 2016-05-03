/* TODO: Replace these file comments with a description of what your program
 * does.
 */
import acm.program.*;
import java.io.*;
import java.util.*;
import acm.util.*;

public class LicensePlateGame extends ConsoleProgram {
	private static final String DICTIONARY_FILE = "dictionary.txt";
	
	private ArrayList<String> dictList = new ArrayList<String>();
	
	public void run(){
		
		readDictionary(DICTIONARY_FILE);
		
		while(true){
			String letters = readLine("Enter license plate letters: ");
			if( letters.length() == 3){
				letters = letters.toLowerCase();
				analyzeLetters(letters);
			}else{
				println("Please enter three letters.");
			}
			
		}
	}

	
	private void readDictionary(String filename	){
	
		
		try{
			
			
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true){
				String line = rd.readLine();
				if(line == null) break;
				dictList.add(line);
			}
		}catch (IOException ex){
			
			throw new ErrorException(ex);
			
		}
	}
	
	private void analyzeLetters(String letters){
		
		//goes through list of dictionary array
		for(int first = 0; first < dictList.size(); first++){
			
			//finds if first letter exists in the word
			if(dictList.get(first).indexOf(letters.charAt(0)) != -1){
				
				//finds if second letter exists
				if(dictList.get(first).indexOf(letters.charAt(1)) != -1){
					
					//finds if //third letter exists
					if(dictList.get(first).indexOf(letters.charAt(2)) != -1){
						
						//comparison between first two letters
						String reformat = dictList.get(first).substring(dictList.get(first).indexOf(letters.charAt(0)));
						//println(reformat);
						if(reformat.indexOf(letters.charAt(0)) < reformat.indexOf(letters.charAt(1))){
							
							String reformat2 = reformat.substring(reformat.indexOf(letters.charAt(1)));
							//println(reformat2);
							
							//compares between second two letters
							if(reformat2.indexOf(letters.charAt(1)) < reformat2.lastIndexOf(letters.charAt(2))){
								
								println(dictList.get(first));
							}
				
								
							
						}
							
						
					}
				}
			}
		}
	}
	


}
