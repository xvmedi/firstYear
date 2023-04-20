
/* Name: Cristo Vasilaros
* Class: PROG24178 1231_18326, Winter 2023
* Assignment: Assignment #1 – Classes, Objects, Arrays
* Date: January 21, 2023
* Program: PROG24178_Assignment1_Vasilaros.java
* Displays Array functions for the person class (for spiderman)
/**
 * Requirements:
 * 1. Replace LastName in file and class names with your own name.
 * 2. Finish all TODOs. Test your code before submitting it.
 * 3. Do NOT modify ANY provided code.
 */
import java.util.*;

public class PROG24178_Assignment1_Vasilaros {
    public static void main(String[] args) {
        int pass = 0, total = 15;
        Person spiderman = new Person("Spiderman", 18);
        if (spiderman.getNumOfFriends() == 0
                && !spiderman.removeFriend(null)
                && !spiderman.removeFriend("Spiderman")
                && spiderman.getAllFriendNames() == null)
            System.out.println("Pass #1: " + (++pass));
        if (!spiderman.addFriend(null)
                && !spiderman.addFriend(new Person(null, 23)))
            System.out.println("Pass #2: " + (++pass));

        if (spiderman.addFriend(new Person("MJ", 18))
                && spiderman.addFriend(new Person("Ned", 18))
                && spiderman.addFriend(new Person("Hulk", 27)))
            System.out.println("Pass #3: " + (++pass));
        if (spiderman.getNumOfFriends() == 3
                && spiderman.getAllFriendNames().length == 3)
            System.out.println("Pass #4: " + (++pass));
        if (spiderman.getAllFriendNames()[0].equals("MJ")
                && spiderman.getAllFriendNames()[1].equals("Ned")
                && spiderman.getAllFriendNames()[2].equals("Hulk"))
            System.out.println("Pass #5: " + (++pass));
        if (!spiderman.removeFriend("Thanos")
                && spiderman.removeFriend("Ned")
                && !spiderman.removeFriend("Ned"))
            System.out.println("Pass #6: " + (++pass));
        if (spiderman.getNumOfFriends() == 2
                && spiderman.getAllFriendNames().length == 2)
            System.out.println("Pass #7: " + (++pass));
        if (!spiderman.addFriend(new Person("Hulk", 27)))
            System.out.println("Pass #8: " + (++pass));
        if (spiderman.addFriend(new Person("Thor", 28))
                && spiderman.addFriend(new Person("Ironman", 35))
                && spiderman.addFriend(new Person("Dr. Strange", 32)))
            System.out.println("Pass #9: " + (++pass));
        if (spiderman.getNumOfFriends() == 5
                && spiderman.getAllFriendNames().length == 5)
            System.out.println("Pass #10: " + (++pass));
        if (!spiderman.addFriend(new Person("Superman", 33)))
            System.out.println("Pass #11: " + (++pass));
        if (spiderman.removeFriend("Thor")
                && spiderman.removeFriend("Ironman"))
            System.out.println("Pass #12: " + (++pass));
        if (spiderman.getNumOfFriends() == 3
                && spiderman.getAllFriendNames().length == 3)
            System.out.println("Pass #13: " + (++pass));
        if (spiderman.removeFriend("Hulk")
                && spiderman.removeFriend("MJ")
                && !spiderman.removeFriend("Hulk"))
            System.out.println("Pass #14: " + (++pass));
        if (spiderman.getNumOfFriends() == 1
                && spiderman.getAllFriendNames().length == 1
                && spiderman.getAllFriendNames()[0].equals("Dr. Strange"))
            System.out.println("Pass #15: " + (++pass));
        System.out.println("\nPass/Total = " + pass + "/" + total);
        System.out.println(spiderman);
    }
}

class Person {
    private String name;
    private int age;
    private Person[] friends;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        friends = new Person[5]; // assume maximum 5 possible friends
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person[] getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' +
                ", age=" + age + ", friends=" + Arrays.toString(friends) + '}';
    }

    /* ==== Do NOT modify any code above this line ==== */

    /**
     * TODO #1 - write a public method named getNumOfFriends that
     * - accepts no argument
     * - return the number of friends of this person (can be 0-5)
     */

    public int getNumOfFriends() {

        // counter variable
        int totalFriends = 0;

        // iterate over friends and count
        for (int i = 0; i < friends.length; i++) {
            if (friends[i] != null)
                totalFriends++;
        }

        return totalFriends;

    }

    /**
     * TODO #2 - write a public method named addFriend that
     * - accepts a person as the argument
     * - adds this person to the friends array
     * - returns true if the person is added successfully, otherwise returns false
     * - Note: a person can be added as a friend only when it is a valid person with
     * a valid name
     * - Note: return false if the person is already a friend or the friend array is
     * full
     */

    public boolean addFriend(Person person) {

        // validation for list null, name null
        if (person == null || person.getName() == null) {
            return false;
        }

        // iterate over friends array initailly (for the first time)
        for (int i = 0; i < friends.length; i++) {

            // if [i] is null continue to next iteration
            if (friends[i] == null) {
                continue;
            }

            // if [i]'s name is the inputted name, name exists vaidation blocks redundant
            // names/objects
            if (friends[i].getName().equals(person.getName())) {
                return false;
            }

        } // redundant check complete

        // iterate over friends array again to continue friend adding proccess
        for (int i = 0; i < friends.length; i++) {

            // if the position is not filled / null
            if (friends[i] == null) {

                // add object Person to array at this [i] position
                friends[i] = person;
                return true; // check
            }

        }
        return false; // not added
    }

    /**
     * TODO #3 - write a public method named removeFriend that
     * - accepts a string as the argument
     * - removes the friend of the specified name from the friends array
     * - returns true if the friend is successfully removed, otherwise returns false
     */

    public boolean removeFriend(String name) {

        // validation for null list, 0 length
        if (friends == null || friends.length == 0) {
            return false;
        }
        // iterate over firneds list
        for (int i = 0; i < friends.length; i++) {

            // skip null cases initially
            if (friends[i] == null)
                continue;

            // object of removal located
            if (friends[i].getName().equals(name)) {

                // list shift if taken from middle of list
                if (friends[i + 1] != null) {
                    friends[i] = friends[i + 1];
                    friends[i + 1] = null;
                }

                // list shift if taken from middle of list
                if (friends[i + 2] != null) {
                    friends[i + 1] = friends[i + 2];
                    friends[i + 2] = null;
                }
                return true; // friend removed
            }
        }
        return false; // operation failed
    }

    /**
     * TODO #4 - write a public method named getAllFriendNames that
     * - accepts no argument
     * - returns an array of strings containing all friends' names, or returns null
     * if no name to return
     * - Note: the length of the returned array must be exactly the same as the
     * number of friend names
     */

    public String[] getAllFriendNames() {

        // null validation for null lists, 0 length, position [0] at null
        if (friends == null || friends.length == 0 || friends[0] == null) {
            return null;
        }

        // initialize a new string array with length this.obj number of current friends
        // list length
        String[] friendList = new String[getNumOfFriends()];

        // iterate over friends list
        for (int i = 0; i < friendList.length; i++) {

            // if friends at [i] position are not null
            if (friends[i] != null)

                // add friends[i]'s name to new String array friendsList[i]
                friendList[i] = friends[i].getName();
        }

        return friendList; // return new String array for names
    }

} // End of Person class