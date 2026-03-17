//import Scanner

import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {

        // Set up scanner.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello. What is your name?");
        // Pick up user's name and store it.
        String name = scanner.nextLine();

        System.out.println("\nHi " + name + "! I'm Javabot. Where are you from?");
        
        // Pick up user's home and store it.
        String location = scanner.nextLine();

        System.out.println("\nI hear it's beautiful at " + location + "! I'm from a place called Oracle");
        System.out.println("\nHow old are you?");
        
        // Pick up age and store it.
        int age = scanner.nextInt();

        System.out.println("\nSo you're" + age + ", cool! I'm 400 years old.");
        System.out.println("This means I'm " + (400 / age) + " times older than you.");
        System.out.println("\nEnough about me. What's your favourite language? (just don't say Python)");
        
        // Pick up language and store it.
        scanner.nextLine();
        String language = scanner.nextLine();

        System.out.println(
                language + ", that's great! Nice chatting with you " + name + ". I have to log off now. See ya!");

        // close scanner.
        scanner.close();

    }
}
