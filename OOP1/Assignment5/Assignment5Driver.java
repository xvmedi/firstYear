// an assignment about two savings accounts

import java.util.Scanner;

public class Assignment5Driver {

    public static double annualIntrestRate = 0.04; // accessible static intrest rate

    public static void main(String[] args) {

        SavingsAccount savings1 = new SavingsAccount(2000); // instanciate account 1 with $2000

        SavingsAccount savings2 = new SavingsAccount(3000); // instanciate account 2 with $3000

        try {

            // creating objects for the specific balances of each account
            double savings1Balance = savings1.getSavingsBalance();
            double savings2Balance = savings2.getSavingsBalance();

            // printing and formatting
            System.out.println("Monthly balances for one year at .04 Balances:\nSavings:");

            System.out.printf("                    %s" + "        %s\n", "Saver 1", "Saver 2");

            System.out.printf("Base" + "              $%.2f" + "     $%.2f\n", savings1Balance, savings2Balance);

            // for loop 1 used for printing monthly account growth. Addition assignments
            // create the increase per month.
            for (int month = 1; month <= 9; month++) {

                System.out.printf("Month " + month + ":      " + "  $" + "%.2f" + "     $" + "%.2f\n",
                        savings1Balance += savings1.calculateMonthlyInterest(savings1Balance),
                        savings2Balance += savings2.calculateMonthlyInterest(savings2Balance));
                // The calculateMonthlyInterest method is called with the balance variable and
                // then addition assigned to its respective balance
            }

            // for loop 2 used the same as for loop 1. It is needed for proper formatting.
            for (int monthh = 10; monthh <= 12; monthh++) {
                System.out.printf("Month " + monthh + ":     " + " $" + "%.2f" + " " + "    $" + "%.2f\n",
                        savings1Balance += savings1.calculateMonthlyInterest(savings1Balance),
                        savings2Balance += savings2.calculateMonthlyInterest(savings2Balance));
            }

            modifyInterestRate(0.05); // changing intrest rate

            System.out.println("\nAfter setting interest rate to .05 and calculating monthly interest\n \nBalances:");

            // printing the final annual outcome of investment
            System.out.printf("%s" + "      %s" + "\n$%.2f      $%.2f\n", "Savings1", "Savings2",
                    savings1Balance += savings1.calculateMonthlyInterest(savings1Balance),
                    savings2Balance += savings2.calculateMonthlyInterest(savings2Balance));

            modifyInterestRate(-0.02);

            System.out.printf("\n%s %d", "Number of Accounts Created is:", SavingsAccount.instanceCounter);

        } catch (IllegalArgumentException ex) { // error handling
            System.out.print("\n" + ex + "\n");
        }

        System.out.printf("%s %d", "Number of Accounts Created is:", SavingsAccount.instanceCounter);

    } // end of class main

    public static double modifyInterestRate(double newRate) {

        if (newRate < 0.00) { // if faulty input,, send to catch block as IllegalArgumentException

            System.out.print("\nTry to set interest rate to " + newRate + " and calculating monthly interest");

            throw new IllegalArgumentException("rate must be 0.0 - 1.0");
        }

        annualIntrestRate = newRate;
        return annualIntrestRate;

    }

}// end of driver class