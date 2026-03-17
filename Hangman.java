import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

        public static Scanner scan = new Scanner(System.in);

        public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
                        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
                        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
                        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
                        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
                        "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
                        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
                        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                        "wombat", "zebra" };

        public static String[] gallows = { "+---+\n" +
                        "|   |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n",

                        "+---+\n" +
                                        "|   |\n" +
                                        "O   |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "=========\n",

                        "+---+\n" +
                                        "|   |\n" +
                                        "O   |\n" +
                                        "|   |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "=========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|   |\n" +
                                        "     |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "     |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "/    |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "/ \\  |\n" +
                                        "     |\n" +
                                        " =========\n" };

        public static void main(String[] args) {
                String word = randomWord(words);
                System.out.println(word);
                char[] wordArray = word.toCharArray();

                char[] placeholders = new char[wordArray.length];
                for (int i = 0; i < placeholders.length; i++) {
                        placeholders[i] = '_';
                }

                int misses = 0;
                char[] missedGuess = new char[7];

                while (misses <= 7) {
                        if (misses == 6) {
                                System.out.println(gallows[misses]);
                                System.out.println("Out of guesses. You lose. The word was " + word + ".");
                                break;
                        } else if (Arrays.equals(placeholders, wordArray)) {
                                System.out.println(gallows[misses]);
                                System.out.print("Word: ");
                                printPlaceholders(placeholders);
                                System.out.println("\nYou win! Congratulations!");
                                break;
                        }

                        System.out.println(gallows[misses]);
                        System.out.print("Word: ");
                        printPlaceholders(placeholders);
                        System.out.println("\n");
                        System.out.print("Misses: ");
                        // print array of missed guesses

                        printMissedGuesses(missedGuess, false);

                        System.out.println("\n");
                        System.out.print("Guess: ");
                        String guess = scan.nextLine();
                        char[] guessArray = guess.toCharArray();

                        boolean check = checkGuess(wordArray, guessArray);

                        if (check == true) {
                                updatePlaceholders(placeholders, guessArray, wordArray);
                        }

                        else if (check != true) {
                                misses += 1;
                                missedGuess[misses] = guessArray[0];

                        }

                }
                scan.close();
        }

        public static String randomWord(String[] words) {
                double random = Math.random() * words.length;
                int randomCoversion = (int) random;
                String word = words[randomCoversion];
                return word;
        }

        public static boolean checkGuess(char[] wordArray, char[] guessArray) {
                for (int i = 0; i < wordArray.length; i++) {
                        if (guessArray[0] == wordArray[i]) {
                                return true;
                        }
                }
                return false;
        }

        public static void updatePlaceholders(char[] placeholders, char[] guessArray, char[] wordArray) {
                for (int i = 0; i < wordArray.length; i++) {
                        if (guessArray[0] == wordArray[i]) {
                                placeholders[i] = guessArray[0];
                        }
                }

        }

        public static void printPlaceholders(char[] placeholders) {
                for (int i = 0; i < placeholders.length; i++) {
                        System.out.print(placeholders[i] + " ");
                }

        }

        public static void printMissedGuesses(char[] missedGuess, boolean check) {
                if (check == false) {
                        System.out.print(missedGuess);
                }
        }
}
