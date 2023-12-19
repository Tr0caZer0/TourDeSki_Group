package registration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Contestant;

public class Registration {

	public static void main(String[] args){
		
		List<Contestant> contestants = new ArrayList<Contestant>();

		boolean continueLoop = true;
		while (continueLoop) {
			System.out.println("Register for a race");
			System.out.println("1: Add contestant");
			System.out.println("2: View list");
			System.out.println("3: Save list");
			System.out.println("0: Exit");

			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 0:
				continueLoop=false;
				System.out.println("Registration cancelled");
				break;

			case 1:
				Scanner scanner2 = new Scanner(System.in);
				System.out.println("Enter startnumber:");
				int startNumber = scanner.nextInt();
				System.out.println("Enter name:");
				String name = scanner2.nextLine();
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
				System.out.println("Enter race id number:");
				int idNumber = scanner.nextInt();
				String raceId = "Race"+idNumber+".txt";
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














