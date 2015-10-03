import java.util.Scanner;


/**
 * Problem I 
 * Simons Says
 *
 */
public class problemI {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		while (num > 0) {
			String line = scan.nextLine();
			//If it's simon says, output line minus length of simon says.
			if (line.startsWith("Simon says ")) 
				System.out.println(line.substring("Simon says ".length()));
			num--;
		}
	}

}
