import java.io.*;
import java.util.*;

public class small_risk_trading {

    public static void main(String[] args) {
        int n, k;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        
        double successes[] = new double[n];
        double maxProfits[] = new double[n];
        double losses[] = new double[n];
        
        for (int i = 0; i < n; i++) { successes[i] = scan.nextDouble(); }
        for (int i = 0; i < n; i++) { maxProfits[i] = scan.nextDouble(); }
        for (int i = 0; i < n; i++) { losses[i] = scan.nextDouble(); }

        ArrayList<Double> profits = new ArrayList<Double>();
        
        for (int i = 0; i < n; i++) {
            profits.add(successes[i] * maxProfits[i] - (1 - successes[i]) * losses[i]);
        }
        
        double maximum = 0;
        
        for (int i = 0; i < k; i++) {
            double m = Collections.max(profits);
            if (m < 0)
                break;
            
            profits.remove(m);
            maximum += m;
        }
        
        System.out.printf("%.2f", maximum);
    }
}

