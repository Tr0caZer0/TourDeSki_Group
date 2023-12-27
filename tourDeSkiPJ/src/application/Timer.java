package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Timer {

    protected Instant startTime;
    protected Instant endTime;
    protected String intervalTime;
    protected boolean isRunning;
    protected List<Duration> lapTimes;

    public Timer() {
        lapTimes = new ArrayList<>();
        isRunning = false;

    	this.setStartTime(isRunning, "");
    }

    public void setStartTime(boolean pursuit, String addSeconds) {
        if (!isRunning) {
        	if(pursuit ==  false) {
        		startTime = Instant.now();
                isRunning = true;
                lapTimes.clear();
        	}else {
        		startTime = LocalTime.parse("10:00:"+addSeconds).atDate(LocalDate.now()).atOffset(ZoneOffset.UTC).toInstant();

        	}
             
        }
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

    public void resetTimer() {
        isRunning = false;
        startTime = null;
        endTime = null;
        lapTimes.clear();
    }
    
    public void lapTime() {
        if (isRunning) {
            Instant splitTime = Instant.now();
            Duration duration = Duration.between(startTime, splitTime);
            intervalTime = formatDuration(duration);
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

    public List<String> getLapTime() {
        List<String> formattedSplits = new ArrayList<>();
        for (Duration split : lapTimes) {
            formattedSplits.add(formatDuration(split));
        }
        return formattedSplits;
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
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