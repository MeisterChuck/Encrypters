public class Encrypters{
	private String key, originalText, modifiedText;
	private int[] numText, numKey;

	Encrypters(String text, String key){
		this.originalText = text;
		this.key = key;

		encrypt(originalText, key);
		decrypt(modifiedText, key);
	}

	private void encrypt(String text, String key){
		char[] converted = new char[text.length()];
		int[] numText = new int[text.length()];
		int[] numKey = new int[key.length()];
		int i = 0;

		//Convert String to char array then int array
		for(char c : text.toCharArray()){
			numText[i] = c;
			i++;
		}
		i = 0;
		for(char c : key.toCharArray()){
			numKey[i] = c;
			i++;
		}

		//Debugging
		System.out.println("-----------------------------------------");
		System.out.println("Unencrypted text and key converted to int[]");
		System.out.println("-----------------------------------------");
		System.out.print("Text: ");
		for(i = 0; i < numText.length; i++){
			System.out.print(numText[i] + " ");
		}
		System.out.println();
		System.out.print("Key: ");
		for(i = 0; i < numKey.length; i++){
			System.out.print(numKey[i] + " ");
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println();
		//End of debugging

		//Encrypting
		for(i=0; i<numText.length; i++){
			numText[i] = numText[i] + numKey[i % numKey.length];
			numText[i] = numText[i] % 127; //Length of ASCII chart
		}

		//Debugging
		System.out.println("-----------------------------------------");
		System.out.println("Encrypted text converted to int[]");
		System.out.println("-----------------------------------------");
		System.out.print("Text: ");
		for(i = 0; i < numText.length; i++){
			System.out.print(numText[i] + " ");
		}
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println();
		//End of debugging

		for(i = 0; i < numText.length; i++){
			converted[i] = (char)numText[i];
		}
		this.modifiedText = new String(converted);

		//Debugging
		System.out.println("-----------------------------------------");
		System.out.println("Encrypted text");
		System.out.println("-----------------------------------------");
		System.out.println(modifiedText);
		System.out.println("-----------------------------------------");
	}

	private void decrypt(String text, String key){
		char[] converted = new char[modifiedText.length()];
		int[] numText = new int[modifiedText.length()];
		int[] numKey = new int[key.length()];
		int i = 0, token = 0;

		//Convert String to char array then int array
		for(char c : modifiedText.toCharArray()){
			numText[i] = c;
			i++;
		}
		i = 0;
		for(char c : key.toCharArray()){
			numKey[i] = c;
			i++;
		}

		//Debugging
		System.out.println("-----------------------------------------");
		System.out.println("Undecrypted text and key converted to int[]");
		System.out.println("-----------------------------------------");
		System.out.print("Text: ");
		for(i = 0; i < numText.length; i++){
			System.out.print(numText[i] + " ");
		}
		System.out.println();
		System.out.print("Key: ");
		for(i = 0; i < numKey.length; i++){
			System.out.print(numKey[i] + " ");
		}
		System.out.println("\n-----------------------------------------");
		for(i = 0; i < numText.length; i++){
			System.out.print(numKey[i%numKey.length] + " ");
		}
		//End of debugging

		token = (numText.length-1)%numKey.length;

		//Debugging
		System.out.println("\nToken is " + numKey[token]);
		System.out.println("-----------------------------------------");
		System.out.println();
		//End of debugging

		//Decrypting
		for(i = numText.length-1; i >= 0; i--){
			//System.out.println(numText[i] + " " + numKey[(token+i)%numKey.length]);
			numText[i] = numText[i] - numKey[(token+i)%numKey.length] +127;
			numText[i] = numText[i] % 127;
		}

		for(i = 0; i < numText.length; i++){
			converted[i] = (char)numText[i];
		}
		this.modifiedText = new String(converted);

		//Debugging
		System.out.println("-----------------------------------------");
		System.out.println("Decrypted text");
		System.out.println("-----------------------------------------");
		System.out.println(modifiedText);
		System.out.println("-----------------------------------------");
		//End of debugging
	}
}