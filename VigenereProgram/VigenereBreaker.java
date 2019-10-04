import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    private int keyLong;
    private int countWords;
    private HashMap<String, HashSet<String>> languages;
    
    public VigenereBreaker(){
     languages = new HashMap<String, HashSet<String>>();   
    }
    
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder builder = new StringBuilder(message);
        StringBuilder newString = new StringBuilder();
            for(int i = whichSlice; i< message.length(); i = i + totalSlices){
            newString = newString.append(builder.charAt(i));    
            }
        
        return newString.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker(mostCommon);
        int minus = klength;
            for(int i = 0; i < klength; i ++){
                String tempEncrypted = sliceString(encrypted,i, minus);

                int tempKey = cc.getKey(tempEncrypted);
                key[i] = tempKey;
            }
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource lib = new FileResource();
        HashSet<String> dicSet = readDictionary(lib);
        
        
       String decrypted = breakForLanguage(message, dicSet, 'e');
        System.out.println(decrypted);
        
        System.out.println("**** key length: " + keyLong);
        System.out.println("total words:  " + countWords);
      
    }
    
    public void test(){
        FileResource fr = new FileResource();
        String temp = fr.asString();
        //System.out.println(temp);
        int[] test = tryKeyLength(temp,4,'e');
        System.out.println(Arrays.toString(test));
    }
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<String>(); 
        dictionary.clear();
            for(String s : fr.words()){
            s = s.toLowerCase();
            dictionary.add(s);
            }
        return dictionary;
    }
    
    public int countWords(String message, HashSet<String> dic){
     message = message.toLowerCase();
     String words [] = message.split("\\W");
     ArrayList count = new ArrayList<String>();
        for(int i = 0; i< words.length;i++){
            if(dic.contains(words[i])){
            count.add(words[i]);
            }
        }
     return count.size();   
    }
    
    public String breakForLanguage(String message, HashSet<String> dic, char x) {
            int [] bestKey = new int[0];
            int bestPas = 0;
            int keySize = 0;
            int words = 0;
            for(int i = 1; i < 50; i ++){
             int findKey [] = tryKeyLength(message, i, x);
             VigenereCipher vc = new VigenereCipher(findKey);
             String decrypted = vc.decrypt(message);
             String temp [] = message.split("\\W");
            
             int countWords = countWords(decrypted, dic);
             
             if(countWords > bestPas){
                 bestPas = countWords;
                 bestKey = findKey;
                 keySize = i;
                 words = countWords;
                }
            }
            keyLong = keySize;
            countWords = words;
            VigenereCipher vc = new VigenereCipher(bestKey);
            
            String result = vc.decrypt(message);
            
        return result;
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
        
        HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
            for(String s : dictionary){
                for(int i = 0; i< s.length(); i++){
                StringBuilder str = new StringBuilder(s);
                char character = str.charAt(i);
                    if(temp.containsKey(character)){
                     temp.put(character, temp.get(character) + 1);
                    }
                    else{
                        temp.put(character, 1);
                        }
                }
            }
            int biggestChar = 0;
            char mostChar = 'a';
            for(char c : temp.keySet()){
                int x = temp.get(c);
                    if(x > biggestChar){
                    biggestChar = x; 
                    mostChar = c;
                    }
            }
            
        return mostChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> lang){
    // language hashmap initialization
    // FileResource fr = new FileResource();
        
      // String filePart = "";
       languages.clear();
        String[] langsArray =  {"Danish", "Dutch","English","French", "German", "Italian","Portuguese", "Spanish"};
        for(int i = 0; i < langsArray.length; i++){
            System.out.println(i);
            //filePart = langsArray[i];
            String filename = langsArray[i];
            FileResource fr = new FileResource(filename);
            //HashSet temp = readDictionary(fr);
            //System.out.println(temp);
            languages.put(langsArray[i],readDictionary(fr));
            
        }
    int x = languages.size();
    System.out.println(x);
    String decryptedLast = "";
    int biggestWordNo = 0;
    String langName = "";
        for(String s : languages.keySet()){
            char y =  mostCommonCharIn(languages.get(s));
       String decrypted = breakForLanguage(encrypted, languages.get(s),y);  
        
        System.out.println(s);
        System.out.println(countWords);
                if(countWords > biggestWordNo){
                 biggestWordNo = countWords;
                 langName = s;
                 decryptedLast = decrypted;
                    }
    }
    //String langName = "";
    //HashSet<String> dicSet = languages.get(langName);
    System.out.println(langName + "/t" + biggestWordNo);
    System.out.println(decryptedLast);
        
    }
    
    public void testForAll(){
        languages.clear();
        FileResource fr = new FileResource();
        String temp = fr.asString();
    breakForAllLangs(temp, languages);  
    }
   
    public void testMostCharIn(){
        FileResource fr = new FileResource();
        HashSet tempHash = readDictionary(fr);
        char most = mostCommonCharIn(tempHash);
        System.out.println(most);
    }
}
