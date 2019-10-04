
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class CaesarCipher {
    
// caesar encrypt one key
public String encrypt(String input, int key){
 StringBuilder encrypted = new StringBuilder(input);
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
 
 for(int i=0; i< encrypted.length();i++){
    char currChar = Character.toUpperCase(encrypted.charAt(i));
    int idx = alphabet.indexOf(currChar);
        if(idx != -1){
         char newChar = shiftedAlphabet.charAt(idx);
         encrypted.setCharAt(i,newChar);
        
        }
    }
    return encrypted.toString();
}


// CAESAR encrypt key 2 every other
public String encryptTwoKeys(String input, int key1, int key2){
 StringBuilder encrypted = new StringBuilder(input);
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
 String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
 
 for(int i=0; i< encrypted.length();i++){
    char currChar = Character.toUpperCase(encrypted.charAt(i));
    int idx = alphabet.indexOf(currChar);
        if(idx != -1 && (i % 2) ==0){
         char newChar = shiftedAlphabet1.charAt(idx);
         encrypted.setCharAt(i,newChar);
        }
        if(idx != -1 && (i % 2) !=0){
         char newChar = shiftedAlphabet2.charAt(idx);
         encrypted.setCharAt(i,newChar);
        }
    }
    return encrypted.toString();
}
public void testAll(){
int key = 15;
int key2 = 17;
//FileResource fr = new FileResource();
String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
String encrypted = encrypt(message, key);
System.out.println(encrypted);
System.out.println("********************");
String decrypted = encrypt(encrypted, 26-key);
System.out.println(decrypted);

// TWO KEYS TEST
System.out.println("TWO KEYS XXXXXXXXXXXXXX");
System.out.println(encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 26-14,26-24));
//System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 26-2, 26-20));
}
}