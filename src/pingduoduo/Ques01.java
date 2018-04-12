package pingduoduo;

public class Ques01 {
	
	public static void main(String[] args) {
		System.out.println(calcDegree("9:15"));
	}
	public static double calcDegree(String time) {
		String[] str = time.split(":");
		int hour = Integer.parseInt(str[0]);
		if(hour > 12)
			hour -= 12;
		int minute = Integer.parseInt(str[1]);
		double degree = Math.abs((hour + minute / 60.0) * 30 - minute * 6); 
		return (degree > 180) ? 360 - degree : degree;
	}
}
