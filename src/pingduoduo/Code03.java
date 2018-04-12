package pingduoduo;

import java.util.Scanner;

public class Code03 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = Integer.parseInt(sc.nextLine());
	        int[][] data = new int[n][2];
	        String[] in = null;
	        for (int i = 0; i < n; ++i) {
	            in = sc.nextLine().split(" ");
	            data[i][0] = Integer.parseInt(in[0]);
	            data[i][1] = Integer.parseInt(in[1]);
	        }
	        System.out.println(help(n, data));
	    }

	    public static int help(int n, int[][] data) {
	        double eps = 0.00001;
	        int count = 0;
	        double a = 0;
	        double b = 0;
	        double c = 0;
	        for (int i = 0; i < n; ++i) {
	            for (int j = i + 1; j < n; ++j) {
	                for (int k = j + 1; k < n; ++k) {
	                    if((data[i][1] - data[j][1]) == 0){
	                        a = Double.MAX_VALUE;
	                    }else{
	                        a = (double)(data[i][0] - data[j][0])/(data[i][1] - data[j][1]);
	                    }

	                    if(data[i][1] - data[k][1] == 0){
	                        b = Double.MAX_VALUE;
	                    }else{
	                        b = (double)(data[i][0] - data[k][0])/(data[i][1] - data[k][1]);
	                    }

	                    if (data[k][1] - data[j][1] == 0) {
	                        c = Double.MAX_VALUE;
	                    }else{
	                        c = (double)(data[k][0] - data[j][0])/(data[k][1] - data[j][1]);
	                    }

	                    if(!(Math.abs(a - b) < eps) && !(Math.abs(a - c) < eps) && !(Math.abs(b - c) < eps) ){
	                        count++;
	                    }
	                }
	            }
	        }
	        return count;
	    }
}
