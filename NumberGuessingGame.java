import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(
                "Welcome to the number guessing game! You have 10 attempts to guess the correct number generated that's between 1 - 100");

        int random = getRandomNumber();
        System.out.println(random);

        for (int i = 1; i < 11; i++) {
            System.out.print(i + ". Guess: ");
            int guess = scan.nextInt();

            if (guess == random) {
                System.out.println("Congratulations! You guessed the correct number!");
                break;
            } else if (guess > random) {
                System.out.println("Too high! Guess lower!\n");
            } else {
                System.out.println("Too low! Guess higher!\n");
            }

            if (i == 10) {
                System.out.println(
                        "Sorry, you are out of guesses. The correct number is " + random + ". Please try again!");
            }

        }
        scan.close();
    }

    public static int getRandomNumber() {
        int num = (int) (Math.random() * 100) + 1;
        return num;
    }
}
