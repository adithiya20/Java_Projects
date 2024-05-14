package Bank_Management_Software_Simple;

import java.util.Scanner;

public class BankAccount {
	private double balance;
	private double previous_transaction;
	String customerName;
	String customer_account;
	
	BankAccount(String customerName, String customer_account) {
		this.customerName = customerName;
		this.customer_account = customer_account;
	}
	
	void deposit(double amount) {
		if(amount!=0) {
			setBalance(this.balance+=amount);
			this.previous_transaction=amount;
		}
	}
	
	void withdraw(double amount) {
		if (amount!=0 && balance>=amount) {
			this.balance-=amount;
			this.previous_transaction=-amount;
			}
		
		else {
			System.out.println("Insufficient funds on this account to withdraw!");
		}
	}

	void getPreviousTransaction() {
		if (previous_transaction>0) {
			System.out.println("Deposited: "+previous_transaction);
			}
		else if (previous_transaction<0) {
			System.out.println("Withdrawn: "+Math.abs(previous_transaction));
			}
		else {
			System.out.println("No transaction occured");
		}
		
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID:"+customer_account);
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");

        do{
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balance ="+getBalance());
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amt=sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case 'd':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTransaction();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        }while(option!='e');

        System.out.println("Thank you for using our banking services");

	}
}
