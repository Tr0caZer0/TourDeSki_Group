package application;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Timer {

    private Instant startTime;
    private Instant endTime;
    private boolean isRunning;
    private List<Duration> lapTimes;

    public Timer() {
        lapTimes = new ArrayList<>();
        isRunning = false;
    }

    public void startTimer() {
        if (!isRunning) {
            startTime = Instant.now();
            isRunning = true;
            lapTimes.clear(); 
        }
    }

    public void stopTimer() {
        if (isRunning) {
            endTime = Instant.now();
            isRunning = false;
        }
    }

    public void resetTimer() {
        isRunning = false;
        startTime = null;
        endTime = null;
        lapTimes.clear();
    }

    public void lapTime() {
        if (isRunning) {
            Instant sliptTime = Instant.now();
            Duration duration = Duration.between(startTime, sliptTime);
            lapTimes.add(duration);
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
}