package test;

import java.util.Scanner;

public class asd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        System.out.println(dp[n]);
    }
}