//import java.swing.*
import java.util.*;
public class Runner {

	public static void main(String[] args) {
	        char option;
	        double input_num = 0;
	        Scanner scanner= new Scanner(System.in);
	        String input;
	        Function converter=new Function();
	        System.out.println("Welcome!");
	        do{
	        	 System.out.println("Please enter a number: ");
	 	        System.out.println("\n");
	 	        input =scanner.next();
				if(converter.check(input) == true) {
					input_num=Double.parseDouble(input);
				}
				else {
					System.out.println("Invalid entry!");
				}
			}while(!converter.check(input));
	        
	        
	        
	        do{
	            System.out.println("********************************************");
	            System.out.println("Choose an option");
	            System.out.println("a) Equivalent conversion");
		        System.out.println("b) Enter new number");
		        System.out.println("e) Exit");
	    		option = scanner.next().charAt(0);
	    		System.out.println(option);
	            System.out.println("\n");

	            switch (option){
	                case 'a':
	                    System.out.println("......................");
	                    System.out.println("Currency Conversion");
	                    System.out.println("......................");
	                    System.out.println("\n");
	                    converter.dollarToNok(input_num);
	    				converter.dollarToJPY(input_num);
	    				converter.dollarToCAD(input_num);
	    				converter.dollarToINR(input_num);
	                    break;
	                case 'b':
	                	do{
	       	        	 System.out.println("Please enter a number: ");
	       	 	        System.out.println("\n");
	       	 	        input =scanner.next();
	       				if(converter.check(input) == true) {
	       					input_num=Double.parseDouble(input);
	       				}
	       				else {
	       					System.out.println("Invalid entry!");
	       				}
	       			}while(!converter.check(input));
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
	        
	        scanner.close();	
	        System.out.println("Thank you for using the currency converter. Bye!");
		
		}
}


	

