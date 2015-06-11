// http://www.reddit.com/r/dailyprogrammer/comments/38yy9s/20150608_challenge_218_easy_making_numbers/
import java.util.Scanner;

class MakingNumberPalindromic {

	public static void main(String[] args) {

		int value = 0;
		int counter = 0;
		int originalVal = 0;

		// Get single argument 
		if (args.length != 1 && args[0] != null) {
			System.out.println("Requires one (number) argument");
			System.exit(0);
		} else {
			value = Integer.parseInt(args[0]);
			originalVal = value;
		}

		// Until its palendromic, reverse and add
		while(!isPalindromic(value)) {
			value += reverseInt(value);
			counter++;
		}

		System.out.println(originalVal + " gets palindromic after " + counter + " steps: " + value);
	}

	// Reverses an integer
	public static int reverseInt(int currentNumber) {

		char[] numberAsCharArray = getIntegerAsCharArray(currentNumber);

		char temp = '0';
		int switchValue = -1;

		// Reverse the number digit by digit
		for (int current = 0; current < Math.floor(numberAsCharArray.length/2); current++) {
			switchValue = (numberAsCharArray.length - current - 1);
			temp = numberAsCharArray[current];
			numberAsCharArray[current] = numberAsCharArray[switchValue];
			numberAsCharArray[switchValue] = temp;
		}

		return Integer.parseInt(new String(numberAsCharArray));
	}

	// Checks if the number is a palindrone 
	public static boolean isPalindromic(int currentNumber) {

		char[] numberAsCharArray = getIntegerAsCharArray(currentNumber);
		int compareValue = -1;

		// Check for each digit from back/front to middle
		for (int current = 0; current < Math.floor(numberAsCharArray.length/2); current++) {
			compareValue = (numberAsCharArray.length - current - 1);
			if (numberAsCharArray[current] != numberAsCharArray[compareValue])
				return false;
		}		

		return true;
	}

	// Takes a number and converts it to a char array
	public static char[] getIntegerAsCharArray(int number) {
		return Integer.toString(number).toCharArray();
	}

}