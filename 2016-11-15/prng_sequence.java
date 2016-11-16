import java.io.*;
import java.util.*;
import java.util.Random;

public class prng_sequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int t = 0; t < cases; t++) {
            long stamp1 = sc.nextInt();
            long stamp2 = sc.nextInt();
            Random r = new Random();

            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = sc.nextInt();
            }
            
            for (long i = stamp1; i < stamp2; i++) {
                r.setSeed(i);
                int[] future = new int[10];
                boolean failed = false;
                for (int j = 0; j < 10; j++) {
                    if (r.nextInt(1000) != nums[j]) {
                        failed = true;
                        break;
                    }
                }
                if (!failed) {
                    System.out.print(i);
                    System.out.print(" ");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(r.nextInt(1000));
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;
                }
            }
        }
    }
}