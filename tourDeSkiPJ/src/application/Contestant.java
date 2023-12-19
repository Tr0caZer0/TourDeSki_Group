package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Contestant {
	
	private String startNumber;
	private String name;
	private List<LocalTime> times = new ArrayList<LocalTime>();
	
	public Contestant() {	
	}
	
	public Contestant(String startNumber) {	
		this.startNumber = startNumber;
	}
	
	public Contestant(String startNumber, String name) {	
		this.startNumber = startNumber;
		this.name = name;
	}
	
	public Contestant(String startNumber, String name, List<LocalTime> times) {
		this.startNumber = startNumber;
		this.name = name;
		this.times = times;
	}

	public String getStartNumber() {
		return startNumber;
	}
	
	public String getName() {
		return name;
	}

	public List<LocalTime> getTimes() {
		return times;
	}

	public void setStartNumber(String startNumber) {
		this.startNumber = startNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTimes(List<LocalTime> times) {
		this.times = times;
	}
	// Metod för att lägga till tid till List<LocalTime> times
	public void addTime() {
		times.add(LocalTime.now());
		
	}

	@Override
	public String toString() {
		return startNumber + "," + name + "," + times;
	}
	
	

	
	
	
}
