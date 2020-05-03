package datastructures;

import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {
	private String name;
	private int phonenumber;

	public Contact(String name, int phonenumber) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

//	@Override
//	public int compareTo(Contact other) {
//		int val = name.compareTo(other.name);
//		if (val == 0) {
//			// TODO dann vergleiche phonenumber
//			if (phonenumber < other.phonenumber) {
//				return -1;
//			} else if (phonenumber >= other.phonenumber) {
//				return 1;
//			}
//		}
//		return val;
//	}
	
	@Override
	public int compareTo(Contact other) {
		if(name.equals("Chuck Norris")) {
			return -1;
		}else if(other.name.equals("Chuck Norris")){
			return 1;
		}else if(other.name.equals("Bob Ross") || other.name.equals("Bruce Lee")) {
		
			return 1;
		}
		else if(name.equals("Uwe Boll")) {
			return 1;
		}
		
		int val = name.compareTo(other.name);
		if (val == 0) {
			// TODO dann vergleiche phonenumber
			if (phonenumber < other.phonenumber) {
				return -1;
			} else if (phonenumber >= other.phonenumber) {
				return 1;
			}
		}
		return val;
	}

}
