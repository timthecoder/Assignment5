/* TODO: Replace these file comments with a description of what your program
 * does.
 */
import acm.program.*;

public class SyllableCounting extends ConsoleProgram {
	public void run() {
		/* Repeatedly prompt the user for a word and print out the estimated
		 * number of syllables in that word.
		 */
		while (true) {
			String word = readLine("Enter a single word: ");
			println("  Syllable count: " + syllablesIn(word));
		}
	}
	
	/**
	 * Given a word, estimates the number of syllables in that word according to the
	 * heuristic specified in the handout.
	 * 
	 * @param word A string containing a single word. 
	 * @return An estimate of the number of syllables in that word.
	 */
	private int syllablesIn(String word) {
		
		//total syllables
		int total = 0;
		
		
		
		word = word.toLowerCase();
		//adds total each vowel it recognizes in the word
		for ( int i = 0; i < word.length(); i++){
			
			//adds to total if vowel detected
			if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y' ){
				total++;
				if( i != 0){
					//if statement when two vowels check
					if(check(word.charAt(i),word.charAt(i-1))){
						total--;
						
						//only considered if the word ends with "vowel + e like Manatee"
						if(word.charAt(word.length()-1) =='e'){
							total++;
						}
					}
					
				}
			}
			
			
		}
		//if e appears at the end, then subtract from the total
		if(word.charAt(word.length()-1) == 'e')total--;
		if(total == 0){
			total++;
		}
		return total;
	}
	
	//checks to see if the letter next is a vowel
	private boolean check(char letter, char prevLetter){
		
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y' ){
			
			if(prevLetter == 'a' || prevLetter == 'e' || prevLetter == 'i' || prevLetter == 'o' || prevLetter == 'u' || prevLetter == 'y' ){
				
				return true;
			}
		}
		return false;
	}
}
