import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner mrScan = new Scanner(new File("input.txt"));
		while (mrScan.hasNext()) {
			String input = mrScan.nextLine();
			if (input.equals("#"))
				break;
			
			int i = 0;
			
			for (char c : input.toCharArray()) {
				if (c == '1')
					i++;
			}
			if (i % 2 == 0) {
				input = input.replace('e', '0');
				input = input.replace('o', '1');
			} else {
				input = input.replace('e', '1');
				input = input.replace('o', '0');
			}
			System.out.println(input);
				
			
		}
		mrScan.close();
		
	}

}

