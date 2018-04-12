package pingduoduo;

import java.util.HashMap;
import java.util.Scanner;

public class Code02 {
	static class Pair{
		public int x;
		public int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Pair o = (Pair) obj;
			if(this.x * o.y == this.y * o.x)
				return true;
			else
				return false;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			  String str=String.valueOf(x)+String.valueOf(y);
		      return str.hashCode();      
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] axis = new int[n][2];
		for(int i = 0; i < n; ++i) {
			axis[i][0] = sc.nextInt();
			axis[i][1] = sc.nextInt();
		}
		int res = 0;
		for(int i = 0; i < n - 2; ++i) {
			HashMap<Pair,Integer> map = new HashMap<>();
			int num = 0;
			int pSum = 0;
			for(int j = i + 1; j < n; ++j) {
				int y =  axis[j][1] - axis[i][1];
				int x =  axis[j][0] - axis[i][0];
				int d = gcd(x, y);
				x /= d;
				y /= d;
				if(x == 0 && y < 0) {
					y = -y;
				}
				else if(y == 0 && x < 0) {
					x = -x;
				}
				else if(x < 0) {
					x = -x;
					y = -y;
				}
				Pair pair = new Pair(x, y);
				if(map.isEmpty()) {
					map.put(pair, 1);
					pSum++;
					continue;
				}
				if(map.containsKey(pair)) {
					num += pSum - map.get(pair);
					map.put(pair, map.get(pair) + 1);
				}else {
					map.put(pair, 1);
					num += pSum;
				}
				pSum++;
			}
			res += num;
		}
		System.out.println(res);
	}
	public static int gcd(int m,int n) {
		  if(n ==0 || m ==0)
			return 1;
		  if (m % n == 0) 
			  return n;
		  else 
			  return gcd(n,m % n);
	}
}	
