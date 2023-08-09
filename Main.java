import java.util.*;

//Driver code
public class Main {
	public static void main(String[] args) {

		
		String message;

		System.out.print("Enter text to perform Encryption/Decryption: ");
		Scanner sc = new Scanner(System.in);
		message = sc.next();
		System.out.println();
		String encrypt_message, decrypt_message;

		CaesarCipher cc = new CaesarCipher();
		int shiftKey = 5;
		encrypt_message = cc.encrypt(message, shiftKey);
		Rot13 r13 = new Rot13();
		encrypt_message = r13.encrypt(encrypt_message);
		Atbash ab = new Atbash();
		encrypt_message = ab.encrypt(encrypt_message);

		System.out.println("Encrpyted message: " + encrypt_message);

		decrypt_message = ab.decrypt(encrypt_message);
		decrypt_message = r13.decrypt(decrypt_message);
		decrypt_message = cc.decrypt(decrypt_message, shiftKey);

		System.out.println("Decrypted message: " + decrypt_message);
		sc.close();
	}
}
