// i lost the prompt
// this program i think had something to do with books 

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        // instanciate scanner class
        Scanner input = new Scanner(System.in);

        // sentinel-controller for while value
        boolean systemOn = true;

        // read in book values
        final double book1 = 20.85;
        final double book2 = 14.50;
        final double book3 = 19.30;
        final double book4 = 41.25;
        final double book5 = 61.65;

        // quantity variables for respective books; to be used in switch
        int quantitySoldBook1;
        int quantitySoldBook2;
        int quantitySoldBook3;
        int quantitySoldBook4;
        int quantitySoldBook5;

        int bookId = 1;

        // every run total is at 0
        double totalSold = 0;

        while (systemOn == true) {

            System.out.print("Enter bookId (1-5 or 0 to stop): ");
            bookId = input.nextInt();

            // catch faulty input error, make case 6 of switch
            if (0 > bookId || bookId > 5) {
                bookId = 6;
            }

            // begin switch for bookId
            switch (bookId) {

                // kill-switch
                case 0: {
                    systemOn = false;
                    break;
                }

                // 1. prompt user for input 2. input assigned to respective quantity variable 3.
                // calculate n of book sold * respective price variabe 4. addition assignment
                // opperator to add each value to grand total

                case 1: {
                    System.out.print("Enter book quantity sold: ");
                    quantitySoldBook1 = input.nextInt();
                    double saleValueBook1 = quantitySoldBook1 * book1;
                    totalSold += saleValueBook1;
                    break;
                }

                case 2: {
                    System.out.print("Enter book quantity sold: ");
                    quantitySoldBook2 = input.nextInt();
                    double saleValueBook2 = quantitySoldBook2 * book2;
                    totalSold += saleValueBook2;
                    break;
                }

                case 3: {
                    System.out.print("Enter book quantity sold: ");
                    quantitySoldBook3 = input.nextInt();
                    double saleValueBook3 = quantitySoldBook3 * book3;
                    totalSold += saleValueBook3;
                    break;
                }

                case 4: {
                    System.out.print("Enter book quantity sold: ");
                    quantitySoldBook4 = input.nextInt();
                    double saleValueBook4 = quantitySoldBook4 * book4;
                    totalSold += saleValueBook4;
                    break;
                }

                case 5: {
                    System.out.print("Enter book quantity sold: ");
                    quantitySoldBook5 = input.nextInt();
                    double saleValueBook5 = quantitySoldBook5 * book5;
                    totalSold += saleValueBook5;
                    break;
                }

                // faulty case
                case 6: {
                    System.out.println("Book number must be between 1 and 5 or 0 to stop");
                    break;
                }
            }
        }
        // print output for total sold within a day or run
        System.out.printf("%s%.2f", "Total of all books sold for the day is: $", totalSold);

    } // end of class main
}