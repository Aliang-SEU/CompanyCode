package test;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();
        int[] len = new int[N];
        for(int i = 0; i < N; ++i){
            len[i] = sc.nextInt();
        }
        
        int[] high = new int[K + 1];
        high[0] = 0;

        for(int i = 1; i <= K; ++i){
            high[i] = high[i-1] + 2 * (len[maxHigh(len, high[i-1], H)] - high[i-1]);
        }
        
        System.out.println(high[K]);
    }
    public static int maxHigh(int[] a, int hi, int H){
        int j = 0;
        int max = a[0] - hi;
        for(int i = 1; i < a.length; ++i){
            int dif = a[i] - hi;
            if(dif <= H && dif >0){
                if(dif > max){
                    max = dif;
                    j = i;
                }
            }
        }
        return j;
    }
}