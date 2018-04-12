package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class file{
		@SuppressWarnings("resource")
		public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("1.txt"));
		ObjectOutputStream rOd = new ObjectOutputStream(new FileOutputStream("model.dat")); 
		while(input.hasNext()) {
			double d = input.nextDouble();
			System.out.println(d);
			rOd.writeDouble(d);
		}	
		rOd.writeDouble(Double.MIN_NORMAL);
		rOd.close();
		ObjectInputStream rId = new ObjectInputStream(new FileInputStream("model.dat"));
		while(true) {
			double d = rId.readDouble();
			if(d == Double.MIN_NORMAL)
				break;
			System.out.println(d);
		}	
		rId.close();

	}
		
}
