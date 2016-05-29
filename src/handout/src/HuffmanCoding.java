package handout.src;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

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
	private PriorityQueue<TreeNode> out;
	private TreeNode root;
	
	public HuffmanCoding(String text) {
		// create the character frequency map
		charFreq = calcFrequency(text);
		// create the queue of characters
		out = buildQueue(charFreq);
		// build a hoffman tree from the queue
		root = buildTree(out);
		
		
		/* FOR TESTING & DEBUGGING
		// print each characters frequency
		int count = 0;
		for(Map.Entry<Character, Integer> en : charFreq.entrySet()){
			System.out.println(en.getKey() + " : " + en.getValue());
			count++;
		}
		// print the number of unique characters
		System.out.println("Character count : " + count);
		
		// prints each node value as polled off the queue
		while(!out.isEmpty()){
			TreeNode tn = out.poll();
			System.out.println("Node : " + tn.data + "  f: " + tn.frequency);		 
		}
		
		printTree(root);
		*/
	}  
	
	/** Simply prints the tree recursively 
	 *   starting from the root node
	 * 
	 * @param root
	 */
	private void printTree(TreeNode root) {
		if(root.data != '#'){
			System.out.println(root.data);
		} else {
			System.out.println(root.frequency);
			printTree(root.left);
			printTree(root.right);
		}

	}
	
	/** Takes a map from character to frequency
	 *   and returns a priority queue with the lowest 
	 *   frequency characters having the highest priority
	 */
	private PriorityQueue<TreeNode> buildQueue(HashMap<Character, Integer> in) {
		// create empty queue
		PriorityQueue<TreeNode> res = new PriorityQueue<TreeNode>();
		// create a tree node for each character in map
		// assigning the frequency of the character for the priority
		for(Entry<Character, Integer> e: in.entrySet()){
			TreeNode t = new TreeNode(e.getKey());
			t.setFreq(e.getValue());
			res.add(t);
		}
		// return the queue
		return res;
	}
	
	/** Builds a Hoffman tree from a priority 
	 *   queue of tree nodes taken as the input
	 *   parameter  
	 * 
	 * @param out
	 * @return root node
	 */
	private TreeNode buildTree(PriorityQueue<TreeNode> out){
		
		TreeNode root = null;
		// while the queue isnt empty, build the tree
		while(!out.isEmpty()){
			TreeNode t1 = out.poll();
			TreeNode t2 = null;
			if(!out.isEmpty()){
				t2 = out.peek();
				if(root==null || root.getFreq() <= t2.getFreq()) t2 = out.poll();
				else {
					t2 = root;
				}
			} else {
				t2 = root;
			}			
			TreeNode tn = new TreeNode('#');
			tn.left = t1;
			tn.right = t2;
			int f1 = t1.getFreq();
			int f2 = t2.getFreq();
			int nFeq = (f1 + f2);
			tn.setFreq(nFeq);
			// root now equals this node
			root = tn;
		}
		return root;
		
	}
	
	public void ExpandBinaryPaths(TreeNode node, String prefix){
		if(node == null){ 
			return;
		} else {
			StringBuilder sb = new StringBuilder(prefix);
			node.setCode(sb.toString());
			ExpandBinaryPaths(node.getLeft(), sb.append('0').toString());
			ExpandBinaryPaths(node.getRight(), sb.append('1').toString());
			return;
		}
	}
	
	/** Calculates the frequency of characters in a given string.
	 * 	returns a map from unique characters to their counts within
	 *  the text.
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
		StringBuilder sb = new StringBuilder();
		int size = text.length();
		for(int i=0; i<size; i++){
			char in = text.charAt(i);
		}
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
	
	
	public class TreeNode implements Comparable<TreeNode>{
		
		private final char data;
		private int frequency = 0;
		private String Code = "";

		private TreeNode parent;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(char data){
			this.data = data;
		}
		
		public String getCode() {
			return Code;
		}

		public void setCode(String code) {
			Code = code;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setParent(TreeNode parent) {
			this.parent = parent;
		}
		public TreeNode getParent() {
			return parent;
		}
		public char getData(){
			return data;
		}	
		public void setFreq(int freq){
			frequency = freq;
		}
		public int getFreq(){
			return this.frequency;
		}

		@Override
		public int compareTo(TreeNode o) {
			if(this.frequency <= o.getFreq()){
				return -1; // want the smaller frequency first
			} else if(this.frequency == o.getFreq()){
				return 0; // equals frequency
			} else {
				return 1; // this is a greater priority node
			}
		}
	}
	
}

