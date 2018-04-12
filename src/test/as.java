package test;
import java.util.*;
public class as {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        int sum_a = 0;
        int sum_b = 0;
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            a.add(num);
            sum_a += num;
        } 
        for(int i = 0; i < m; i++){
            int num = sc.nextInt();
            b.add(num);
            sum_b += num;
        }
        int ans = 0;
        for(Iterator<Integer> iter = a.iterator(); iter.hasNext();) {
        	int i = iter.next();
            if((a.size() * i < sum_a) && (b.size() * i > sum_b)){
                iter.remove();
                sum_a -= i;
                b.add(i);
                sum_b += i;
                ans++;
                iter = a.iterator();
            }
        }
        for(Iterator<Integer> iter = b.iterator(); iter.hasNext();) {
           	int i = iter.next();
            if((b.size() * i < sum_b) && (a.size() * i > sum_a)){
                iter.remove();
                sum_b -= i;
                a.add(i);
                sum_a += i;
                ans++;
                iter = b.iterator();
            }
        }
        System.out.println(ans);
    }
}