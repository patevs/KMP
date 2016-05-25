package handout.src;


/**
 * A new KMP instance is created for every substring search performed. Both the
 * pattern and the text are passed to the constructor and the search method. You
 * could, for example, use the constructor to create the match table and the
 * search method to perform the search itself.
 */
public class KMP {

	public KMP(String pattern, String text) {
		search(pattern, text);
	}

	/**
	 * Builds a match table from a string pattern
	 *  for use in the KMP string search algorithm
	 * 
	 * @param pattern
	 */
	private int[] buildTable(String pattern) {	
		int[] table = new int[pattern.length()];  // create an empty table
		table[0] = -1; table[1] = 0; // initialise table
		
		int j = 0;  	// position in prefix
		int pos = 2;    // position in table
		
		// construct the table
		while(pos < pattern.length() ){
			if( pattern.charAt(pos-1) == pattern.charAt(j) ){
				table[pos] = j+1;
				pos++; j++;
			} else if( j > 0 ){
				j = table[j];
			} else {
				table[pos] = 0;
				pos++;
			}
		}		
		return table; // returns the built table
	}
	/**
	 * Perform KMP substring search on the given text with the given pattern.
	 * 
	 * This should return the starting index of the first substring match if it
	 * exists, or -1 if it doesn't.
	 */
	public int search(String pattern, String text) {
		int s = 0; // position in string
		int t = 0; // current match in text
		int[] matchTable = buildTable(pattern); // build match table
		
		while( t+s < text.length() ){
			if( pattern.charAt(s) == text.charAt(t+s) ){
				s = s + 1;
				if( s == pattern.length() ){ return t; } // match found
			} else if ( matchTable[s] == -1 ){
				s = 0;
				t = t + s + 1;
			} else {
				t = t + s - matchTable[s];
				s = matchTable[s];
			}
		}
		return -1; // no match found
	}
}
