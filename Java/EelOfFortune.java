// https://www.reddit.com/r/dailyprogrammer/comments/3ddpms/20150715_challenge_223_intermediate_eel_of_fortune/
import java.util.Hashtable;

class EelOfFortune {

	public static final int ALPHATBET_SIZE = 26;
	public static final int ASCII_BASE_OFFSET = 97;

	public static void main(String[] args) {

		System.out.println(isProblemWord("synchronized", "snond")); //true
		System.out.println(isProblemWord("misfunctioned", "snond")); //true
		System.out.println(isProblemWord("mispronounced", "snond")); //false
		System.out.println(isProblemWord("shotgunned", "snond")); //false
		System.out.println(isProblemWord("snond", "snond")); //true
	}

	public static boolean isProblemWord(String fullWord, String problemWord) {
		char[] fullWordAsArray = fullWord.toLowerCase().toCharArray();
		char[] problemWordAsArray = problemWord.toLowerCase().toCharArray();

		Hashtable<String,Integer> fullWordCounts = new Hashtable<String,Integer>();
		Hashtable<String,Integer> problemWordCounts = new Hashtable<String,Integer>();

		int problemWordChar = 0;

		// First get the letter counts of all the letters in the problemWord
		for ( char currentProblemWordChar : problemWordAsArray ) {
			problemWordCounts = incrementValue(currentProblemWordChar, problemWordCounts);
		}

		// Check order in the full word and get the counts
		for ( char currentFullWordChar : fullWordAsArray ) {
			fullWordCounts = incrementValue(currentFullWordChar, fullWordCounts);

			if ( problemWordCounts.containsKey(String.valueOf(currentFullWordChar)) 
				&& fullWordCounts.get(String.valueOf(currentFullWordChar)) > problemWordCounts.get(String.valueOf(currentFullWordChar)))
				return false;

			if ( currentFullWordChar == problemWordAsArray[problemWordChar] ) 
				problemWordChar++;
		}

		// Check to make sure the letters appear the correct number of times
		for ( char currentProblemWordChar : problemWordAsArray ) {
			if ( fullWordCounts.containsKey(String.valueOf(currentProblemWordChar)) 
				&& (fullWordCounts.get(String.valueOf(currentProblemWordChar)) != problemWordCounts.get(String.valueOf(currentProblemWordChar))) ) 
				return false;
		}

		if ( problemWordChar == problemWordAsArray.length )
			return true;
		else 
			return false;		
	}

	private static Hashtable<String, Integer> incrementValue(char value, Hashtable<String, Integer> table) {
		if ( table.containsKey(String.valueOf(value)) )
			table.put(String.valueOf(value), (table.get(String.valueOf(value)) + 1));
		else 				
			table.put(String.valueOf(value), 1);		

		return table;
	}
}