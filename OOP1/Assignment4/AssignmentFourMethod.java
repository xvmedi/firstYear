import java.util.Scanner;
import java.util.Arrays;

public class AssignmentFourMethod {

    public static void assignmentMethod() {

        Scanner input = new Scanner(System.in);

        int i = 0; // counter variable
        int position = 0; // array position (used for iteration)

        // declare integer array (with 6 positions)
        int[] myList = new int[6];

        do {
            // prompt for Userinput assignmnment
            System.out.print("\nEnter Number: ");
            int userInput = input.nextInt();

            // assigning positions in array to check for redundancies (could also change
            // this to a for loop if array was larger)
            int userInput1 = myList[0];
            int userInput2 = myList[1];
            int userInput3 = myList[2];
            int userInput4 = myList[3];
            int userInput5 = myList[4];
            int userInput6 = myList[5];

            // valid range check (30-90 inclusive)
            if (userInput < 30 || userInput > 90) {
                System.out.println("number must be between 30 and 90");
            }

            // redundancies check
            else if (userInput == userInput1 || userInput == userInput2 || userInput == userInput3
                    || userInput == userInput4 || userInput == userInput5 || userInput == userInput6) {
                System.out.print(userInput + " is repeated! Not Acceptable");
            }

            // continue do-while loop
            else {

                myList[position] = userInput; // adding user input to iterating position variable

                position++; // itterate position
                i++; // itterate do-while loop

                // print list through iteration
                for (int j = 0; j < i; j++) {
                    System.out.print(myList[j] + " ");
                }

            }

        } while (i < myList.length); // condition do-while loop (based on counter (i) being less than lenth of array)

    } // end of class main
} // end of class