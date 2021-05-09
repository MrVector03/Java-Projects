package numericEncryption;

import java.util.Scanner;
import java.util.*;

public class numericEncryptor {

    // Text gets encrypted
    public void encrypt(HashMap<Character, Integer> dict){
        Scanner input = new Scanner(System.in);
        StringBuilder encryptedText = new StringBuilder();
        System.out.print("Text for encryption: ");
        String encText = input.nextLine();
        char[] encChars = encText.toCharArray();

        for (int i = 0; i < encChars.length; i++) {
            char character = Character.toLowerCase(encChars[i]);

            if (dict.containsKey(character) || i + 1 == encChars.length){
                encryptedText.append(dict.get(character));

            }
            encryptedText.append('0');
        }
        encryptedText.deleteCharAt(encryptedText.length() - 1);
        System.out.println(encryptedText);
    }

    // Text gets decrypted
    public void decrypt(HashMap<Integer, Character> dict){
        Scanner input = new Scanner(System.in);
        StringBuilder decryptedText = new StringBuilder();

        System.out.print("Text for decryption: "); // user types in their encrypted message
        String encText = input.nextLine();
        char[] tempArr = encText.toCharArray();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < encText.length(); i++){ // iteration through the array
            if (tempArr.length == i + 1){
                temp.append(tempArr[i]);
                decryptedText.append(dict.get(Integer.parseInt(temp.toString())));
            } else if (tempArr[i] == '0' && (tempArr[i + 1] != '0' || tempArr.length == i + 1)){  // if the current number and the number after isn't 0...
                decryptedText.append(dict.get(Integer.parseInt(temp.toString())));
                System.out.println(temp);
                temp.setLength(0);

            } else {
                temp.append(tempArr[i]);
            }

        }

        System.out.println(decryptedText);
    }

    // Text gets permanently encrypted
    public void permEncrypt(HashMap<Character, Integer> dict){
        Scanner input = new Scanner(System.in);
        StringBuilder encryptedText = new StringBuilder();
        System.out.print("Text for encryption: ");
        String encText = input.nextLine();
        char[] encChars = encText.toCharArray();

        for (char encChar : encChars) {

            if (dict.containsKey(encChar)){
                encryptedText.append(dict.get(Character.toLowerCase(encChar)));
            } else {
                encryptedText.append(0);
            }

        }
        System.out.println(encryptedText);
    }

    public void run(){
        Scanner input = new Scanner(System.in);
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<Integer, Character> toAlphabet = new HashMap<>();
        HashMap<Character, Integer> toNumber = new HashMap<>();

        for (int i = 0; i < alpha.length; i++) {
            toAlphabet.put(i + 1, alpha[i]);
            toNumber.put(alpha[i], i + 1);
        }

        String query;
        do {
            System.out.print(">>> ");
            query = input.nextLine();
            switch (query) {
                case "encrypt" -> encrypt(toNumber);
                case "decrypt" -> decrypt(toAlphabet);
                case "perm encrypt" -> permEncrypt(toNumber);
                default -> System.out.println("Closing");
            }
        } while (!query.equals("close"));

    }
    public static void main(String[] args){
        numericEncryptor crypt = new numericEncryptor();
        crypt.run();

    }
}
