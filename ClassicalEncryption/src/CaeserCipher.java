import java.util.Scanner;

public class CaeserCipher {

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

	/** function: allLowerCase
	 * 
	 * @param s
	 * @return true or false
	 * 
	 * check if the given string only consist of lower case letters
	 * 
	 */
	public static boolean allLowerCase (String s){
		for (int i = 0; i < s.length(); i++){
			if (!Character.isLowerCase(s.charAt(i))){
				return false;
			}
		}
		return true;
	}

	/** function: encode
	 *
	 * @param plaintext
	 * @param n
	 * 
	 * encode the plaintext string by adding n to each character of the
	 * given string and print out the ciphertext.
	 * 
	 */
	public static void encode (String plaintext, int n){
		char[] plaintextArray = plaintext.toCharArray(); 
		int base = (int) 'a';
		for (int i = 0; i < plaintext.length(); i++ ){ 
			plaintextArray[i] = (char) (int) (((plaintextArray[i] - base + n) % 26) + base);
			//add n to the ith character of the plaintext array.
		}
		String ciphertext = new String(plaintextArray);
		System.out.println("n =" + n + ": " + ciphertext);
	}

	/** function: decode
	 *
	 * @param ciphertext
	 * @param n
	 * 
	 * decode the ciphertext string by subtracting n to each character of the
	 * given string and print out the plaintext.
	 * 
	 */
	public static void decode (String ciphertext, int n){
		char[] ciphertextArray = ciphertext.toCharArray(); 
		int base = (int) 'a';
		for (int i = 0; i < ciphertext.length(); i++ ){ 
			ciphertextArray[i] = (char)((mod(((int)(ciphertextArray[i]) - base - n), 26)) + base);
			//subtracting n from the ith character of the ciphertext array.
		}
		String plaintext = new String(ciphertextArray);
		System.out.println("n =" + n + ": " + plaintext);
	}


	public static void main (String[] args) { 
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.println("Would you like to encode or decode a message?"); 

		Scanner in = new Scanner (System.in); 
		String response = in.nextLine();
		if (response.equals("encode")) {
			System.out.println("Enter the string to encode");
			Scanner in2 = new Scanner (System.in);
			String plaintext = in2.nextLine();
			if (!allLowerCase(plaintext)){
				System.out.println("The string must only consist of lower cases and should not have whitespace");
			}
			else {
				for (int i = 0; i < 26; i++){  //encode the plaintext by adding each letter to it.
					encode(plaintext, i);
				}
			}
		}
		else if (response.equals("decode")) {
			System.out.println("Enter the string to decode");
			Scanner in3 = new Scanner (System.in);
			String ciphertext = in3.nextLine();
			if (!allLowerCase(ciphertext)){
				System.out.println("The string must only consist of lower cases and should not have whitespace");
			}
			else {
				for (int i = 0; i < 26; i++){ ////decode the ciphertext by subtracting each letter from it.
					decode(ciphertext, i);
				}
			}
		}

		else {
			System.out.println("Valid options are \"encode\" or \"decode\"");

		}
	}

}


