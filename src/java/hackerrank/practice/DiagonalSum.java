/**
 * 
 */
package hackerrank.practice;


import java.util.Scanner;

public class DiagonalSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        long primarySum = 0;
        long secondarySum = 0;
        for(int index=0; index < n; index++){
            primarySum += a[index][index];
            secondarySum += a[index][n-(index+1)];   
        }
        System.out.println(Math.abs(primarySum-secondarySum));
    }
}

