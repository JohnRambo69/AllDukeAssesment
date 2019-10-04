
/**
 * Write a description of caesarCipherPart2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class caesarCipherPart2 {
 //int [] counts = new int[26];
 
 
    public String encrypt(String input, int key){
 StringBuilder encrypted = new StringBuilder(input);
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
//System.out.println(shiftedAlphabet);
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

public int maxInd(int [] count){
    int max = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] > max){
                max = i;
    }
}
    return max;
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
    


public String decrypt(String encrypted){

int [] freqs = countLetters(encrypted);
int maxDex = maxInd(freqs);
System.out.println(maxDex);
int dkey = maxDex - 4;
    if(maxDex < 4){
     dkey = 26 - (4- maxDex);   
    }
System.out.println(dkey + "  d key");
   return encrypt(encrypted,26 - dkey);
}

public void testAll(){

 System.out.println("************************************");
// test STRING
String test = "at my house there is a village with many old dicks. it is called dickencity.";
String test2 = "";
int key = 7;
System.out.println("**** This is a test for tekst: " + test +  " with KEY: "+ key+"   *****");
// test encryption
System.out.println("Encrypted tekst is: " + encrypt(test,key));
test2 = encrypt(test,key);
//test decryption
//System.out.println("Decrypted tekst is: " + encrypt(test2, 26-key));
countLetters(test2);
System.out.println("Random encrypt is: " + decrypt(test2));






}
}
