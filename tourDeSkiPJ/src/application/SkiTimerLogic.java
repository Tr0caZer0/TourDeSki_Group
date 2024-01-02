package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SkiTimerLogic extends Contestant{
	public List <Contestant> contestants = new CopyOnWriteArrayList<>();
	Timer time = new Timer();
	Contestant contestant = new Contestant();
	
	String forPursuit = null;
	
	public int counter1;
	public int counter2;
	
	private String savedGroupId;
	private String savedCompetitionType;
	
	public SkiTimerLogic() {
		counter1 = contestants.size();
		counter1 = contestants.size();
		
	}
	
	
	public void skierList(String groupId, String competitionType) {

		try(FileReader fr = new FileReader(new File("CompetitionId" + groupId +"_CompetitionType" + competitionType + ".txt"))) {	
			BufferedReader br = new BufferedReader(fr);
			String line;
			Contestant skier;
			while ((line=br.readLine()) != null) {
				String[] part = line.split(",");
				String startNumber = part[0];
				String name = part[1];
				if(competitionType.equals("Pursuit")) {
					String toGetPrusitTime = part[4];
					skier = new Contestant(startNumber,name, toGetPrusitTime);
				}else {
					skier = new Contestant(startNumber,name);
				}
				
				
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
			forPursuit = "1";
			for(Contestant skier : contestants) {
				skier.setStartTime();
				skier.setTimes(skier.getStartTimer());
			}
		}
		
		if(option.equals("Interval15")) {
			forPursuit = "2";
			setStartTime();
			Instant test = Instant.now();
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(test);
				//skier.lapTime0();
				skier.setTimes(skier.getStartTimeInterval());
				System.out.println(skier.getStartTimeInterval());
				test = test.plusSeconds(15);
			}
		}
//		Måste skapa en till knapp i javaFX för intervall på 30 sec
//		Interval-start 2
		if(option.equals("Interval30")) {
			forPursuit = "3";
			setStartTime();
			Instant test = Instant.now();
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(test);
				skier.setTimes(skier.getStartTimeInterval());
				test = test.plusSeconds(30);
			}
		}
		
//		pusuit-start 3 
//		Ska starta med den tidsskillnad som de hade vid slutet på starterna ovan. 
		if(option.equals("Pursuit")) {
			//setStartTime();
			Instant timeComp = Instant.now();
			List<Integer> interval = getDifference();
			int i = 1;
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(timeComp);
				skier.setTimes(skier.getStartTimeInterval());
				
				skier.setGoal("00:00:00"); // för att undvika sluttiderna från föregående lopp.
				if(i < counter1) {
					timeComp = timeComp.plusSeconds(interval.get(i));

					System.out.println(i);
				}
				i += 1;
				
			}
			
		}
		
		System.out.println(contestants);
	}
	
	// För att hämta intervallVärdet
	private List<Integer> getDifference() {
		List<Integer> listEndTime = new ArrayList<>();
		for(Contestant skier : contestants) {
			String [] toSplitTime = skier.getGoal().split(":");
			listEndTime.add(Integer.parseInt(toSplitTime[2]));
		}
		
		List<Integer> difference = new ArrayList<>();
		
		for(int i = 0; i < listEndTime.size(); i++) {
			if(i == 0) {
				difference.add(0);
			}else {
				int findDifference = listEndTime.get(i) - listEndTime.get(i - 1);
				difference.add(findDifference);
			}
		}
		
		System.out.println(difference);
		return difference;
	}


	public void getTimeForContestant(String option, String startNumber, String competitionType) {
		if(option.equals("Lap")) {
		
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber)) {
					if(competitionType.equals("Interval15") || competitionType.equals("Interval30") || competitionType.equals("Pursuit")) {
						
						if(stringToInt(skier.getCurrentTime()) > 0) {
							skier.setInterval(skier.getCurrentTime());
						}else {
							System.out.println("Contestant hasn't started the race yet.");
							skier.setInterval("00:00:00");
						}
						
					}else {
						skier.setInterval(skier.getCurrentTime());
					}
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getInterval())));
				counter1--;
				//skier.resetTimer();
				break;
				}
			}
			
		}
		
		if(option.equals("Goal")) {
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber) && (counter2 >0)) {
					if(competitionType.equals("Interval15") || competitionType.equals("Interval30") || competitionType.equals("Pursuit")) {
						
						if(stringToInt(skier.getCurrentTime()) > 0) {
							skier.setGoal(skier.getCurrentTime());
						}else {
							System.out.println("Contestant hasn't started the race yet.");
							skier.setInterval("00:00:00");
						}
						
					}else {

						skier.setGoal(skier.getCurrentTime());
					}
//				skier.getGoal();
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getGoal())));
				counter2--;
				}
			}
		}
//		Måste korrigeras. 
		if(counter1 <= 0 && counter2 <= 0) {
			saveCompetitionScore();
			if(!competitionType.equals("Pursuit")) {
				savedForPursuit();
			}
			time.setStopTime();
			System.out.println("Competition over");
		}
		
	}

	
	public void savedForPursuit() {
//		Should correlate to the competitionId that the race is based on. 
		String competitionId = "CompetitionId" + savedGroupId.concat(forPursuit) + "_CompetitionType"+ "Pursuit" +".txt";
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
