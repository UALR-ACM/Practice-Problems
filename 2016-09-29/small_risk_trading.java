import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        int n, k;
//        Scanner scan = new Scanner(new FileReader("input1.txt"));
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();

        double successes[] = new double[n];
        double maxProfits[] = new double[n];
        double losses[] = new double[n];

        for (int i = 0; i < n; i++) {
            successes[i] = scan.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            maxProfits[i] = scan.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            losses[i] = scan.nextDouble();
        }

        ArrayList<Double> profits = new ArrayList<Double>();

        for (int i = 0; i < n; i++) {
            profits.add(successes[i] * maxProfits[i] - (1 - successes[i]) * losses[i]);
        }

        // Java 8 stream approach
        double sum = profits
                .stream()
                .filter(s -> s > 0) //only keep the positive profits
                .sorted(Collections.reverseOrder())
                .limit(k)
                .mapToDouble(Double::doubleValue) // only primitive values can be summed?
                .sum();
        System.out.printf("%.2f", sum);
    }
}
