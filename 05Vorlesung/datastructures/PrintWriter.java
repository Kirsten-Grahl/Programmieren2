package datastructures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriter {

	public static void main(String[] args) throws IOException{
		try{File file = new File("05Vorlesung\\fileIO\\text.txt");
		FileWriter out = new FileWriter(file);
		PrintWriter writer = new PrintWriter(out);
		Scanner scanner = new Scanner(System.in);
		writer.println(scanner.next());
		writer.close();
		out.close();
		scanner.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
