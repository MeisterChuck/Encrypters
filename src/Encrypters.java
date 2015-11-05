import java.util.Scanner;

public class Encrypters{

	private static final char[] decoderLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static int[] decoderLetterPlacement; 
	private static String word;
	private static String key;
	private static int keyInt;
	private static int temp = 1;
	private static int index = 0;
	private static char keyChar;

	private static StringBuilder encryptedWord;

	public static void main( String[] args ){

		Scanner scan = new Scanner( System.in );
		decoderLetterPlacement = new int[ 26 ];

		System.out.println( "Enter a word to encrypt" );
		word = scan.nextLine().toUpperCase().replaceAll( "\\s", "" );
		
		// Create decoderLetterPlacement
		for( int i = 0; i < decoderLetterPlacement.length; i++ ){
			
			decoderLetterPlacement[ i ] = temp;
			temp++;
			
		}   // End of for-loop
				
		System.out.println( "Enter the key to be used" );
		key = scan.nextLine().toUpperCase();
		//temp = Integer.parseInt( key );

		System.out.println( "\n" + word );
		System.out.println( "Word length is " + word.length() );
		System.out.println( "Key is " + key );


		System.out.printf("\nTesting method\n");
		encryptCeasar( word, key );
		System.out.println( "Encrypted StringBuilder is " + encryptedWord );
		

	}   // End of main method

	// Encrypts word with key using a Ceasar encryption
	public static String encryptCeasar( String encryptMe, String key ){

		encryptedWord = new StringBuilder( encryptMe );

		// Try-catch used so user can input either a number or letter
		try{

			keyInt = Integer.parseInt( key );
			index = keyInt;

		} catch( NumberFormatException e){

			keyChar = key.toUpperCase().charAt( 0 );
			keyInt = keyChar - 64;

		}   // End of try-catch statement

		System.out.printf( "Attempting to encrypt %s\n", encryptMe );
		System.out.printf( "Numerical placement of key: %s is at %d\n\n", key, keyInt );
		
		for( int encryption = 0; encryption < encryptMe.length(); encryption++ ){

			temp = keyInt;

			System.out.printf( "For-loop %d, temp is %d\n", encryption, temp );
			System.out.print( "The letter being encypted is " + encryptMe.charAt( encryption ) + "\n" );

			for( int codex = 0; codex < decoderLetters.length; codex++ ){

				System.out.printf( "\tFor-loop %d\n", codex );

				if( encryptMe.charAt( encryption ) == decoderLetters[ codex ] ){

					System.out.printf( "\t\tLetter %d is at %d\n", encryption+1, codex+1 );

					while( temp >= 0 ){

						System.out.printf("\t\t\t temp is %d\n", temp);

						codex++;

						if( codex == decoderLetters.length ){

							codex = 0;

						}

						encryptedWord.setCharAt( encryption, decoderLetters[ codex ] );

						System.out.printf( "\t\t\t\tCodex is at " + codex + "\n" );

						temp--;

					}

					break;   // If found, end nested for-loop

				}   // End of if-statement

			}   // End of nested for-loop
			
		}   // End of for-loop

		return encryptedWord.toString();
		
	}

	public static void decryptCeasar( StringBuilder decryptMe ){



	}

}   // End of class Encrypters