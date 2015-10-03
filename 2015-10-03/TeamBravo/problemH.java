import java.util.Scanner;


/**
 * Problem H 
 * Secret Message
 *
 */
public class problemH {

	public static void main(String[] args) {
		Scanner mrScan = new Scanner(System.in);
		int num = Integer.parseInt(mrScan.nextLine());
		while (num > 0) {
			String input = mrScan.nextLine();
			char[] cArray = input.toCharArray();
			int length = input.length();
			int rSize = (int) Math.ceil(Math.sqrt(length));
			int rTotal = (int) Math.pow(rSize, 2);
			char[][] message = new char[rSize][rSize];
			
			for (int i = 0; i < message.length; i++) {
				for (int j = 0; j < message[i].length; j++) {
					int curPos = (i*rSize + j);
					if (curPos > cArray.length-1) {
						message[i][j] = '*';
					} else {
						message[i][j] = cArray[curPos];
					}					
				}
			}
			for (int i = 0; i < message.length; i++) {
				for (int j = message.length-1; j >= 0; j--) {
					if (message[j][i] == '*')
						continue;
					System.out.print(message[j][i]);
				}
			}
			System.out.println();
			
			
			num--;
		}
	}

}
