package Huawei;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumber {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number1 = sc.nextLine();
        String number2 = sc.nextLine();
        int[] a = new int[number1.length()];
        for(int i = 0; i < a.length; i++) {
        	a[i] = number1.charAt(i) - 48;
        }
        int[] b = new int[number2.length()];
        for(int i = 0; i < b.length; i++) {
        	b[i] = number2.charAt(i) - 48;
        }
        int[] result = bigNumberMultiply2(a, b);
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(result[i] == 0)
        			i++;
        while(i < result.length) {
        		str = str.append(result[i]);
        		i++;
        }
    
        System.out.print(str.toString());
    }
	
	public static int[] bigNumberMultiply2(int[] num1, int[] num2){
	    // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
	    int[] result = new int[num1.length + num2.length];
	    // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
	    for (int i = 0; i < num1.length; i++){
	        for (int j = 0; j < num2.length; j++){
	            result[i + j + 1] += num1[i] * num2[j];  // (因为进位的问题，最终放置到第i+j+1位)
	        }
	    }
	    //单独处理进位
	    for(int k = result.length-1; k > 0; k--){
	        if(result[k] > 10){
	            result[k - 1] += result[k] / 10;
	            result[k] %= 10;
	        }
	    }
	    return result;
	}
}
