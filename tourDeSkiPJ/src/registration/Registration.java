package registration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Contestant;

public class Registration {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		
		List<Contestant> contestants = new ArrayList<Contestant>();

		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Register for a race");
			System.out.println("1: Add contestant");
			System.out.println("2: View list");
			System.out.println("3: Save list");
			System.out.println("0: Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 0:
				continueLoop=false;
				System.out.println("Registration cancelled");
//				Lade till system.exit så att programmet avslutas efter att lista skapats. 
				System.exit(0);
				break;
//			Uppdaterade StartNummer till String.
			case 1:
				System.out.println("Enter startnumber:");
				String startNumber = scanner.nextLine();
				System.out.println("Enter name:");
				String name = scanner.nextLine();
				Contestant contestant = new Contestant();
				contestant.setStartNumber(String.valueOf(startNumber));
				contestant.setName(name);
				contestants.add(contestant);
				break;
			case 2:
				if(contestants.isEmpty()) {
					System.out.println("No contestants have been added to the list");
				}
				else {
					System.out.println(contestants);
				}
				break;
				
			case 3:
				if(contestants.isEmpty()) {
					System.out.println("No contestants have been added to the list");	
				}
				else {
//				Lade till tävlings-typ samt ändrade filnamn. Så att vi kan välja korrekt tävlingstyp i Main-klassen. 
				System.out.println("Enter group id number:");
				String groupId = scanner.nextLine();
				System.out.println("Enter competition type (Mass, Interval15, Interval30, pursuit):");
				String competitionType = scanner.nextLine();
				String raceId = "CompetitionId" + groupId +"_CompetitionType" + competitionType + ".txt";
				try {
					FileWriter fw = new FileWriter(raceId);
					PrintWriter pw = new PrintWriter(fw);
					for(Contestant skier : contestants) {
						pw.println(skier);
					}
					pw.close();
				} 
				catch (IOException e) {
					System.out.println("Error - Cannot write to file " +raceId);

				}
				
				System.out.println("The list was saved as "+raceId);
				}
				break;
			default:
				System.out.println("Invalid choice, try again!");
				continue;

			}
			
		}
		
	}
}














