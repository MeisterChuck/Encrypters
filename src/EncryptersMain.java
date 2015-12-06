import java.util.Scanner;

public class EncryptersMain{

    // Private variables
    private static String word, key;
    private static Scanner scan = new Scanner( System.in );
    private static Encrypters encrypter;
    String encrypted;

    /**
     * Main method is used for testing and debugging the Encrypters object.
     *
     */
    public static void main( String[] args ){

        System.out.println( "\nEnter tweet to be encrypted:" );
        word = scan.nextLine();

        System.out.println( "\nEnter the key to encrypt from:" );
        key = scan.nextLine();

        // Debugging
        System.out.println( "-----------------------------" );
        System.out.println( "Tweet: " + word );
        System.out.println( "Key: " + key );
        System.out.println( "-----------------------------" );
        // End of debugging

        encrypter = new Encrypters( word, key );

    }   // End of main method

}   // End of public class EncryptersMain