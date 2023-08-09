//Atbash.java
public class Atbash {
	private final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
	private final String REVERSE_ALPHABETS = "zyxwvutsrqponmlkjihgfedcba";

	public String encrypt(String message) {
		message = message.toLowerCase();
		String cipherText = "";

		for (int ii = 0; ii < message.length(); ii++) {
			int charPosition = ALPHABETS.indexOf(message.charAt(ii));
			char replaceVal = REVERSE_ALPHABETS.charAt(charPosition);
			cipherText += replaceVal;
		}
		return cipherText;
	}

	public String decrypt(String cipherText) {
		cipherText = cipherText.toLowerCase();
		String message = "";

		for (int ii = 0; ii < cipherText.length(); ii++) {
			int charPosition = REVERSE_ALPHABETS.indexOf(cipherText.charAt(ii));
			char replaceVal = ALPHABETS.charAt(charPosition);
			message += replaceVal;
		}
		return message;
	}
}
