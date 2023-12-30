package application;

import registration.Registration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SkiTimerLogic extends Contestant{
	public List <Contestant> contestants = new CopyOnWriteArrayList<>();
	Timer time = new Timer();
	Contestant contestant = new Contestant();
	
	public int counter1;
	public int counter2;
	
	private String savedGroupId;
	private String savedCompetitionType;
	
	public SkiTimerLogic() {
		counter1 = contestants.size();
		counter1 = contestants.size();
		
	}
	
	private String startNumber;
	
	public void skierList(String groupId, String competitionType) {

		//Changed to choice based
		//Läser in textfil och skapar listan contestants av våra Contestant objekt
		try(FileReader fr = new FileReader(new File("CompetitionId" + groupId +"_CompetitionType" + competitionType + ".txt"))) {	
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line=br.readLine()) != null) {
				String[] part = line.split(",");
				startNumber = part[0];
				String name = part[1];
				
				Contestant skier = new Contestant(startNumber,name);
				System.out.println(skier);
				contestants.add(skier);
				
			}
			counter1 = contestants.size();
			counter2 = contestants.size();
			
//			För att spara till korrekt fil med korrekt namn. 
			savedGroupId= groupId;
			savedCompetitionType = competitionType;
			
			br.close();

		}
		catch (IOException e) {
			System.out.println("Error - Cannot read from file " + e);

		}
	}// End SkierList() method


	
	public void addTimeToContestant(String option, String startNumber) {
		System.out.println(counter1);
		System.out.println(counter2);
		
//		Mass-start
//		En till spalt som gäller för starttiden 
		if(option.equals("Mass")) {
			
			for(Contestant skier : contestants) {
				skier.lapTime1();
				skier.setTimes(skier.getStartTimer());
			}
		}
		
//		Interval-start 1 intervall på 15 sec
//		I uppgiften ger han exempel där loppet start 10:00:00 för åkare 1 och 10:00:15 för åkare två
//		Se på hur vi kan välja klockslag för start istället för now.
//		if(option.equals("Interval15")) {
//			LocalTime startTime = LocalTime.parse("10:00:00");
//			Instant instantStartTime = startTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant();
//			for(Contestant skier : contestants) {
//				skier.setStartTimeInterval(instantStartTime);
//				skier.lapTime0();
//				skier.setTimes(skier.getStartTimeInterval());
//				
//				instantStartTime = instantStartTime.plusSeconds(15);
//			}
//		Måste skapa unik LapTime för intervall
		if(option.equals("Interval15")) {
			setStartTime();
			Instant test = getInstantStartTimeInterval();
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(test);
				//skier.lapTime0();
				skier.setTimes(skier.getStartTimeInterval());
				
				test = test.plusSeconds(15);
			}
		}
//		Måste skapa en till knapp i javaFX för intervall på 30 sec
//		Interval-start 2
		if(option.equals("Interval30")) {
//			setIntervalTime(30);
		}
		
//		pusuit-start 3 
//		Ska starta med den tidsskillnad som de hade vid slutet på starterna ovan. 
		if(option.equals("Pursuit")) {
			
		}
		
//		Takes interval.
		if(option.equals("Lap")) {
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber) && (counter1 >0)) {
				skier.lapTime2();
//				skier.getInterval();
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getInterval())));
				counter1--;
				}
			}
		}
		
		if(option.equals("Goal")) {
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber) && (counter2 >0)) {
				skier.lapTime3();
//				skier.getGoal();
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getGoal())));
				counter2--;
				}
			}
		}
		
		if(counter1 <= 0 && counter2 <= 0) {
			saveCompetitionScore();
			time.setStopTime();
			System.out.println("Competition over");
		}
		
		
		System.out.println(contestants);
	}

//	private void setIntervalTime(int intervalTimeset) {
//		String hours= "10";
//        String minutes = "00";
//        String seconds = "00";
//        
//        int timeHours = 10;
//        int timeMinutes = 0;
//        int timeSeconds = 0;
//        
//        
//        
//		for(Contestant skier : contestants) {
//			skier.setStartTime();
//			String addingTime = hours + ":" + minutes + ":" + seconds;
//			skier.lapTime0(addingTime);
//			timeSeconds += intervalTimeset;
//			
//			if(timeSeconds >= 60) {
//				timeSeconds = 0;
//				seconds = "00";
//				timeMinutes += 1;
//			}else {
//				seconds = Integer.toString(timeSeconds);
//			}
//			
//			if(timeMinutes >= 60) {
//				timeMinutes = 0;
//				minutes = "00";
//				timeHours += 1;
//			}else {
//				minutes = "0" + Integer.toString(timeMinutes);
//			}
//			
//			if(timeHours >= 24) {
//				timeHours = 1;
//				hours = "01";
//			}else {
//				hours = Integer.toString(timeHours);
//			}
//			
//			if(timeHours < 10) {
//				
//				hours = "0" + Integer.toString(timeHours);
//			}
//		
//		}
//	}


//	Måste även spara för jakt-start och följa rätt syntax:
//	"CompetitionId" + groupId +"_CompetitionType" + competitionType + ".txt"
//	Se efter hur man kan göra det utan att skapa en till metod. 
	public void saveCompetitionScore() {
//		Should correlate to the competitionId that the race is based on. 
		String competitionId = "saved_" + savedCompetitionType + "_Competition"+ savedGroupId +".txt";
		try(BufferedWriter toSaveData = new BufferedWriter(new FileWriter(competitionId))){
			
			for(Contestant skier : contestants) {
				toSaveData.append(skier.toString());
				toSaveData.newLine();
			}
			
			toSaveData.close();
			
		}catch(IOException e) {
			System.out.println("Error - Cannot create file" + e);
		}
		
	}


//	Omvanldar tidsvärdet i string till int i sekunder för att sedan avgöra vem som leder i loppet. 
	public int stringToInt(String time) {
		
		 if (time == null) {
		        
		        return 0; 
		}
		String[] timeToSplit = time.split(":");

			int takeHours = (Integer.parseInt(timeToSplit[0]) * 3600);
			int takeMinutes = (Integer.parseInt(timeToSplit[1]) * 60);
			int takeSeconds = Integer.parseInt(timeToSplit[2]);
		
		return takeHours + takeMinutes + takeSeconds;
		
	}
	public void quitApp(String message) {
		System.out.println(message);
		System.exit(0);
	}
}// End Logic class
