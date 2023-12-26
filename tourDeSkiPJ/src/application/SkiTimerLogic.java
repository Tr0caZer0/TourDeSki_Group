package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SkiTimerLogic extends Contestant{
	public List <Contestant> contestants = new CopyOnWriteArrayList<>();
	public TreeMap<Integer, String> intervallCompetitorOrder = new TreeMap<>();
	public TreeMap<Integer, String> goalCompetitorOrder = new TreeMap<>();
	
	Timer time = new Timer();
	Contestant contestant = new Contestant();
	
	public int counter1;
	public int counter2;
	
	public SkiTimerLogic() {
		counter1 = contestants.size();
		counter1 = contestants.size();
	}
	
	private String startNumber;
	private String groupId;
	
	public void skierList() {
		
		groupId="Race1.txt";
		//Läser in textfil och skapar listan contestants av våra Contestant objekt
		try(FileReader fr = new FileReader(new File(groupId))) {	
			BufferedReader br = new BufferedReader(fr);
			String line;
			setStartTime();
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
			br.close();

		}
		catch (IOException e) {
			System.out.println("Error - Cannot read from file " +groupId);

		}
	}// End SkierList() method


	
	public void addTimeToContestant(String option, String startNumber) {
		System.out.println(counter1);
		System.out.println(counter2);
		
//		For the moment giving start time to keep track. To be removed later on. 
		if(option.equals("Start")) {
			setStartTime();
			for(Contestant skier : contestants) {
				skier.lapTime1();
				skier.getTimes();
			}
		}
//		Takes intervall.
		if(option.equals("Lap")) {
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber) && (counter1 >0)) {
				skier.lapTime2();
				skier.getIntervall();
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getIntervall())));
//				Collections.reverse(contestants);
//				intervallCompetitorOrder.put(stringToInt(skier.getIntervall()), startNumber);
				
//				intervallCompetitorOrder.put(stringToInt(skier.getIntervall()), startNumber);
//				toUpdateOrder(intervallCompetitorOrder);
				counter1--;
				}
			}
		}
		
		if(option.equals("Goal")) {
			for(Contestant skier : contestants) {
				if(skier.getStartNumber().equals(startNumber) && (counter2 >0)) {
				skier.lapTime3();
				skier.getGoal();
				Collections.sort(contestants, Comparator.comparingInt(c -> stringToInt(c.getGoal())));
//				Collections.reverse(contestants);
//				goalCompetitorOrder.put(stringToInt(skier.getGoal()), startNumber);
//				toUpdateOrder();
				counter2--;
				}
			}
		}
		
		if(counter1 <= 0 && counter2 <= 0) {
			time.setStopTime();
			System.out.println("Competition over");
		}
		
		
		System.out.println(contestants);
	}
//	
//	private void toUpdateOrder(TreeMap<Integer, String> mapList) {
//		
//		for(Map.Entry<Integer, String> orderContestant : mapList.entrySet()) {
//			
//			for(Contestant skier : contestants) {
//				if(orderContestant.getValue().equals(skier.getStartNumber())) {
//					
//				}
//			}
//		}
//		
//	}



//	private void toUpdateOrder() 
//		
//	}
	  
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
	
//	call on a method that organises the competitors in descending order 
//	using stringToInt and compare the times for each contestant.

	public void quitApp(String message) {
		System.out.println(message);
		System.exit(0);
	}
}// End Logic class
