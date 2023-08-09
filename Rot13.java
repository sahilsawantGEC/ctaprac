public class Rot13 {

	public String encrypt(String message) {
		message = message.toLowerCase();
		String cipherText = "";

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c >= 'a' && c <= 'm')
				c += 13;
			else if (c >= 'n' && c <= 'z')
				c -= 13;
			cipherText += c;
		}
		return cipherText;
	}
	// Rot-13 has the same function for encryption and decryption, // it is said to
	// be involutive.

	public String decrypt(String cipherText) {
		cipherText = cipherText.toLowerCase();
		String message = "";

		for (int i = 0; i < cipherText.length(); i++) {
			char c = cipherText.charAt(i);
			if (c >= 'a' && c <= 'm')
				c += 13;
			else if (c >= 'n' && c <= 'z')
				c -= 13;
			message += c;
		}
		return message;
	}
}
