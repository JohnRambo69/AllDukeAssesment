
/**
TEST CLASS
 */
import edu.duke.*;
import java.util.*;
import java.io.*;

public class TestClass {

    public void testCaesar(){
    int key = 6;
    FileResource fr = new FileResource();
    String temp = fr.asString();
    System.out.println(temp);
    CaesarCipher test1 = new CaesarCipher(key);
   
    String encrypted = test1.encrypt(temp);
    
    String temp2 = encrypted;
    String decrypted = test1.decrypt(temp2);
    
    
    System.out.println(encrypted);
    System.out.println("^^^ DECRYPTED ^^^");
    System.out.println(decrypted);
    }
    
    public void testCaesarCracker(){
    FileResource fr = new FileResource();
    String temp = fr.asString();
    CaesarCracker cc = new CaesarCracker('a');
    String decrypted = cc.decrypt(temp);
    System.out.println(decrypted);
    
    }
    
    public void testVigenereCipher(){
    FileResource fr = new FileResource();
    String temp = fr.asString();
    int [] key = {17, 14, 12, 4} ;
    VigenereCipher vc = new VigenereCipher(key);
    
    String encrypted = vc.encrypt(temp);
    
    String decrypted = vc.decrypt(encrypted);
    System.out.println(encrypted);
    System.out.println(decrypted);
    
    String printKey = vc.toString();
    System.out.println(printKey);
    
    }
}
