package application;

public class Contestant extends Timer {
	
	private String startNumber;
	private String name;
	private String times;
	private String intervall;
	private String goal;
	
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

	public String getTimes() {
		return times;
	}

	public void setStartNumber(String startNumber) {
		this.startNumber = startNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	
	 public void lapTime1() {
	        super.lapTime(); // Call the parent class method to calculate intervalTime
	        times = getStartTimer();
	    }
	 public void lapTime2() {
	        super.lapTime(); // Call the parent class method to calculate intervalTime
	        intervall = getCurrentTime();
	    }
	 
	 public void lapTime3() {
	        super.lapTime(); // Call the parent class method to calculate intervalTime
	        goal = getCurrentTime();
	    }
	// Metod för att lägga till tid till List<LocalTime> times
	public String addTime() {
		return times;
		
	}

	@Override
	public String toString() {
		return startNumber + "," + name + "," + intervall + "," + goal;
	}

	public String getIntervall() {
		return intervall;
	}

	public void setIntervall(String intervall) {
		this.intervall = intervall;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	

	
	
	
}
