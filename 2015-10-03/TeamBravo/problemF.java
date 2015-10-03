import java.util.Scanner;



/**
 * Problem F
 * Quick Brown Fox
 *
 */
public class problemF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		while (num > 0) {
			String input = scan.nextLine();
			input = input.toLowerCase();
			boolean cArray[] = new boolean[26];
			for (int i = 0; i < 26; i++) {
				cArray[i] = true;
			}
			for (char c : input.toCharArray()) {
				int pos = (int) c;
				if (pos >= (int) 'a' && pos <= (int) 'z') {
					cArray[pos - 'a'] = false;
				}
			}
			String out = "";
			for (int i = 0; i < cArray.length; i++) {
				if (cArray[i]) {
					out += (char) (i + 'a');
				}
			}
			if (out.length() == 0) {
				System.out.println("pangram");
			} else {
				System.out.println("missing " + out);
			}
			
			num--;
		}
	}

}
