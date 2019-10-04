
/**
 * Write a description of caesarDecryptTwoRandom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.lang.StringBuilder;
import java.lang.Object.*;
public class caesarDecryptTwoRandom {

    
    public String encrypt(String input, int key1, int key2){
 StringBuilder encrypted = new StringBuilder(input);
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
 String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
 
 
 
//System.out.println(shiftedAlphabet);
    for(int i=0; i< encrypted.length();i++){
        char currChar = Character.toUpperCase(encrypted.charAt(i));
    
        int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                        char newChar = shiftedAlphabet.charAt(idx);
                        encrypted.setCharAt(i,newChar);
                    }
                if(idx != -1 && (i % 2) !=0){
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
        }
   
    }
        return encrypted.toString();
}

public int maxInd(int [] count){
    int max = count[0];
    int index = 0;
        for(int i = 0; i < count.length; i++){
        if(max< count[i]){
            max = count[i];
            index = i;
        }
    }


    return index;

}


public int[]  countLetters(String encrypted){
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
int counts[] = new int[26];
    for(int k=0; k< encrypted.length(); k++){
        char ch = Character.toUpperCase(encrypted.charAt(k));
        int dex = alphabet.indexOf(ch);
            if (dex != -1){ 
            counts[dex] += 1;}
    }
    
return counts;
}
    
public String findKey1(String string){
StringBuilder encrypted = new StringBuilder(string);
StringBuilder out = new StringBuilder();
        for(int i=0; i< encrypted.length();i++){
           
           char newChar = Character.toUpperCase(encrypted.charAt(i));
        if(i % 2 ==0){
         
         out.append(newChar);
         
        }
}
return out.toString();
}
public String findKey2(String string){
StringBuilder encrypted = new StringBuilder(string);
StringBuilder out = new StringBuilder();
        for(int i=0; i< encrypted.length();i++){
           
           char newChar = Character.toUpperCase(encrypted.charAt(i));
        if(i % 2 !=0){
         
         out.append(newChar);
         
        }
}
return out.toString();
}

public String decrypt(String encrypted){

int [] freqs = countLetters(encrypted);
int maxDex = maxInd(freqs);
System.out.println(maxDex);
int dkey = maxDex - 4;
    if(maxDex < 4){
     dkey = 26 - (4- maxDex);   
    }

   return encrypt(encrypted,26 - dkey, 26-dkey);
}
 
public void testTemp(){
   //FileResource fr = new FileResource();
//String temp = fr.asString();
String temp = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
String out = decryptTwoKeys(temp);
System.out.println(out);
}


public String decryptTwoKeys(String encrypted){
    
String stringKey1 = findKey1(encrypted);

String stringKey2 = findKey2(encrypted);


int [] listKey1 = countLetters(stringKey1);
int [] listKey2 = countLetters(stringKey2);

int maxDex1 = maxInd(listKey1);

int maxDex2 = maxInd(listKey2);



int dkey1 = maxDex1 -4;
System.out.println("KEY 1 :  " + dkey1);
int dkey2 = maxDex2 -4;
System.out.println("KEY 2 : " + dkey2);

    if(maxDex1 < 4){
     dkey1 = 26 - (4- maxDex1);   
    }
        if(maxDex2 < 4){
     dkey2 = 26 - (4- maxDex2);   
    }
    

   return encrypt(encrypted,26 - dkey1, 26-dkey2);
}
 

public void testAll(){

 System.out.println("************************************");


FileResource fr = new FileResource();
String temp = fr.asString();
System.out.println(temp);
String result = decrypt(temp);
System.out.println(result);
}
}
