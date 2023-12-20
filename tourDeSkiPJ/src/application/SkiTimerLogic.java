package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SkiTimerLogic extends Contestant{
	public List <Contestant> contestants = new ArrayList<Contestant>();
	Timer time = new Timer();
	Contestant contestant = new Contestant();
	
	private String startNumber;
	private String groupId;
	
	public void skierList() {
		
		groupId="Race1.txt";
		//Läser in textfil och skapar listan contestants av våra Contestant objekt
		try(FileReader fr = new FileReader(new File(groupId))) {	
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

			br.close();

		}
		catch (IOException e) {
			System.out.println("Error - Cannot read from file " +groupId);

		}
	}// End SkierList() method
	
//	The time that the race starts	
	/*public void saveTime() {
		for (Contestant skier : contestants) {		
			if(skier.getStartNumber().equals(startNumber)) {
				skier.startTimer();
			}
		}
	}*/
//	The time that the race starts
	public void startTime() {
		setStartTime();
		addTimeToContestant();	
	}
	
	public void addTimeToContestant() {
		for(Contestant skier : contestants) {
			skier.toString();
		}
	}
	
	public void quitApp(String message) {
		System.out.println(message);
		System.exit(0);
	}
}// End Logic class
