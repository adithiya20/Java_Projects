import java.util.Iterator;
import java.util.Scanner;

public class GuessThenumber {
	private static int num_generator(int max, int min) {
		int range = max - min + 1;
		int number= (int) (Math.random()* (range)) + min;
		System.out.println("NEW NUMBER HAS BEEN GENERATED");
		System.out.println("You have 5 tries to get the number. Goodluck!");
		System.out.println(number);
		System.out.println("Enter a number from " + min+ "-" + max);
		return number;
	}
	
	public static void main(String[] args) {
		int max=100,min=0;
		int score=0;
		int input = 0;
		int number = num_generator(max,min);
		Scanner scanner = new Scanner(System.in);
		
		
		for(int i =1;i<=5;i++) {
			input = scanner.nextInt();
			System.out.println(i);
			if(input== number) {
				System.out.println("YOU GOT THE NUMBER! CONGRATS!");
				System.out.println();
				number = num_generator(max, min);
				i=0;
				score++;
			}
			else if(input>number) {
				System.out.println("You guessed too high");
			}
			
		
			else {
				System.out.println("You guessed too low");
				
		}
			}
	
		
		System.out.println("GAME OVER!\nYour score is: "+score);
		scanner.close();
		
	}

}
