
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.lang.StringBuilder;
import java.lang.Object.*;

public class WordLengths{

    public void test(){
        int[] counter = new int[20];
     FileResource fr = new FileResource();
     countWordLengths(fr,counter);
     int maxValues =indexOfMax(counter) - 1;
     
     System.out.println(" Max walue was : " + indexOfMax(counter));
     
    }
    
    
    public int indexOfMax (int [] values){
     int max = 0;
     for(int i = 0; i < values.length; i++){
         if(values[i] > max){
             max = values[i];
            }
        }
     
     
        return max;
    }
    
    public void countWordLengths(FileResource resource, int [] counter){
   
     // FileResource fr = new FileResource("smallhamlet.txt");
      for(String sb : resource.words()){
              int cl = lengthAfterCheck(sb); 
              counter[cl] ++ ;
              
    }
    
    for (int i=1; i  < counter.length; i++){
        if (counter[i] != 0){
        System.out.println("Words with lenght: " + i + " was: " + counter[i]);
        }
            
    }

}

public int lengthAfterCheck(String a){
    StringBuilder ab = new StringBuilder(a);
    String newString = "";
            for(int i=0; i < ab.length(); i++){
                char test = ab.charAt(i);
                if(Character.isLetter(test)){
                     newString = newString+ test;   
                    }
                   else if( i > 0 && i < ab.length() - 1){
                    newString = newString+ test; 
                }
                
            }
            int length = newString.length();
            //System.out.println("old string is : " + a + "and new string is:  " + newString);
    return length;
}

}
