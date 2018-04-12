package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;


public class tt {

    private static final String carSplit =";";
    private static final String timeSplit =",";
    private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";
    
    
    public static void main(String[] args) {
        String inString = null;
        // ��������
        Scanner in = new Scanner(System.in);
        inString = in.nextLine();
        //�ַ��������ʽУ��
        Pattern pat = Pattern.compile(regress);
        if(inString == null || inString.trim().equals("")||!pat.matcher(inString).matches()){
            System.out.println("�������!");
            return;
        }
        tt sol = new tt();
        int[][] a  = sol.convertToArray(inString);
        Arrays.sort(a, new Comparator<Object>() {
        	@Override
        	public int compare(Object a, Object b) {
        		int[] x = (int[]) a;
        		int[] y = (int[]) b;
        		
        		if(x[0] < y[0])
        			return 1;
        		else if(x[0] > y[0])
        			return -1;
        		else 
        			return 0; 
        				
        	}
        });
        int countCars = sol.countCars(sol.convertToArray(inString));
        System.out.println(countCars);
    }

    //�����ַ���ת����
    public int[][] convertToArray(String str) {
        String[] strArray = str.split(carSplit);
        int row = strArray.length;
        int col = 2;
        // �ַ�ת�����ж�
        int[][] carArray = new int[row][col];
        int start,end;
        for (int i = 0; i < row; i++) {
            start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
            end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
            if(start>end){
                continue;
            }
            carArray[i][0] = start;
            carArray[i][1] = end;
        }
        return carArray;
    }

    //�����㷨ʵ��
    public int countCars(int[][] carArray) {
        int ans = 0;
        for(int i = 0; i < carArray.length; ++i) {
        	int temp = 1;
        	for(int j = 1; j < carArray.length; ++j) {
        		if(((carArray[i][0] <= carArray[j][0]) && (carArray[j][0] < carArray[i][1]))||((carArray[i][0] >= carArray[j][0]) && (carArray[j][1] > carArray[i][0])))
        			temp++;
        		if(temp > ans)
        			ans = temp;
        	}
        }
        return ans; // ���ؼ�����
    }
}