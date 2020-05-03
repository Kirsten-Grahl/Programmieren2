package datastructures;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;

public class ContactMain {

	public static void main(String[] args) {
		
		Contact contact1 = new Contact("Bob Ross", 123456);
		Contact contact2 = new Contact("Bruce Lee", 234567);
		Contact contact3 = new Contact("Alex", 754345);
		Contact contact4 = new Contact("Zorro", 654546);
		Contact contact5 = new Contact("Chuck Norris", 0);
		Contact contact6 = new Contact("Uwe Boll", 157868);
		
        try {
        	FileOutputStream fileOut = new FileOutputStream("05Vorlesung\\fileIO\\file.ser");
    		ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(contact1);
            out.writeObject(contact2);
            out.writeObject(contact3);
            out.writeObject(contact4);
            out.writeObject(contact5);
            out.writeObject(contact6);
            out.close();
			fileOut.close();
			
			FileInputStream fis= new FileInputStream("05Vorlesung\\fileIO\\file.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {
				Contact contact = (Contact) ois.readObject();
				if(contact instanceof Contact) {
					Contact con = (Contact) contact;
					System.out.println(con.toString());}
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
			fis.close();
			ois.close();
			
			System.out.println(contact1.getName() + " "+ contact1.getPhonenumber());
			System.out.println(contact2.getName() + " "+ contact2.getPhonenumber());
			System.out.println(contact3.getName() + " "+ contact3.getPhonenumber());
			System.out.println(contact4.getName() + " "+ contact4.getPhonenumber());
			System.out.println(contact5.getName() + " "+ contact5.getPhonenumber());
			System.out.println(contact6.getName() + " "+ contact6.getPhonenumber());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		LinkedList<Contact> contacts = new LinkedList<>();
//		contacts.add(new Contact("Bob Ross", 123456));
//		contacts.add(new Contact("Bruce Lee", 234567));
//		contacts.add(new Contact("Alex", 754345));
//		contacts.add(new Contact("Kirsten", 435636));
//		contacts.add(new Contact("Zorro", 654546));
//		contacts.add(new Contact("Chuck Norris", 0));
//		contacts.add(new Contact("Uwe Boll", 157868));
//
//		
//		Collections.sort(contacts);
//
//		for(Contact contact : contacts) {
//			System.out.println(contact.getName() +  " : " + contact.getPhonenumber());
//			
//		}

	}

}
