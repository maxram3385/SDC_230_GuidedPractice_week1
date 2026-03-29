import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Name: Max Ramos
 * Date of Development: 03/29/2026
 * Assignment: SDC230 Week 4 PA - Account Balance Calculations
 * Description of Class:
 * This program asks the user for a starting balance and then allows
 * the user to enter credits or debits until 0 is entered to quit.
 * It demonstrates the use of a user-defined exception when a debit
 * would make the account balance negative, and it handles
 * InputMismatchException when a non-numeric value is entered.
 */

public class PA_46_AccountBalanceCalculations {

    // User-defined exception
    static class NegativeBalanceException extends Exception {
        public NegativeBalanceException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance = 0.0;

        System.out.println("Max Ramos - Week 4 PA Account Balance Calculations");
        System.out.println();

        // Get starting balance
        System.out.print("Please enter the starting balance: ");
        balance = input.nextDouble();

        while (true) {
            try {
                System.out.print("\nPlease enter a credit or debit amount (0 to quit): ");
                double amount = input.nextDouble();

                if (amount == 0) {
                    break;
                }

                // If debit would make balance negative, throw custom exception
                if (balance + amount < 0) {
                    throw new NegativeBalanceException(
                        "Amount entered will cause account to go negative."
                    );
                }

                balance += amount;
                System.out.printf("The updated balance is: %.2f%n", balance);

            } catch (NegativeBalanceException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Please enter a numeric value.");
                input.next(); // clears the invalid input
            }
        }

        System.out.printf("The updated balance is: %.2f%n", balance);

        input.close();
    }
}