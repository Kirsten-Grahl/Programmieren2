package datastructures;

import java.util.HashSet;
import java.util.Iterator;

public class EventMain{
	public static void main(String[] args) {
		Event event1 = new Event("BDay Jiji", "zu Hause bei Jiji", "17:00");
		Event event2 = new Event("Meeting", "Uni", "12:30");
		Event event3 = new Event("Kuchen backen", "bei Kiki in der Bäckerei", "15:00");
		HashSet<String> events = new HashSet<String>();
		events.add(event1.getEventname() +" "+ event1.getOrt() + " " + event1.getStartzeit());
		events.add(event2.getEventname() +" "+ event2.getOrt() + " " + event2.getStartzeit());
		events.add(event2.getEventname() +" "+ event2.getOrt() + " " + event2.getStartzeit());
		events.add(event3.getEventname() +" "+ event3.getOrt() + " " + event3.getStartzeit());
		
		Iterator<String> iterator = events.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
	}
}
