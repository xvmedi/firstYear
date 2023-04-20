import java.util.*;

/**
 * Requirements:
 * 1. Replace LastName in file and class names with your own names.
 * 2. Finish all TODOs. Test your code before submitting it.
 * 3. Do NOT modify ANY provided code.
 */

// A provided class representing a general game
class Game {
    private String name;
    private int numberOfPlayers;

    public Game() {
    }

    public Game(String name, int numberOfPlayers) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
} // End of Game class

public class PROG24178_Assignment2_Vasilaros {
    private static int tN = 0, pP = 0, fF = 0, tT = 32;

    private static void tout(boolean re) {
        System.out.println(" -Test#" + (++tN) + ": " + (re ? "passed" : "failed"));
        if (re)
            pP++;
        else
            fF++;
    }

    private static void sout(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception ex) {
            sout("  *Exception: " + ex);
        }
        sout("== Total:" + tT + ", Passed:" + pP + ", Failed:" + fF + ", Skipped:" + (tT - pP - fF));
    }

    public static void test() throws Exception {
        Game[] games = null;
        try {
            sout("\n== Testing countCardGames()...");
            games = new Game[] {
                    new CardGame("a", 2, 0), new CardGame("b", 3, 1),
                    new CardGame("c", 3, 2), new CardGame("d", 2, 3),
                    new Game(), new VideoGame() };
            tout(countCardGames(games, 4) == 0);
            tout(countCardGames(games, 3) == 1);
            tout(countCardGames(games, 1) == 3);
            tout(countCardGames(null, -1) == 0);
            tout(countCardGames(new Game[0], 0) == 0);
            tout(countCardGames(new Game[] { null, new CardGame() }, 0) == 1);
            tout(countCardGames(new Game[] { null, new CardGame("b", 3, 2) }, 2) == 1);
            tout(countCardGames(new Game[] { null, null }, -1) == 0);
            games = new Game[] { new Game("abc", 2), null, new Game(null, 2),
                    new VideoGame(null, 3, "ipad"), new CardGame("klm", 2, 3),
                    new VideoGame("xyz", 3, null), new CardGame(null, 2, 4),
                    new VideoGame(null, 3, null), new CardGame("klm", 2, 1) };
            tout(countCardGames(games, 2) == 2);
        } catch (Exception ex) {
            sout("  *Exception: " + ex);
        }

        try {
            sout("\n== Testing capitalizeStrings()...");
            games = new Game[] { new Game("abc", 2), new VideoGame("xyz", 2, "phone"),
                    new Game("xyz", 3), new VideoGame("def", 3, "ipad"),
                    new CardGame("klm", 2, 1) };
            tout(capitalizeStrings(games) == 5);
            tout(games[0].getName().equals("ABC"));
            tout(games[1].getName().equals("XYZ"));
            tout(((VideoGame) games[1]).getDevice().equals("PHONE"));
            tout(games[2].getName().equals("XYZ"));
            tout(games[3].getName().equals("DEF"));
            tout(((VideoGame) games[3]).getDevice().equals("IPAD"));
            tout(games[4].getName().equals("KLM"));
            tout(capitalizeStrings(null) == 0);
            tout(capitalizeStrings(new Game[0]) == 0);
            games = new Game[] { new Game("abc", 2), null, null,
                    new VideoGame("def", 3, "ipad"), new CardGame("klm", 2, 1) };
            tout(capitalizeStrings(games) == 3);
            tout(games[0].getName().equals("ABC"));
            tout(((VideoGame) games[3]).getDevice().equals("IPAD"));
            tout(games[4].getName().equals("KLM"));
            games = new Game[] { new Game("abc", 2), null, new Game(null, 2),
                    new VideoGame(null, 3, "ipad"), new CardGame("klm", 2, 1),
                    new VideoGame("xyz", 3, null), new CardGame(null, 2, 1),
                    new VideoGame(null, 3, null), new CardGame("klm", 2, 1) };
            tout(capitalizeStrings(games) == 5);
            tout(games[3].getName() == null);
            tout(((VideoGame) games[3]).getDevice().equals("IPAD"));
            tout(games[4].getName().equals("KLM"));
            tout(games[5].getName().equals("XYZ"));
            tout(((VideoGame) games[5]).getDevice() == null);
            tout(games[7].getName() == null);
            tout(((VideoGame) games[7]).getDevice() == null);
            tout(games[8].getName().equals("KLM"));
        } catch (Exception ex) {
            sout("  *Exception: " + ex);
        }
        sout("\n** Testing Finished **");
    }

    /* ==== Do NOT modify any code above this line ==== */

    /*
     * + TODO #3: write a public static method named countCardGames that will
     * - take an array of games and an int minNumCards as the arguments
     * - go over the games in the array, count the number of card games in the
     * array which have a number of cards no less than the minNumCards
     * - return the count
     * - NOTE: array and elements in array can be null
     * - NOTE: any element in the array may be or not be a card game.
     */

    public static int countCardGames(Game[] game, int minNumCards) {

        // validation
        if (game == null)
            return 0;
        // return (Integer) null;

        int count = 0; // counter

        for (Game g : game) // loop through argument array of games

            // scenario one null validation
            if (g == null)
                continue; // to next game in array

            // if is card game
            else if (g instanceof CardGame) {
                CardGame cardG = (CardGame) g; // cast into card game

                if (cardG.getNumberOfCards() >= minNumCards) // requirement check
                    count++; // counter iteration
            }

        return count;
    }

    /*
     * + TODO #4: write a public static method named capitalizeStrings that will
     * - take an array of games as the argument
     * - go over the games in the array, capitalize the names of all games
     * - also capitalize the device type, if the game is a video game
     * - return the number of games that have been modified
     * - Example 1: if current game name is "Chess", then new name is "CHESS"
     * - Example 2: if current device is "phone", then new device is "PHONE"
     * - NOTE: argument array, elements and values may be null
     */

    public static int capitalizeStrings(Game[] games) {
        // validation
        if (games == null)
            return 0;

        int counter = 0;

        for (Game g : games) { // loop through array of games

            boolean check = false; // to check for counter

            // empty case scenario
            if (g == null) {
                continue;
            }

            // if video scenario
            else if (g instanceof VideoGame) {

                VideoGame videoG = (VideoGame) g; // cast into video game

                if (videoG.getDevice() != null) { // device not null ?
                    videoG.setDevice(videoG.getDevice().toUpperCase()); // set to upper
                    check = true; // check counter
                }

                if (g.getName() != null) { // name not null?
                    g.setName(g.getName().toUpperCase()); // set to upper
                    check = true; // check counter
                }

            }

            // regular case scenario (not video game)
            else if (g.getName() != null) { // name not null?
                g.setName(g.getName().toUpperCase()); // set to upper
                check = true; // check counter
            }

            if (check == true)
                counter++; // iterate
        }

        // return counter
        return counter;
    }

} // End of PROG24178_Assignment2_Lastname class

/*
 * + TODO #1: write a CardGame class, a subclass of Game class that has
 * - a private field of int type named exactly as numberOfCards
 * - a no-arg constructor
 * - a all-arg constructor that takes 3 parameters, name, numberOfPlayers, and
 * numberOfCards
 * - the get and set methods for numberOfCards, follow convention to name the
 * methods
 */

class CardGame extends Game {

    private int numberOfCards;

    CardGame() {
    };

    CardGame(String name, int numberOfPlayers, int numberOfCards) {
        super(name, numberOfPlayers);
        this.numberOfCards = numberOfCards;
    };

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

}

/*
 * + TODO #2: write a VideoGame class, a subclass of Game class that has
 * - a private field of String type named exactly as device
 * - this field is used to represent the primary device for playing the game
 * - the value can be for example Desktop, Phone, iPad, etc.
 * - a no-arg constructor
 * - a all-arg constructor that takes 3 parameters, name, numberOfPlayers, and
 * device
 * - the get and set methods for device, follow convention to name the methods
 */

class VideoGame extends Game {

    private String device;

    VideoGame() {
    }

    VideoGame(String name, int numberOfPlayers, String device) {
        super(name, numberOfPlayers);
        this.device = device;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

}
