package MicroSoft;

import java.util.Scanner;

public class Question01 {
	public static void main(String[] args) {
		System.out.println(annoncement(8,"nnnnnnnn"));
	}
    public static String annoncement(int numOfNeighbors, String characteristic)
    {
    	if(numOfNeighbors == 1)
    		return "I";
    	int max = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < numOfNeighbors; ++i){
    	    sb.append('U');
    	}
        for(int idx = 0; idx < numOfNeighbors; ++idx) {
        	if(characteristic.charAt(idx) == 'n')
        		continue;
        	boolean[] result = new boolean[numOfNeighbors];
        	int startIdx = idx;
        	int informNum = 2;
        	result[idx] = true;
        	int leftNum = informNum, rightNum = informNum;
        	int leftIdx = startIdx - 1, rightIdx = startIdx + 1;
        	
        	while(leftIdx >= 0 && leftNum > 0) {
        		if(characteristic.charAt(leftIdx) == 'n') {
        			result[leftIdx--] = true;
        			leftNum--;
        			leftIdx--;
        		}else {
        			result[leftIdx--] = true;
        			leftNum = informNum;
        			leftIdx--;
        		}
        	}
        	while(rightIdx < numOfNeighbors && rightNum > 0) {
        		if(characteristic.charAt(rightIdx) == 'n') {
        			result[rightIdx++] = true;
        			rightNum--;
        		}else {
        			result[rightIdx++] = true;
        			rightNum = informNum;
        		}
        	}
        	int sum = 0;
        	for(int i = 0; i < result.length; ++i) {
        		if(result[i] == true) {
        			sum++;
        		}
        	}
        	//大于直接赋值
        	  //取字典顺序最小的
        	if(sum == max) {
        		StringBuilder tempSb = new StringBuilder();
            	for(int i = 0; i < result.length; ++i) {
            		if(result[i] == true)
            			tempSb.append('I');
            		else
            			tempSb.append('U');
            	}
            	if(sb.toString().compareTo(tempSb.toString()) > 0)
            		sb = tempSb;
        	}
        	//大于直接赋值
        	else if(sum > max) {
        	    max = sum;
        		sb = new StringBuilder();
            	for(int i = 0; i < result.length; ++i) {
            		if(result[i] == true)
            			sb.append('I');
            		else
            			sb.append('U');
            	}
        	}
        }
        return sb.toString();
    }

}
