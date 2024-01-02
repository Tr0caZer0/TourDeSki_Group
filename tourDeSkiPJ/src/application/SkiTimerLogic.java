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
	
	// Fungerar som ID för sprarande av fil för jaktstart.
	String forPursuit = null;
	
	// Storleken på dokumentet omvandlat till List och sen size. 
	public int counter1;
	public int counter2;
	
	// För att kunna formatera korrekt syntax vid sparande av lopp
	private String savedGroupId;
	private String savedCompetitionType;
	
	public SkiTimerLogic() {
		counter1 = contestants.size();
		counter1 = contestants.size();
		
	}
	
//	Metoden skierList läser in utvalt dokument som baseras på ID-nummer samt tävlingstyp. 
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


//	Metoden kan välja mellan fyra olika startmoment. Vilket moment som körs avgörs i Main. 
	public void addTimeToContestant(String option) {
		
//		Mass-start
		if(option.equals("Mass")) {
			forPursuit = "1";
			for(Contestant skier : contestants) {
				skier.setStartTime(); // startar tiden
				skier.setTimes(skier.getStartTimer()); //Hämtar startiden
			}
		}// End if-statement Mass
		
//		Intervall-start 15 sec
		if(option.equals("Interval15")) {
			forPursuit = "2";
			Instant test = Instant.now();// Första deltagaren vid given tid
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(test); // Anger startTid för åkare
				skier.setTimes(skier.getStartTimeInterval()); // Sätter starttid för åkare
				test = test.plusSeconds(15); // skapar ett intervall på 15 sec. 
			}
		}// End if-statement Interval15

//		Intervall-start 30 sec
//		Same same different name. 
		if(option.equals("Interval30")) {
			forPursuit = "3";
			Instant test = Instant.now();
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(test);
				skier.setTimes(skier.getStartTimeInterval());
				test = test.plusSeconds(30);
			}
		}// End if-statement Interval30
		
//		pusuit-start 3 
		if(option.equals("Pursuit")) {
			
			Instant timeComp = Instant.now();
			List<Integer> interval = getDifference();
			int i = 1; // avgör vilken indexposition som blir det kommande intervallet.
			for(Contestant skier : contestants) {
				skier.setStartTimeInterval(timeComp);
				skier.setTimes(skier.getStartTimeInterval());
				
				skier.setGoal("00:00:00"); // för att undvika sluttiderna från föregående lopp.
				// 5 deltagare 4 index
				if(i < counter1) {
					timeComp = timeComp.plusSeconds(interval.get(i));

					System.out.println(i);
				}
				i += 1;
			}
		}// End if-statement Pursuit
		
	}// End addTimeToContestant method

//  Metoden hämtar intervalltid samt sluttid för alla typer av lopp. 
//	Vilket lopp, deltagare och tid som ska hämtas avgörs i Main. 
	public void getTimeForContestant(String option, String startNumber, String competitionType) {
		if(option.equals("Lap")) {
		
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber)) {
					if(competitionType.equals("Interval15") || competitionType.equals("Interval30") || competitionType.equals("Pursuit")) {
						
						// Intervaltiden kan sättas först när åkarens starttid har börjat, annars blir det minus. 
						if(stringToInt(skier.getCurrentTime()) > 0) {
							skier.setInterval(skier.getCurrentTime());
						}else {
							System.out.println("Contestant hasn't started the race yet.");
							skier.setInterval("00:00:00");
						}
						
					}else {
						skier.setInterval(skier.getCurrentTime());
					}
//				Sorterar listan av deltagare i realtid för att få fram vem som leder.
//				Avgörs genom att jämföra tiden mellan deltagare och tiden omvandlad till sekunder. 
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getInterval())));
				counter1--;
				break;
				}
			}
			
		}// End if-statement Lap
		
		//Same same different name
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
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getGoal())));
				counter2--;
				}
			}
		}// End if-statement Goal
		
//		Måste korrigeras. 
//		Tänkt att fungera som en begränsing. 
		if(counter1 <= 0 && counter2 <= 0) {
			saveCompetitionScore();
			//Behövs om det inte ska bli error, eftersom jaktstart inte spraras för ett senare jaktstart tillfälle. 
			if(!competitionType.equals("Pursuit")) {
				savedForPursuit();
			}
			time.setStopTime();
			System.out.println("Competition over");
		}
		
	}// End getTimeForContestant() method

//	Metoden sparar ett lopp för Jaktstart
	public void savedForPursuit() {
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
		
	}//End savedForPursuit() method
	
//	Metoden sparar föregående race. Kan inte användas för jaktstart, inkorrekt syntax. 
	public void saveCompetitionScore() { 
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
	
//	Metoden tar den avgörande sluttiden från ett föregående lopp för alla deltagare och sedan differansen 
//	mellan index från vänster till höger för att får ett korrekt startintervall
	private List<Integer> getDifference() {
		List<Integer> listEndTime = new ArrayList<>();
		//Omvandlar sluttid till till int
		for(Contestant skier : contestants) {
			String [] toSplitTime = skier.getGoal().split(":");
			listEndTime.add(Integer.parseInt(toSplitTime[2]));
		}
		
		List<Integer> difference = new ArrayList<>();
		//Hämtar differansen mellan vänstar och höger deltagare i växande ordning. 
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
	}// End getDifference() method

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
		
	}// End stringToInt() method 
	
	//Metoden avslutar programmet. 
	public void quitApp(String message) {
		System.out.println(message);
		System.exit(0);
	}// End quitApp() method
}// End Logic class
