import java.util.Arrays;

public class Encrypters{

	// Private variables
	private static final char[] decoderLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static int[] encryptionKey;
	private static StringBuilder encrypted;
	private static StringBuilder convertKey;
	private static int keyIndex = 0;
	private static int index = 0;
	private static boolean hit = false;

	/**
	 * Public constructor Encrypter takes a string and key. It then sets a StringBuilder to equal
	 * the string which the constructor then modifies by converting all letters to uppercase and
	 * removing all spaces.
	 *
	 * @param String encryptMe
	 * @param String key
	 *
	 */
	public Encrypters( String encryptMe, String key ){

		encrypted = new StringBuilder( encryptMe.toUpperCase().replaceAll( "\\s", "" ) );

		System.out.printf( "\nFrom Encrypter:\n\n\tStringBuilder: %s\n\tKey: %s", encrypted, key );   // Debugging
		System.out.println( "\n\tDecoder Letters: " + Arrays.toString( decoderLetters ) );			  // Debugging

		// Convert key to StringBuilder to group then convert the StringBuilder to a int array for proper indexes.
		encryptionKey = new int[ key.length() ];

		for( int i = 0; i < key.length(); i++ ){

			if( Character.isLetter( key.charAt( i ) ) ){

				encryptionKey[ i ] = key.toUpperCase().charAt( i ) - 64;

			}else{

				encryptionKey[ i ] = key.charAt( i ) - 48;

			}   // End of if-else statement

		}   // End of for-loop

		encryption( encrypted, encryptionKey );

		System.out.printf( "\n\n\tThe encrypted word is %s\n", encrypted );   // Debugging

	}   // End of constructor for Encrypter

	/**
	 * Private static method encryption takes either a word or phrase modified by the constructor
	 * and using a user provided key, encrypts using a Vigenère cipher.
	 *
	 * @param StringBuilder encrypted
	 * @param int[] key
	 *
	 * @return encrypted
	 *
	 */
	private static StringBuilder encryption( StringBuilder encrypted, int[] key ){

		System.out.printf( "\n\t\t\tFrom encryption:\n\n\t\t\t\tEncryption Key: %s", Arrays.toString( encryptionKey ) );   // Debugging

		for( int encryptionIndex = 0; encryptionIndex < encrypted.length(); encryptionIndex++ ){

			if( encryptionIndex == 0 && ( encrypted.charAt( 0 ) == '@' || encrypted.charAt( 0 ) == '#' ) ){

				encryptionIndex = 1;

			}

			// Debugging
			System.out.printf( "\n\t\t\t\t***********************************************************************************************" );   // Debugging
			System.out.printf( "\n\t\t\t\tEncryption Index: %d", encryptionIndex );																// Debugging
			System.out.printf( "\n\t\t\t\tDecoder Letters: %s", Arrays.toString( decoderLetters ) );											// Debugging
			System.out.printf("\n\n\t\t\t\tEncrypting: %s using %s", encrypted.charAt( encryptionIndex ), key[ keyIndex ] );					// Debugging

			while( !hit ){

				if( encrypted.charAt( encryptionIndex ) == decoderLetters[ index ] ){

					System.out.printf( "\n\n\t\t\t\t\t%s equals %s", encrypted.charAt( encryptionIndex ), decoderLetters[ index ] );						    // Debugging
					System.out.printf( "\n\t\t\t\t\t%s equals %s", encrypted.charAt( encryptionIndex ), decoderLetters[ ( index + key[ keyIndex ] ) % 26 ] );   // Debugging

					try{

						// This is where the encryption happens
						encrypted.setCharAt( encryptionIndex, decoderLetters[ ( index + key[ keyIndex ] ) % 26 ] );

						System.out.printf( "\n\n\t\t\t\t\t%s\n", encrypted );   // Debugging

					}catch( ArrayIndexOutOfBoundsException e ){

						System.out.println( "\n\n\t\t\t\t\tError" );   // Debugging

					}   // End of try-catch statement

					index = 0;

					hit = true;

				}   // End of if-statement

				index++;

			}   // End of while-loop

			hit = false;

			keyIndex++;

			if( key.length != 1 ){

				rotate();

			}   // End of if-statement

			if( keyIndex >= key.length ){

				keyIndex = 0;

			}   // End of if-statement

		}   // End of for-loop

		System.out.printf( "\n\t\t\t\t***********************************************************************************************" );   // Debugging
		System.out.println();																												// Debugging

		return encrypted;

	}   // End of private static method encryption

	/**
	 * Private static method rotate takes the decoderLetters array and rotates it by one.
	 *
	 */
	private static void rotate(){

		for(  int i = decoderLetters.length-1; i > 0; i-- ){

			char temp = decoderLetters[ i ];
			decoderLetters[ i ] = decoderLetters[ i-1 ];
			decoderLetters[ i-1 ] = temp;

		}   // End of for-loop

	}   // End of private static void method rotate

}   // End of public class Encrypters