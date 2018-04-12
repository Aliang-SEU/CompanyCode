package test;
import java.util.*;

public class was{	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n =  scanner.nextInt();
		List<String> list = generate(n);	
		for(int i = 0; i < list.size(); i++) 
        {
            if(i != list.size() - 1)
                System.out.print(list.get(i) + ",");
            else
                 System.out.print(list.get(i));
        }
	}
	private static void helper(List<String> list, int left, int right, char[] buffer, int count) {
		if(left < 0 || right < left) {
			return ;
		}
		if(left == 0 && right == 0) {	
			String s = String.copyValueOf(buffer);
			list.add(s);
		}
		else {
			if(left > 0) {	
				buffer[count] = '(';
				helper(list, left - 1, right, buffer, count + 1);
			}
			if(right > left) {	
				buffer[count] = ')';
				helper(list, left, right - 1, buffer, count + 1);
			}
		}
	}
	public static List<String> generate(int count) {
		char[] buffer = new char[count * 2];
		List<String> list = new ArrayList<String>();
		helper(list, count, count, buffer, 0);
		return list;
	}
}

