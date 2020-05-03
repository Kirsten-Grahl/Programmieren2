package datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class Mittelwert {
 
	public static void main(String[] args) {
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Double> mittelwert = new ArrayList<Double>();
		
		while (true){

            if(scanner.hasNextDouble()){
            	Double a = scanner.nextDouble();
            	mittelwert.add(a);
            }else {
            	String s = scanner.next();
                if(s.equals("quit")) break;
            }
        }
		
		for(int i = 0; i < mittelwert.size(); i++) {
			count += mittelwert.get(i);
			}
		
		count = count/mittelwert.size();
        System.out.println(count);
        scanner.close(); 
}
}
