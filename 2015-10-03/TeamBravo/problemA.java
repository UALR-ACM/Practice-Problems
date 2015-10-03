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
		int num = Integer.parseInt(mrScan.nextLine());
		while (num > 0) {
			String input = mrScan.nextLine();
			String[] inputSplit = input.split(" ");
			String varX = inputSplit[0];
			String oper = inputSplit[1];
			String varY = inputSplit[2];
			String varZ = inputSplit[4];
			
			String validSolutions = "";
			for (int i = 1; i <= 36; i++) {
				int valX = conBase(varX, i);
				int valY = conBase(varY, i);
				int valZ = conBase(varZ, i);
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
				if (valid) {
					if (i >0 && i < 10)
						validSolutions += String.valueOf(i);
					else if (i >= 10 && i < 36)
						validSolutions += (char) ('a' + i - 10);
					else if (i == 36) 
						validSolutions += "0";
				}
			}
			if (validSolutions.length() == 0) {
				System.out.println("invalid");
			} else {
				System.out.println(validSolutions);
			}
			
			num--;
		}
	}

	private static int conBase(String varX, int base) {
		char[] cArray = varX.toCharArray();
		int result = 0;
		for (int i = 0; i < cArray.length; i++) {
			int curVal = -1;
			if (cArray[i] >= '0' && cArray[i] <= '9') {
				curVal = cArray[i] - '0';
			} else if (cArray[i] >= 'a' && cArray[i] <= 'z') {
				curVal = (cArray[i] - 'a') + 10;
			}
			if (curVal == -1)
				return -1;
			
			if (base == 1) {
				if (curVal != 1)
					return -1;
			} else {
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
