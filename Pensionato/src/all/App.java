package all;

import java.util.InputMismatchException;
import java.util.Scanner;

import all.entities.Account;
import all.entities.exceptions.InvalidValueException;

public class App {
    public static void main(String[] args) {
        try {
            /*
             * 
             Scanner scanner = new Scanner(System.in);
             
             System.out.print("Enter account number: ");
        Integer number = scanner.nextInt();
        
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Enter account holder name: ");
        String holder = scanner.nextLine();
        
        System.out.print("Enter account balance: ");
        Double balance = scanner.nextDouble();
        
        System.out.print("Enter withdrawal limit: ");
        Double withdrawLimit = scanner.nextDouble();
        */
        
            Account account = new Account(356, "igor",500.0, 300.0);

            account.withDraw(400.0);

            System.out.println("Account created successfully!");
            //scanner.close();
            System.out.println(account);
        } catch (InvalidValueException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch(InputMismatchException e){
            System.out.println("Enter with only number values! ");
        }

        
    }

}