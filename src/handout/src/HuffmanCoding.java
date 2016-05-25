package handout.src;
import java.util.HashMap;
import java.util.Map;

/**
 * A new instance of HuffmanCoding is created for every run. The constructor is
 * passed the full text to be encoded or decoded, so this is a good place to
 * construct the tree. You should store this tree in a field and then use it in
 * the encode and decode methods.
 */
public class HuffmanCoding {
	/**
	 * This would be a good place to compute and store the tree.
	 */
	
	private final HashMap<Character, Integer> charFreq;
	
	public HuffmanCoding(String text) {
		// create the character frequency map
		charFreq = calcFrequency(text);
		// print each characters frequency
		int count = 0;
		for(Map.Entry<Character, Integer> en : charFreq.entrySet()){
			System.out.println(en.getKey() + " : " + en.getValue());
			count++;
		}
		// print the number of unique characters
		System.out.println("Character count : " + count);
	}
	
	/* Calculates the frequency of characters in a given string.
	 * 	returns a map from unique characters to there counts.
	 */
	private HashMap<Character,Integer> calcFrequency(String text) {
		// creates empty map
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		// iterates over each character in text 
		for(int i = 0; i < text.length(); i++){
		   char c = text.charAt(i);
		   Integer val = map.get(new Character(c));
		   // keeps a count of the number of instances
		   // of each character seen
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c,1);
		   }
		}
		// return the frequency map
		return map;
	}

	/**
	 * Take an input string, text, and encode it with the stored tree. Should
	 * return the encoded text as a binary string, that is, a string containing
	 * only 1 and 0.
	 */
	public String encode(String text) {
		// TODO fill this in.
		return "";
	}

	/**
	 * Take encoded input as a binary string, decode it using the stored tree,
	 * and return the decoded text as a text string.
	 */
	public String decode(String encoded) {
		// TODO fill this in.
		return "";
	}

	/**
	 * The getInformation method is here for your convenience, you don't need to
	 * fill it in if you don't wan to. It is called on every run and its return
	 * value is displayed on-screen. You could use this, for example, to print
	 * out the encoding tree.
	 */
	public String getInformation() {
		return "";
	}
	
	/* Unused TreeNode class
	public class TreeNode implements Comparable<TreeNode>{
		
		private final char data;
		private int frequency = 0;
		
		public TreeNode(char data){
			this.data = data;
		}
		
		public void incFreq(){
			frequency++;
		}

		@Override
		public int compareTo(TreeNode o) {
			return 0;
		}
	}
	*/
}

