

//CaesarCipher.java 
public class CaesarCipher {

	String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";

	public String encrypt(String message, int shiftKey) {
		message = message.toLowerCase();
		String cipherText = "";

		for (int i = 0; i < message.length(); i++) {
			int charPosition = ALPHABETS.indexOf(message.charAt(i));
			int keyVal = (shiftKey + charPosition) % 26;
			char replaceVal = ALPHABETS.charAt(keyVal);
			cipherText += replaceVal;
		}
		return cipherText;
	}

	public String decrypt(String cipherText, int shiftKey) {
		cipherText = cipherText.toLowerCase();
		String message = "";

		for (int i = 0; i < cipherText.length(); i++) {
			int charPosition = ALPHABETS.indexOf(cipherText.charAt(i));
			int keyVal = (charPosition - shiftKey) % 26;
			if (keyVal < 0) {
				keyVal = ALPHABETS.length() + keyVal;
			}
			char replaceVal = ALPHABETS.charAt(keyVal);
			message += replaceVal;
		}
		return message;
	}
}
