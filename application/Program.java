package application;

import model.entities.Account;
import model.exceptions.WithdrawException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = scanner.nextInt();
            System.out.print("Holder: ");
            scanner.nextLine();
            String holder = scanner.nextLine();
            System.out.print("Initial balance: ");
            double balance = scanner.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = scanner.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);

            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        }
        catch (WithdrawException e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        finally {
            scanner.close();
        }
    }
}