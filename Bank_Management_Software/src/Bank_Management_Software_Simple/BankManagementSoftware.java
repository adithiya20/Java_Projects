package Bank_Management_Software_Simple;

import java.util.Arrays;
import java.util.Scanner;

public class BankManagementSoftware {

	public static void main(String[] args) {
		System.out.println("Welcome to the bank\nPlease enter your name and account number:");
		Scanner scanner= new Scanner(System.in);
		String input  = scanner.next();
		String[] customer_info  = input.split(",");
		//Reading customer_info array
		System.out.println(Arrays.toString(customer_info));
		BankAccount object1 = new BankAccount(customer_info[0],customer_info[1]);
		object1.menu();
		
		
	}

}
