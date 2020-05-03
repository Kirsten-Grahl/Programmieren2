package datastructures;

import java.util.HashSet;
import java.util.Set;

public class Event {
	private String eventname;
	private String ort;
	private String startzeit;

	public Event(String eventname, String ort, String startzeit) {
		super();
		this.eventname = eventname;
		this.ort = ort;
		this.startzeit = startzeit;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStartzeit() {
		return startzeit;
	}

	public void setStartzeit(String startzeit) {
		this.startzeit = startzeit;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventname == null) ? 0 : eventname.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((startzeit == null) ? 0 : startzeit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eventname == null) {
			if (other.eventname != null)
				return false;
		} else if (!eventname.equals(other.eventname))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (startzeit == null) {
			if (other.startzeit != null)
				return false;
		} else if (!startzeit.equals(other.startzeit))
			return false;
		return true;
	}


}
