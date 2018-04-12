package Huawei;
import java.util.*;
import java.util.Map.Entry;


public class ReOrderString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if(map.containsKey(ch))
        		map.put(ch, map.get(ch) + 1);
        	else
        		map.put(ch, 1);
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
	        for(Entry<Character, Integer> iter : map.entrySet()) {
	        	if(iter.getValue() > 0) {
	        		sb.append(iter.getKey());
	        		iter.setValue(iter.getValue() - 1);
	        	}
	        }
        }
        System.out.println(sb.toString());
    }
}
