package Huawei;
import java.util.*;


public class Jump {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(Jumper(a));
    }
    public static int Jumper(int[] a) {
    	if(a.length == 0)
    		return 0;
    	int[] step = new int[a.length];
    	for(int i = 1; i < a.length; i++) {
    		for(int j = 0; j < i; j++) {
    			if(j + a[j] >= i) {
    				step[i] = step[j] + 1;
    				break;
    			}
    		}
    	}
    	return step[step.length-1];
    }
}
