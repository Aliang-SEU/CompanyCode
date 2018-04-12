package test;

public class ssss {
	public static void main(String[] args) {
		check("abbcccddeefffgggcc",2);
	}
	public static void check(String s, int n) {
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length;) {
			char ch = c[i];
			int num = 1, j = i;
			while(++j < c.length) {
				if(c[j] != ch)
					break;
				num++;
			}
			if(num == n)
				System.out.println("(" + (i + 1) + "," + j + "," + s.substring(i, j) + ")");
			i = j;
		}
	}
}
