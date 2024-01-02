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
	public Contestant(String startNumber, String name, String goal) {	
		this.startNumber = startNumber;
		this.name = name;
		this.goal = goal;
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
	
	 
	@Override
	public String toString() {
		return startNumber + "," + name + ","+ times + "," + interval + "," + goal;
	}

}
