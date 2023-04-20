/*
1.) Write a program that prompts the user to enter the number of students
    * and each student’s name and
    * score, and finally displays the name of the student with the highest score.
    * Use the next() method in the
    * Scanner class to read a name, rather than using the nextLine() method.

2.) Write a program that prompts the user to enter the number of students and
    * each student’s name
    * and score, and finally displays the student with the highest score and the
    * student with the second-
    * highest score. Use the next() method in the Scanner class to read a name
    * rather than using the
    * nextLine() method
    */
import java.util.Scanner;

public class TestThis {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int i = 0;
        int numStudents = 0;
        String studentName1 = "test";
        String bestStudent = "";
        double highScore = 0;
        double newScore = 0;

        System.out.print("enter number of students: ");
        numStudents = input.nextInt();

        while (i < numStudents) {

            System.out.print("enter student name:");
            studentName1 = input.next();

            System.out.println(studentName1);

            System.out.print("enter student score:");
            newScore = input.nextDouble();
            System.out.println(newScore);

            if (newScore > highScore) {
                bestStudent = studentName1;
                highScore = newScore;
            } else {
                System.out.print("Hello");
            }

            ++i;
        }

        System.out.print(bestStudent + " has the high score of " + highScore);


    }// end of class main
}