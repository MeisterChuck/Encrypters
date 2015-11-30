import java.util.Scanner;

public class EncryptersMain{

    // Private variables
    private static String word, key;
    private static Scanner scan = new Scanner( System.in );
    private static Encrypters encrypter;

    /**
     * Main method is used for testing and debugging the Encrypters object.
     *
     */
    public static void main( String[] args ){

        System.out.println( "\nEnter what you want to encrypt:" );
        word = scan.nextLine();

        System.out.println( "\nPlease enter the key to encrypt from:" );
        key = scan.nextLine();

        // Debugging
        System.out.printf( "\nWord or Phrase: %s\nKey: %s\n", word, key );

        encrypter = new Encrypters( word, key );

    }   // End of main method

}   // End of public class EncryptersMain
