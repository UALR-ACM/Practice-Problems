//auto-imported with Ctrl-Shift-o
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class KaneParity {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(new FileReader("parity.in"));

		while(in.hasNext()) {

			//get the next number
			String num = in.next();

			if(num.charAt(0) == '#'){ break;}

			//variables to fill in about the string
			int num_ones = 0;
			Boolean needs_even = false;

			//process the string by looping through the letters
			for(char digit: num.toCharArray()) {
				if(digit == '1') {
					num_ones += 1;
				}
				if(digit == 'e') {
					needs_even = true;
				}
			}

			Boolean is_even = num_ones %2 == 0;

			if(needs_even && is_even) {
				num = num.replace('e', '0');
			}
			if(needs_even && !is_even) {
				num = num.replace('e', '1');
			}
			if(!needs_even && is_even) {
				num = num.replace('o', '1');
			}
			if(!needs_even && !is_even) {
				num = num.replace('o', '0');
			}
			System.out.println(num);
		}
		in.close();
	}

}
