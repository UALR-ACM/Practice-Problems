import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.Stack;


public class brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int open = 0;
		int close = 0;
		for (char c : line.toCharArray()) {
			if (c == '(')
				open++;
			else if (c == ')')
				close++;
		}
		Stack<Character> s = new Stack<Character>();
		if (Math.abs(open - close) == 0 || Math.abs(open - close) == 2) {
			if (isSolution(line)) {
				System.out.println("possible");
			} else {
				System.out.println("impossible");
			}
		} else {
			System.out.println("impossible");
		}
	}
	private static boolean isSolution(String line) {
		if (line.indexOf("()") > -1) {
			line = line.replaceFirst("\\(\\)", "");
			//System.out.println(line);
			return isSolution(line);
		}
		if (line.length() == 2) {
			return true;
		}
		if (line.length() == 0) {
			return true;
		}
		if (line.equals("))((")) {
			return true;
		}
		return false;
	}

}
