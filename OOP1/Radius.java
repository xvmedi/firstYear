import java.util.Scanner;

public class Radius {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final double PI = 3.14159;
        double radius;
        double area;

        // assign radius
        System.out.println("enter a radius:");
        radius = input.nextDouble();

        // compute
        area = radius * radius * PI;

        // display results
        System.out.println("the area for the circle is " + area);

    }

}