package test;
import java.util.*;
public class code {
    public static void rotate(int[][] matrix) 
    {
        if(matrix==null||matrix[0].length==0)
            return;
        int len = matrix.length / 2;
        for(int i = 0;i < len;i++)
        {
            for(int j = 0;j<matrix[0].length;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
        
        for(int i = 0;i<matrix.length;i++)
        {
            for(int j = i+1;j<matrix[0].length;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public static void  main(String[] args)
    {
    	Scanner scanner = new Scanner(System.in);
    	ArrayList<String> list = new ArrayList<>();
    	String s = scanner.nextLine();
    	list.add(s);	
    	int len = s.split(" ").length;
    	while(len-- > 1 && scanner.hasNextLine())
    	{
    		String str = scanner.nextLine();
    		list.add(str);	
    	}
    	int n = list.size();
    	int[][] array = new int[n][n];
    	for(int i = 0;i<n;i++)
    	{
    		String[] str = list.get(i).split(" ");
    		for(int j = 0;j<n;j++)
    		{
    			array[i][j] = Integer.valueOf(str[j]);
    		}
    	}
    	rotate(array);
    	for(int i = 0;i<n;i++)
    	{
    		for(int j = 0;j<n;j++)
    		{
    			if(j!=n-1)
    			System.out.print(array[i][j]+" ");
    			else {
					System.out.print(array[i][j]);
				}
    		}
    		System.out.println();
    	}
    }
	
}

