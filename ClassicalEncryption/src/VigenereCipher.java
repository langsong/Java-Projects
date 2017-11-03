import java.util.Scanner;


public class VigenereCipher {
	
	/** function: mod
	 * 
	 * @param x
	 * @param y 
	 * @return result
	 * 
	 * when the dividend is negative, the function will return the  
	 * positive remainder.
	 * 
	 */
	public static int  mod (int x, int y){
		int result = x % y; 
		if (result < 0) { 
			result += y;
		}
		return result;
	}

	/** function: encode
	 *
	 * @param plaintext
	 * @param key
	 * 
	 * encode the plaintext string by adding replicated keywords which match the length of the plaintext.
	 * 
	 */
	public static void encode (String plaintext, String key){
		char[] plaintextArray = plaintext.toCharArray();
		char[] keyarray = key.toCharArray();
		int base = (int) 'a';
		for (int i = 0; i < plaintext.length(); i++ ){
			char keychar = keyarray[i % (key.length())]; //the letter from the key that matches with the ith character of the plaintext
			plaintextArray[i] = (char) ((((int) ((plaintextArray[i] - base) + (keychar - base))) % 26) + base);
			//adding keychar to the ith character of the plaintext array.
		}
		String ciphertext = new String(plaintextArray);
		System.out.println(ciphertext);
	}
	
	/** function: decode
	 *
	 * @param ciphertext
	 * @param key
	 * 
	 * encode the ciphertext string by subtracting replicated keywords which match the length of the ciphertext.
	 * 
	 */
	public static void decode (String ciphertext, String key){
		char[] ciphertextArray = ciphertext.toCharArray();
		char[] keyarray = key.toCharArray();
		int base = (int) 'a';
		for (int i = 0; i < ciphertext.length(); i++ ){
			char keychar = keyarray[i % (key.length())]; //the letter from the key that matches with the ith character of the ciphertext
			ciphertextArray[i] = (char) ((mod ((int) (ciphertextArray[i] - keychar), 26)) + base);
			//subtracting keychar from the ith character of the ciphertext array.
		}
		String plaintext = new String(ciphertextArray);
		System.out.println(plaintext);
	}
	
	public static void main (String[] args) { 
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.println("Would you like to encode or decode a message?"); 

		Scanner in = new Scanner (System.in); 
		String response = in.nextLine();
		if (response.equals("encode")) {
			System.out.println("Enter the string to encode");
			Scanner in2 = new Scanner (System.in);
			String plaintext = in2.nextLine();
			System.out.println("Enter the key: ");
			Scanner in3 = new Scanner (System.in);
			String key = in3.nextLine();
			encode(plaintext, key);
		}
		else if (response.equals("decode")) {
			System.out.println("Enter the string to decode");
			Scanner in4 = new Scanner (System.in);
			String ciphertext = in4.nextLine();
			System.out.println("Enter the key: ");
			Scanner in5 = new Scanner (System.in);
			String key = in5.nextLine();
			decode(ciphertext, key);
		}
		else {
			System.out.println("Valid options are \"encode\" or \"decode\"");
		}
	}
}

