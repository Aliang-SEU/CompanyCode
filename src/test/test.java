package test;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int idx = s2.length();
		int sum = 0;
		while(idx <= s1.length()) {
			sum += difNum(s1.substring(idx - s2.length(), idx), s2);
			idx++;
		}
		System.out.println(sum);
	}
	static int difNum(String s1, String s2) {
		int sum = 0;
		for(int i = 0; i < s1.length(); ++i) {
			if(s1.charAt(i) != s2.charAt(i))
				sum++;
		}
		return sum;
	}
}
