package application;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Timer {

    protected Instant startTime;
    protected Instant endTime;
    protected Instant intervalTime;
    protected boolean isRunning;
    protected List<Duration> lapTimes;

    public Timer() {
        lapTimes = new ArrayList<>();
        isRunning = false;
        
    }

    public void setStartTime() {
        if (!isRunning) {
        		startTime = Instant.now();
                isRunning = true;
                lapTimes.clear();
        }
    }
    
    public void setStartTime(Instant newTime) {
        if (!isRunning) {
        		startTime = newTime;
                isRunning = true;
                lapTimes.clear();
        }
    }
    
//    public void setStartTimeInterval(Instant startTime) {
//        if(this.startTime == null) {
//     	   this.startTime = startTime;
//        }
//     }
//    
    public void setStartTimeInterval(Instant test) {
    	 if (startTime == null) {
    	        startTime = test;
    	        isRunning = true;
    	    }
        
    }
//    public void setIntervalTime() {
//        intervalTime = Instant.now();
//        isRunning = true;
//        
//    }
    
    public void setIntervalTime() {
		this.intervalTime = Instant.now();
}
    //För att anta ett intervallVärde
    public void setIntervalTime(Instant intervalTime) {
    		this.intervalTime = intervalTime;
    }
    
    public Instant getIntervalTime() {
    	return intervalTime;
    }
    

    
    public String getStartTimeInterval() {
    	if(startTime != null) {
    		return formatInstant(startTime);
    	}else {
    		return "Null";
    	}
    	
    }
    
    // För att hämta tidsvärdet som Instant. 
    public Instant getInstantStartTimeInterval() {
    		return startTime;
    }
    
    public String getStartTimer() {
    	if(startTime != null) {
    		return formatInstant(startTime);
    	}else {
    		return "Null";
    	}
    	
    }
    
    public void setStopTime() {
        if (isRunning) {
            endTime = Instant.now();
            isRunning = false;
        }
    }
    
    public String getStopTimer() {
    	return formatInstant(endTime);
    }
    
    public void resetInterval(){
    	intervalTime = null;
    }
    public void resetTimer() {
        isRunning = false;
        startTime = null;
        intervalTime = null;
        endTime = null;
        lapTimes.clear();
        System.out.println("timer reset");
        System.out.println(startTime);
        System.out.println(isRunning);
    }
    
//    public void lapTime0() {
//        if (isRunning) {
//            Instant splitTime = Instant.now();
//            Duration duration = Duration.between(startTime, splitTime);
//            intervalTime = formatDuration(duration);
//        }
//    }
    
//    public void lapTime() {
//        if (isRunning) {
//            Instant splitTime = Instant.now();
//            Duration duration = Duration.between(startTime, splitTime);
//            lapTimes.add(duration);
//        }
//    }
    public String getCurrentIntervalTime() {
        if (isRunning) {
            Duration duration = Duration.between(startTime, Instant.now());
            return formatDuration(duration);
        } else if (startTime != null && endTime != null) {
            Duration duration = Duration.between(startTime, endTime);
            return formatDuration(duration);
        } else {
            return "00:00:00";
        }
    }

    public String getCurrentTime() {
        if (isRunning) {
            Duration duration = Duration.between(startTime, Instant.now());
            return formatDuration(duration);
        } else if (startTime != null && endTime != null) {
            Duration duration = Duration.between(startTime, endTime);
            return formatDuration(duration);
        } else {
            return "00:00:00";
        }
    }

//    public List<String> getLapTime() {
//        List<String> formattedSplits = new ArrayList<>();
//        for (Duration split : lapTimes) {
//            formattedSplits.add(formatDuration(split));
//        }
//        return formattedSplits;
//    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    //Konverterar Instant till String
    private String formatInstant(Instant instant) {
    	DateTimeFormatter formatInstantTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    	String formattedTime = formatInstantTime.format(instant.atZone(ZoneId.systemDefault()));
        return formattedTime;
    }
    
//    @Override
//    public String toString() {
//    	return startTime + "," + intervalTime + "," + getCurrentTime();
//    }
}