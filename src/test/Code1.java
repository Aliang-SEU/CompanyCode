package test;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Pair<E extends Object, F extends Object>{
	E first;
	F second;
	
	public E getFirst() {
		return first;
	}
	public void setFirst(E first) {
		this.first = first;
	}
	public F getSecond() {
		return second;
	}
	public void setSecond(F second) {
		this.second = second;
	}
	Pair(E first, F second){
		this.first = first;
		this.second = second;
	}
}
public class Code1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int H = sc.nextInt();
		
		int[] a = new int[N];
		for(int i = 0; i < N; ++i) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		
		LinkedList<AbstractMap.SimpleEntry<Integer, Integer> > queue = new LinkedList<>();
		queue.push(new AbstractMap.SimpleEntry<Integer, Integer>(0,K));
		int max = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				AbstractMap.SimpleEntry<Integer, Integer> pair = queue.poll();
				max = Math.max(max, pair.getKey());
				if(pair.getValue() > 0 ) {
					for(int i = 0; i < a.length; ++i) {
						if( Math.abs(pair.getKey() - a[i]) <= H) {
							if(pair.getKey() + 2 * (a[i] - pair.getKey()) >= 0)
								queue.push(new AbstractMap.SimpleEntry<Integer, Integer>(pair.getKey() + 2 * ( a[i] - pair.getKey()), pair.getValue() - 1));
						}
					}
				}
				
			}
		}
		System.out.println(max);
		
	}
}
