import java.util.*;

/**
 * Requirements:
 * 1. Replace FirstName LastName in file and class names with your own names.
 * 2. Finish all TODOs. Test your code using provided main().
 * 3. Do NOT modify ANY provided code.
 * 
 * PROG24178 1231_18326
 * Junzhao Sun
 * Cristo Vasilaros
 * February 19th 2022
 * Assignment 3
 */

// A provided class representing Avenger
class Avenger {
    private long id;
    private String name;
    private double force;
    private double salary;

    public Avenger() {
    }

    public Avenger(long id, String name, double force, double salary) {
        this.id = id;
        this.name = name;
        this.force = force;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nAvenger{" + "id=" + id + ", name=" + name + ", force=" + force + ", salary=" + salary + "}";
    }
}

public class PROG24178_Assignment3_Vasilaros {

    public static void main(String[] args) {
        System.out.println("\n**. Testing methods using null...");
        System.out.println("== Best avenger is: " + AvengerOperator.getBestAvenger(null));
        System.out.println("== Costy avengers are: " + AvengerOperator.getCostyAvengers(null, 6000));
        System.out.println("== Removed " + AvengerOperator.removeWeakAvengers(null, 50.0));

        ArrayList<Avenger> avengers = new ArrayList<>();
        avengers.addAll(Arrays.asList(
                new Avenger(24171, "Captain America", 92.1, 8765.43),
                new Avenger(24172, "Black Widow", 81.2, 5678.90),
                new Avenger(24173, "Iron Man", 94.3, 7890.12),
                new Avenger(24174, "Spiderman", 90.4, 4567.89),
                new Avenger(24175, "Dr. Strange", 89.5, 6543.21),
                new Avenger(24176, "Hulk", 93.5, 5432.10),
                new Avenger(24177, "Thor", 92.5, 6789.01), null, null));
        System.out.println("\n**. Testing methods using avengers...");
        System.out.println("== Best avenger is: " + AvengerOperator.getBestAvenger(avengers));
        System.out.println("== Costy avengers are: " + AvengerOperator.getCostyAvengers(avengers, 7000));
        System.out.println("== Removed (min force = 92.0): " + AvengerOperator.removeWeakAvengers(avengers, 92.0)
                + ", current avengers are: " + avengers);

        System.out.println("== Removed (min force = 99.0): " + AvengerOperator.removeWeakAvengers(avengers, 99.0)
                + ", current avengers are: " + avengers);

        System.out.println("\n**. Testing methods using empty list...");
        avengers.clear();
        System.out.println("== Best avenger is: " + AvengerOperator.getBestAvenger(avengers));
        System.out.println("== Costy avengers are: " + AvengerOperator.getCostyAvengers(avengers, 6000));
        System.out.println("== Removed " + AvengerOperator.removeWeakAvengers(avengers, 50.0)
                + ", current avengers are: " + avengers);
    }
}

// A utility class containing 3 static methods for operating avenger list
class AvengerOperator {

    /* == Do NOT modify any code above this line == */

    /**
     * TODO #1: write a public method named getBestAvenger that,
     * given an array list of avengers as the argument, returns an
     * avenger whose force divided by salary is the highest, or returns
     * null if there is nothing to return
     */

    public static Avenger getBestAvenger(List<Avenger> avengers) {

        Avenger bestAvenger = null;

        if (avengers == null || avengers.isEmpty()) {
            return null;
        }

        double bestScore = 0;
        bestAvenger = avengers.get(0);

        for (Avenger a : avengers) {

            if (a == null) {
                continue;
            }

            // double thisScore = (a.getForce() / a.getSalary());
            // bestScore = (thisScore>bestScore) ? thisScore : bestScore;

            if (a != null && bestAvenger.getForce() / bestAvenger.getSalary() < a.getForce() / a.getSalary()) {
                bestAvenger = a;
            }

        }

        return bestAvenger;

    }

    /**
     * TODO #3: write a public method named removeWeakAvengers that,
     * given an array list of avengers and the minimum required force as two
     * arguments,
     * removes null avengers or those whose force is less than the minimum force,
     * and returns the number of avengers being removed
     */

    public static int removeWeakAvengers(List<Avenger> avengers, double minForce) {
        int numRemoved = 0;

        if (avengers != null && avengers.size() != 0) {

            for (int i = avengers.size() - 1; i > 0; i--) {

                if (avengers.get(i) == null || avengers.get(i).getForce() < minForce) {
                    avengers.remove(avengers.get(i));
                    numRemoved++;
                }

            }

        }

    } // End of AvengerOperator class
}