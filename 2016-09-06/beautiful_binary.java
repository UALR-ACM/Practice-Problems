// HackerRank Problem: https://www.hackerrank.com/challenges/beautiful-binary-string

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        scan.next();
        
        while (scan.hasNext()) {
            String scanned = scan.next();
            int i = 0;
            while (scanned.indexOf("010") > -1) {
                i++;
                scanned = scanned.replaceFirst("010","111");
            }
            System.out.println(i);
        }
    }
}