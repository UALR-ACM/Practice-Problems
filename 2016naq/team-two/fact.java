import java.math.BigInteger;
import java.util.Scanner;


public class fact {

	public static void main(String[] args) {
		Scanner mrScan = new Scanner(System.in);
		
		String bigInt = mrScan.nextLine();
		long l = System.currentTimeMillis();
		BigInteger b = new BigInteger(bigInt);
		
		int i = 1;
		while (true) {
			b = b.divide(BigInteger.valueOf(i));
			System.out.println(b.toString());
			if (b == BigInteger.valueOf(1) || b == BigInteger.valueOf(0)) {
				break;
			}
			i++;
		}
		System.out.println(i-1);
		System.out.println(System.currentTimeMillis() - l);
	}

}
