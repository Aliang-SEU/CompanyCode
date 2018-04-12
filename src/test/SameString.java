package test;
import java.util.*;

public class SameString {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String str = sc.next();
	        
	        for(int i = str.length() / 2; i > 0; i--) {
	        	if(str.length() % i == 0) {
	        		int repeatNumber = str.length() / i;
	        		String subStr = str.substring(0, i);
	        		boolean same = true;
	        		for(int j = 1; j < repeatNumber; ++j) {
	        			if(!str.substring(j*i, (j+1)*i).equals(subStr)) {
	        				same = false;
	        				break;
	        			}
	        		}if(same == true) {
	    				System.out.println(subStr);
	    				return;
	        		}
	        	}
	        }
	        System.out.println("false");
	    }
}
