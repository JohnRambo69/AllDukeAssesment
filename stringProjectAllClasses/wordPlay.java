
/**
 * Write a description of wordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wordPlay {

 // is Vovel method returns true or false
 
 public boolean isVowel(char ch){
   
     StringBuilder vovelList = new StringBuilder("AEIOU");
     for(int i=0;i<vovelList.length();i++){
        char temp = vovelList.charAt(i);
        if(Character.toUpperCase(ch) == temp){
            return true;
        }
        }
     return false;
    }
// replaceVovel replaces vovels in string
public String replaceVowels(String phrase, char ch){
 
 StringBuilder out = new StringBuilder(phrase);
 String afterReplace = "";
    for(int i = 0; i<out.length();i++){
        if(isVowel(out.charAt(i))){
         afterReplace = afterReplace + ch;   
        }
        else{
        afterReplace = afterReplace + out.charAt(i);
        }
    }
    
    return afterReplace;
}

// replaceVovel replaces vovels in string
public String emphasize(String phrase, char ch){
 
 StringBuilder temp = new StringBuilder(phrase);
 String afterReplace = "";
    for(int i = 0; i<temp.length();i++){
        if(Character.toLowerCase(temp.charAt(i)) == ch && (i % 2) == 0){
         afterReplace = afterReplace + "*";   
        }
        else if(Character.toLowerCase(temp.charAt(i)) == ch && (i % 2) != 0){
            afterReplace = afterReplace + "+"; 
        }
        else{
        afterReplace = afterReplace + temp.charAt(i);
        }
    }
    
    return afterReplace;
}


public void testAll(){
    char i = 'B';
    //System.out.println(i + " is vovel : " + isVowel(i));
    
    //System.out.println(replaceVowels("Hello world !", '*'));
    
    System.out.println(emphasize("Mary Bella Abracadabra" , 'a'));
}
}