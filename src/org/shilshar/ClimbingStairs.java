package org.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClimbingStairs {
    /*
     * Complete the function below.
     */

             static long get_ways(int n) {
                BigInteger ways = BigInteger.ONE;
                if (n==1)
                    return ways.longValue();
                
                // This forms a tree where 1 branch is the 2-step path and the other is the 1-step path.
                // If we draw such a tree we can see that at each level we add the branches at the levels below.
                // Eg. if n is 6, then one branch is for 5 steps and the other is for 4
                // So we could start by computing the number of paths at the lowest level (1)
                // and then each level above is the sum of the 2 branches below
                BigInteger prev_ways = BigInteger.ONE;
                BigInteger temp = ways; //temporary variable for holding the previous value of ways (one level below)
                for (int i=1; i<n; i++){
                    temp = ways;
                    ways = ways.add(prev_ways);
                    prev_ways = temp; //the old value of ways becomes the prev_ways now                
                }
                BigInteger bi = BigInteger.TEN.pow(9);
                return ways.mod(bi).longValue();
            }
             
         public static void main(String[] args) throws IOException{
                 Scanner in = new Scanner(System.in);
                 long res;
                 int _n;
                 _n = Integer.parseInt(in.nextLine().trim());
                 
                 res = get_ways(_n);
                 System.out.println(String.valueOf(res));
             }
 }
