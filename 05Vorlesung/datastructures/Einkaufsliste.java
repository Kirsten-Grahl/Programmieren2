package datastructures;

import java.util.HashMap;
import java.util.Set;

public class Einkaufsliste {

	public static void main(String[] args) {
		HashMap<String, String> liste = new HashMap<>();
		liste.put("Butter", "eine Packung");
		liste.put("Paprika", "drei Stück");
		liste.put("Wasser", "5 Liter");
		liste.put("Brot", "ein Stück");
		
		Set<String> einkaufen = liste.keySet();
		for(String name: einkaufen) {
			System.out.println(name + " : " + liste.get(name));
		}
	}

}
