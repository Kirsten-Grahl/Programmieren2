package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class FileMain {

	public static void main(String[] args) {
		File file = new File("05Vorlesung\\fileIO\\name.txt");
		if(file.exists()) {
			System.out.println("Die Datei existiert");
		}else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Das Programm lebt noch");
		}
		
		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
			
			bufferedWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände - BW");
			bufferedWriter.newLine();
			bufferedWriter.flush(); //für Mac
			
//			fileWriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände\r\n");
//			fileWriter.flush(); //für Mac
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
//		Scanner scanner = new Scanner(System.in);
//		Scanner scanner = new Scanner(file);	geht auch	
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String text = bufferedReader.readLine();
			System.out.println(text);
			bufferedReader.close();
			fileReader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try(FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)){
			//hier kann dann auch ein Object vom Typ Ufo erstellt werden
			oos.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
