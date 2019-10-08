

import java.util.*;
import java.io.*;
import edu.duke.*;


public class WordFrequencies
{
    
    // instance variables - replace the example below with your own
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    // CONSTRUCTOR
    public WordFrequencies()
    {
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
    }
    
    // find all words and count them
    public void findUnique(){
     myWords.clear();
     myFreqs.clear();
     
     FileResource fr = new FileResource();

     for(String s : fr.words()){
         s = s.toLowerCase();
         int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
             int value = myFreqs.get(index);
             myFreqs.set(index,value+1);
            } 
    }
}
public int findIndexOfMax(){
    int indexLoc = -1;
    int x = 0;
for(int i = 0; i < myFreqs.size();i++){
    
    if(myFreqs.get(i) > x){
     x = myFreqs.get(i);
     indexLoc = i;
    }
}
return indexLoc;
}

    public void terster(){
     findUnique();
     System.out.println("********");
     System.out.println("Total words is :" + myWords.size());
     
     int index = findIndexOfMax();
     System.out.println("The most occure word is " + "<" +  myWords.get(index) + ">" + " and its repeat: " + myFreqs.get(index));
     
     for(int i = 0;i < myWords.size();i++){
         if(myFreqs.get(i) > 100){
      System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
    }
       }
        int total = myFreqs.size();
    System.out.println("Total unique words : " + total);
    }
}
