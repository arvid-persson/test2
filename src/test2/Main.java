package test2;

import java.util.Scanner;

public class Main {

	static Passenger[] passengers = new Passenger[12];

	// method case 1:
	public static void insertPassenger(String name, int age) {
		for (int i = 0; i < passengers.length - 1; i++) {
			if (passengers[i] == null) {
				passengers[i] = new Passenger(name, age);
				break;

			}
		}

	}

	// method case 2:
	public static void removePassenger(int removeSeat) {
		passengers[removeSeat - 1] = null;

	}

	// method case 3:
	public static void switchSeats(int switchFirstSeat, int switchSecondSeat) {

		Passenger tmpPassenger = passengers[switchFirstSeat - 1];
		passengers[switchFirstSeat - 1] = passengers[switchSecondSeat - 1];
		passengers[switchSecondSeat - 1] = tmpPassenger;

//		passengers[tmpPassenger] = passengers[switchFirstSeat-1];
//		passengers[switchFirstSeat-1] = passengers[switchSecondSeat-1];
//		passengers[switchSecondSeat-1] = passengers[tmpPassenger];

	}

	// method case 4:
	public static void renamePassenger(int renamePassengerSeat, String newPassengerName) {
		passengers[renamePassengerSeat - 1].setName(newPassengerName);

	}

	// method case 5:
	public static void countPassengers() {

		int count = 0;

		for (int i = 0; i < 12; i++) {
			if (passengers[i] != null) {
				count++;
			}

		}
		System.out.println(count);
	}

	// method case 6
	public static void printPassengerManifest() {
		String headerBorder = "##### PASSENGER MANIFEST ######\n";
		String company = "SkyBox Ltd.\n";
		String rubric = "Seat\t    Name\tAge";
		String bottomBorder = "##### ##### ##### ##### ##### ###";

		System.out.println(headerBorder + company + rubric);

		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] == null) {
				System.out.println(i + 1 + " ");
			} else {
				System.out.println(i + 1 + "\t    " + passengers[i].getName() + "\t" + passengers[0].getAge());
			}
		}
		System.out.println(bottomBorder);

	}

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);

		String output = "What action do you want to perform?\n1: Insert passenger\n2: Remove passenger\n3: Switch seats\n4: Rename passenger\n5: Count passengers\n6: Print passenger manifest\n7: Exit program";
		
		Boolean bool = true;
	while(bool) {
		System.out.println(output);

		int actionChoice;

		actionChoice = myScanner.nextInt();

		switch (actionChoice) {

		case 1: {

			System.out.println("Insert passenger name");
			String name = myScanner.next();

			System.out.println("insert passenger age");
			int age = myScanner.nextInt();
			//myScanner.next(); // to prevent next int error när koden körs mer än en gång (2 loops)

			insertPassenger(name, age);
			break;

		}

		case 2: {

			System.out.println("Insert the seat number of the passenger you want to remove");
			int removeSeat = myScanner.nextInt();
		

			removePassenger(removeSeat);
			break;

		}

		case 3: {
			System.out.println("Insert the seat number of the first passenger you want to switch seat");
			int switchFirstSeat = myScanner.nextInt();
			

			System.out.println("insert the seat number of the second passenger you want to switch seat");
			int switchSecondSeat = myScanner.nextInt();
			

			switchSeats(switchFirstSeat, switchSecondSeat);
			break;

		}

		case 4: {
			System.out.println("insert the seat number of the passenger you want to rename");
			int renamePassengerSeat = myScanner.nextInt();

			System.out.println("Insert new passenger name");
			String newPassengerName = myScanner.next();

			renamePassenger(renamePassengerSeat, newPassengerName);
			break;

		}

		case 5: {
			countPassengers();
			break;

		}

		case 6: {
			printPassengerManifest();
			break;
		}

		default: System.out.println("invalid user input, please enter a valid number.");
		
		case 7: {
			bool = false;
			break;
		}
		
		
		}

	}	
	}

}
