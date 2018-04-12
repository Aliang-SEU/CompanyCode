package test;

public class Code04 {
	public static double countPorb(int n, int m){
	    if(n < 1)
	        return 0.0d;
	    if(m < n || m > 6 * n)
	        return 0.0d;
	        
	    int[][] count = new int[n][6 * n];
	    
	    for(int i = 0; i < 6; ++i){
	        count[0][i] = 1;
	    }
	    
	    int num = 6 * n;
	    for(int i = 1; i < n; ++i){
	        for(int j = i; j < num; ++j){
	          for(int k = 1; k <= 6; ++k){
	              if(j - k >= 0)
	                  count[i][j] += count[i - 1][j - k];
	          }
	        }
	    }
	    return count[n - 1][m - 1] / Math.pow(6, n);
	}
	
	public static void main(String[] args) {
		
		System.out.println(countPorb(6, 6));
	}
}
