package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contestant extends Timer {
	
	private String startNumber;
	private String name;
	private List<String> times = new ArrayList<String>();
	private DateTimeFormatter thisTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	public Contestant() {	
	}
	
	public Contestant(String startNumber) {	
		this.startNumber = startNumber;
	}
	
	public Contestant(String startNumber, String name) {	
		this.startNumber = startNumber;
		this.name = name;
	}

	public String getStartNumber() {
		return startNumber;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getTimes() {
		return times;
	}

	public void setStartNumber(String startNumber) {
		this.startNumber = startNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}
	// Metod för att lägga till tid till List<LocalTime> times
	/*public void addTime() {
		times.add(LocalTime.now());
		
	}*/

	@Override
	public String toString() {
		return startNumber + "," + name + "," + startTime + "," + intervalTime + "," + getCurrentTime() ;
	}
	
	

	
	
	
}
