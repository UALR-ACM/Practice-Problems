import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KaneGoldCoinsJava {
	public static int getRich(int n) {
		int pay = 1;
		int daysUntilPayIncrease = 1;
		int sum = 0;
		for(int days = 1; days <= n; days++) {
			sum += pay;
			daysUntilPayIncrease --;
			if(daysUntilPayIncrease == 0) {
				pay++;
				daysUntilPayIncrease = pay;
			}
		}
		return sum;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner meScanner = new Scanner(new File("GoldCoinsInput.txt"));
		while(meScanner.hasNextInt()) {
			int n = meScanner.nextInt();
			if(n == 0) {break;}
			System.out.println("" + n + " " + getRich(n));
		}
	}

}
