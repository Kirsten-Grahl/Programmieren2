package datastructures;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AccountMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		HashMap<String, Integer> accounts = new HashMap<>();
		accounts.put("Calcifer", 12345678);
		accounts.put("Kiki", 72345648);
		accounts.put("Jiji", 436566575);
		accounts.put("Hauro", 545757757);
		accounts.put("Chihiro", 34464666);
		
		String name = scanner.next();
		int nummer = scanner.nextInt();
		
		
		
		Set<String> personname = accounts.keySet();
		for(String pname: personname) {
			if(pname.equals(name)){
				System.out.println("Error, Namen gibt es schon");
				System.exit(0);
			}
			else if((accounts.get(pname)).equals(nummer)) {
				System.out.println("Error, Nummer gibt es schon");
				System.exit(0);
			}
			
		}
		
		accounts.put(name, nummer);
		System.out.println("Eintragen war erfolgreich");
		for(String pname: personname) {
			System.out.println(pname + " : " + accounts.get(pname));
		}
	
		
		
		scanner.close();
		
	
	}
	

}
