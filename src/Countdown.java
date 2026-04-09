import java.util.InputMismatchException;
import java.util.Scanner;

public class Countdown {

	public static void main(String[] args) {
		int userInput;
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Please type an integer greater than 0: ");
		
		while (true) {
			try {
				userInput = inputScanner.nextInt();
				if (userInput < 1) {
					System.out.println("The integer must be greater than 0! Please try again.");
					continue;
				}
				System.out.println("Counting down from " + userInput + ":");
				
				boolean first = true;
				for (int counter = userInput; counter >=0; counter--) {
					if (first) {
						System.out.print(counter);
						first = false;
					}
					else {
						System.out.print(", " + counter);
					}
				}
				System.out.println("!");
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("That was not an integer! Please try again.");
				inputScanner.next();
			}
		}
	}
}
