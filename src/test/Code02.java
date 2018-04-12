package test;

import java.util.Scanner;

public class Code02 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans = 0, ans1 = 0;
        for(int y = k + 1; y <= n; ++y){
        	//ans += (n) / (y - 1) * (y - k);
        	//for(int i = 1; i <= y - k; ++i)
        		//ans +=  (n + i) / y;

        	for(int j = k - 1, t = y - 1; j <= n; j += y, t = Math.min(t+y, n)) 
			ans1 += (t - j);
        }
        System.out.println(ans + " " + ans1);
    }
}
