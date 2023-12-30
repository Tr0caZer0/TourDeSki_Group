package application;

public class Contestant extends Timer {
	
	private String startNumber;
	private String name;
	private String times;
	private String interval;
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
	
//	 public void lapTime0() {
//	       	super.lapTime(); // Call the parent class method to calculate intervalTime
//	       
//	        
//	    }
	 
	 public void lapTime1() {
//	        super.lapTime(); // Call the parent class method to calculate intervalTime
	        
	        	setStartTime();
	        
	    }
	 
	 public void lapTime2() {
//	        super.lapTime(); // Call the parent class method to calculate intervalTime
	        interval = getCurrentTime();
	    }
	 
	 public void lapTime3() {
//	        super.lapTime(); // Call the parent class method to calculate intervalTime
	        goal = getCurrentTime();
	    }
	// Metod för att lägga till tid till List<LocalTime> times
	public String addTime() {
		return times;
		
	}

//	return startNumber + "," + name + "," + "times + "," interval + "," + goal;
	@Override
	public String toString() {
		return startNumber + "," + name + ","+ times + "," + interval + "," + goal;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	

	
	
	
}
