package ALiBaBa;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
class Tool {
	//数字位
	public static String[] chnNumChar = {"零","一","二","三","四","五","六","七","八","九"};
	public static char[] chnNumChinese = {'零','一','二','三','四','五','六','七','八','九'};
	//节权位
	public static String[] chnUnitSection = {"","万","亿","万亿"};	
	//权位
	public static String[] chnUnitChar = {"","十","百","千"};
	public static HashMap intList = new HashMap();
	static{
		for(int i=0;i<chnNumChar.length;i++){
			intList.put(chnNumChinese[i], i);
		}
		
		intList.put('十',10);
		intList.put('百',100);
		intList.put('千', 1000);
	}
	
}
public class Solution
{
	private static final int g_maxValue = 6;
	 public static void main(String[] args)
	    {
	//	 System.out.println(getNum(new int[]{2,2},0));
		 StringBuilder sb = new StringBuilder();
		 String s = numberToChinese(100210021);
		 if(s.length() > 10) {
			 for(int i = 0; i < s.length(); i++) {
				 if(s.charAt(i) == '万' || s.charAt(i) == '亿') {
					 sb.append(s.charAt(i)); sb.append(',');
				 }
				 
				 else
					 sb.append(s.charAt(i));
				 
			 }
		 }else {
			 for(int i = 0; i < s.length(); i++) {
					 sb.append(s.charAt(i));
			 }
		 }
		 	System.out.println(sb.toString());
	    }

	 public static String sectionTOChinese(int section,String chineseNum){
			String setionChinese = new String();//小节部分用独立函数操作
			int unitPos = 0;//小节内部的权值计数器
			boolean zero = true;//小节内部的制零判断，每个小节内只能出现一个零
			while(section>0){
				int v = section%10;//取当前最末位的值
				if(v == 0){
					if( !zero ){
						zero = true;//需要补零的操作，确保对连续多个零只是输出一个
						chineseNum = Tool.chnNumChar[0] + chineseNum;
					}
				}else{
					zero = false;//有非零的数字，就把制零开关打开
					setionChinese = Tool.chnNumChar[v];//对应中文数字位
					setionChinese = setionChinese + Tool.chnUnitChar[unitPos];//对应中文权位
					chineseNum = setionChinese + chineseNum;
				}
				unitPos++;
				section = section/10;
			}
			
			return chineseNum;
		}
	 public static String numberToChinese(long num){//转化一个阿拉伯数字为中文字符串
			if(num == 0){
				return "零";
			}
			int unitPos = 0;//节权位标识
			String All = new String();
			String chineseNum = new String();//中文数字字符串
			boolean needZero = false;//下一小结是否需要补零
			String strIns = new String();
			while(num>0){
				int section = (int) (num%10000);//取最后面的那一个小节
				if(needZero){//判断上一小节千位是否为零，为零就要加上零
					All = Tool.chnNumChar[0] + All;
				}
				chineseNum = sectionTOChinese(section,chineseNum);//处理当前小节的数字,然后用chineseNum记录当前小节数字
				if( section!=0 ){//此处用if else 选择语句来执行加节权位
					strIns = Tool.chnUnitSection[unitPos];//当小节不为0，就加上节权位
					chineseNum = chineseNum + strIns;
				}else{
					strIns = Tool.chnUnitSection[0];//否则不用加
					chineseNum = strIns + chineseNum;
				}
				All = chineseNum+All;
				chineseNum = "";
				needZero = (section<1000) && (section>0);
				num = num/10000;
				unitPos++;
			}
			return All;
		}
	 private String toChinese(long num1) {
	        String[] s1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	        String[] s2 = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };
	        String string = String.valueOf(num1);
	        String result = "";

	        int n = string.length();
	        for (int i = 0; i < n; i++) {

	            int num = string.charAt(i) - '0';

	            if (i != n - 1 && num != 0) {
	                result += s1[num] + s2[n - 2 - i];
	            } else {
	                result += s1[num];
	            }
	         
	        }

	        System.out.println(result);
	        return result;

	    }
	 
}	
