import java.util.Arrays;
import java.util.Scanner;


/**
 * Problem A
 * All about that base
 *
 */
public class problemA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner mrScan = new Scanner(System.in);

		//Grab number of inputs
		int num = Integer.parseInt(mrScan.nextLine());

		//While we still have more inputs to grab..
		while (num > 0) {

			//Get the next line, then split it into each part of a solution
			// X oper Y = Z
			// 0  1   2   4
			String input = mrScan.nextLine();
			String[] inputSplit = input.split(" ");
			String varX = inputSplit[0];
			String oper = inputSplit[1];
			String varY = inputSplit[2];
			String varZ = inputSplit[4];
			

			//Initiatilize empty solution answer
			String validSolutions = "";
			for (int i = 1; i <= 36; i++) {

				//Convert each solution into the respective base
				int valX = conBase(varX, i);
				int valY = conBase(varY, i);
				int valZ = conBase(varZ, i);

				//If any of them don't work, skip this base
				if (valX == -1 || valY == -1 || valZ == -1)
					continue;
				
				boolean valid = false;
				switch(oper) {
				case "+":
					valid = (((double) valZ) == (((double) valX) + ((double) valY)));
					break;
				case "-":
					valid = (((double) valZ) == (((double) valX) - ((double) valY)));
					break;
				case "*":
					valid = (((double) valZ) == (((double) valX) * ((double) valY)));
					break;
				case "/":
					valid = (((double) valZ) == (((double) valX) / ((double) valY)));
					break;
				}

				//If it's valid, we need to convert int to the letter corresponding to the correct base.
				if (valid) {
					if (i > 0 && i < 10)
						validSolutions += String.valueOf(i);
					else if (i >= 10 && i < 36)
						validSolutions += (char) ('a' + i - 10);
					else if (i == 36) 
						validSolutions += "0";
				}
			}

			//If we didn't find anything, say invalid, otherwise print solution.
			if (validSolutions.length() == 0) {
				System.out.println("invalid");
			} else {
				System.out.println(validSolutions);
			}
			
			//Decrement to account for next input.
			num--;
		}
	}

	private static int conBase(String varX, int base) {
		//Split the string into characters
		char[] cArray = varX.toCharArray();

		//Initialize result at 0
		int result = 0;
		for (int i = 0; i < cArray.length; i++) {
			int curVal = -1;
			//Convert from character to it's integer representation.
			if (cArray[i] >= '0' && cArray[i] <= '9') {
				curVal = cArray[i] - '0';
			} else if (cArray[i] >= 'a' && cArray[i] <= 'z') {
				curVal = (cArray[i] - 'a') + 10;
			}

			//If that didn't work for some reason, return invalid.
			if (curVal == -1)
				return -1;
			
			//Base 1 is special case
			if (base == 1) {
				if (curVal != 1)
					return -1;
			} else {
				//If the curVal is greater than the current base, it can't be part of it.
				if (curVal > base-1) {
					return -1;
				}
			}
			int pos = cArray.length - i - 1;
			result += curVal * Math.pow(base,pos);
		}
		return result;
	}

}
