import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        // Task 3 – Wait for the user to press enter.
        scan.nextLine();
        // Task 4 – Get two random cards.
        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        String card1 = cardString(playerCard1);
        String card2 = cardString(playerCard2);

        // – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>
        System.out.println("\nYou get a \n" + card1 + "\n and a \n" + card2);

        // Task 5 – Print the sum of your hand value.
        // – print: your total is: <hand value>
        int playerTotal = (Math.min(playerCard1, 10) + Math.min(playerCard2, 10));
        System.out.println("Your total is: " + playerTotal);

        // Task 6 – Get two random cards for the dealer.
        // – Print: The dealer shows \n" + <first card> + "\nand has a card facing down
        // \n" + <facedown card>
        // – Print: \nThe dealer's total is hidden
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        String card3 = cardString(dealerCard1);
        String card4 = cardString(dealerCard2);

        System.out.println("The dealer shows \n" + card3 + "\n and has a card facing down \n" + faceDown());

        System.out.println("\nThe dealer's total is hidden");

        // Task 8 – Keep asking the player to hit or stay (while loop).
        // 1. Every time the player hits
        // – draw a new card.
        // – calculate their new total.
        // – print: (new line) You get a (new line) <show new card>.
        // - print: your new total is <total>

        // 2. Once the player stays, break the loop.

        // For tasks 9 to 13, see the article: Blackjack Part II.
        String choice = hitOrStay();
        while (true) {
            if (choice.equals("hit")) {
                int newPlayerCard = drawRandomCard();
                playerTotal += Math.min(newPlayerCard, 10);
                System.out.println("\nYou get a \n" + cardString(newPlayerCard));
                System.out.println("Your new total is " + playerTotal);
                if (playerTotal > 21) {
                    System.out.println("Bust! Player loses.");
                    System.exit(0);
                }
            } else {
                break;
            }
            choice = hitOrStay();
        }

        System.out.println("\nDealer's turn.\n");
        System.out.println("The dealer's cards are\n " + card3 + "\nand a \n" + card4);
        int dealerTotal = (Math.min(playerCard1, 10) + Math.min(playerCard2, 10));

        while (dealerTotal < 17) {
            int newDealerCard = drawRandomCard();
            dealerTotal += Math.min(newDealerCard, 10);
            System.out.println("\nDealer gets a\n" + cardString(newDealerCard));
            System.out.println("\nDealer's total is " + dealerTotal);
            if (dealerTotal >= 17) {
                break;
            } else if (dealerTotal > 21) {
                System.out.println("Bust! Dealer loses.");
                System.exit(0);
            }
        }

        if (playerTotal > dealerTotal) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }

        scan.close();

    }

    /**
     * Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * 
     * @return (int)
     *
     *         Inside the function:
     *         1. Gets a random number between 1 and 13.
     *         2. Returns a card.
     */

    public static int drawRandomCard() {
        int draw = (int) (Math.random() * 13) + 1;
        return draw;
    }

    /**
     * Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     * 
     * @param cardNumber (int)
     * @return (String)
     *
     *         Inside the function:
     *         1. Returns a String drawing of the card.
     */

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";

            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";

            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";

            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";

            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";

            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";

            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";

            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default:
                return " ";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    /**
     * Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Asks the user to hit or stay.
     *         2. If the user doesn't enter "hit" or "stay", keep asking them to try
     *         again by printing:
     *         Please write 'hit' or 'stay'
     *         3. Returns the user's option
     */
    public static String hitOrStay() {
        System.out.print("Would you like to hit or stay? ");
        String playerChoice = scan.nextLine();
        while (true) {
            if (playerChoice.equalsIgnoreCase("hit") || playerChoice.equalsIgnoreCase("stay")) {
                break;
            } else {
                System.out.println("Please write 'hit' or 'stay'");
                playerChoice = scan.nextLine();
            }
        }
        return playerChoice;

    }
}
