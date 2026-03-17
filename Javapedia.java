import java.util.Arrays;
import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        
        // Ask the user: how many historical figures will you register?
        int figures = scan.nextInt();

        // Create a 2D array with a variable number of rows, and 3 values per row.
        String[][] database = new String[figures][3];

        scan.nextLine();

        for (int i = 0; i < database.length; i++) {
            System.out.println("\n\tFigure " + (i + 1));

            System.out.print("\t - Name: ");
            String name = scan.nextLine();
            database[i][0] = name;

            System.out.print("\t - Date of birth: ");
            String birthdate = scan.nextLine();
            database[i][1] = birthdate;

            System.out.print("\t - Occupation: ");
            String occupation = scan.nextLine();
            database[i][2] = occupation;

            System.out.print("\n");
        }

        System.out.println("These are the values you stored:");
        // Call print2DArray.
        print2DArray(database);

        System.out.print("\n\nWho do you want information on? ");

        /*
         * Let the user search the database by name.
         * If there's a match:
         * print( tab of space Name: <name>)
         * print( tab of space Date of birth: <date of birth>)
         * print( tab of space Occupation: <occupation>)
         * 
         */
        String infomation = scan.nextLine();
        for (int i = 0; i < database.length; i++) {
            if (database[i][0].equals(infomation)) {
                System.out.println("\tName: " + database[i][0]);
                System.out.println("\tBirthdate: " + database[i][1]);
                System.out.println("\tOccupation: " + database[i][2]);
            }
        }

        scan.close();
    }

    /**
     * Function name: print2DArray
     * 
     * @param array (String[][])
     * 
     *              Inside the function
     *              1. print the database
     *              • a tab of space precedes each row.
     *              • each value in database has one space from the other value.
     *              • print a new line.
     */
    public static void print2DArray(String[][] database) {
        for (int i = 0; i < database.length; i++) {
            System.out.println("\t");
            for (int j = 0; j < database[i].length; j++) {
                System.out.print(database[i][j] + " ");
            }
        }
    }
}
