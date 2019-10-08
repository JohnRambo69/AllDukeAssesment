
import java.util.*;
import java.io.*;
import edu.duke.*;

public class CharactersInPlay
{
    // instance variables - replace the example below with your own
    private ArrayList<String> person;
    private ArrayList<Integer> count;

   
    public CharactersInPlay()
    {
        person = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }

    public void findAllCharacters(){
        person.clear();
        count.clear();
    FileResource fr = new FileResource();
    
        for(String s : fr.lines()){
            
        s = s.toLowerCase();
        int i = s.indexOf(".");
       
        String q= "";
        if(i != -1){
        q = s.substring(0,i);
       
    }
    else{ q = s;}
 
        update(q);
        
    
        
               
                
        }
    }
    
public void update(String name){
   if(person.contains(name)){
                 int index = person.indexOf(name);
                 int val = count.get(index);
                 count.set(index, val+1);
                }
  if(!person.contains(name)){
                person.add(name);
                int index = person.indexOf(name);
                count.add(1);
                
                }
               
}
public void charactersWithNumParts(int num1, int num2){
    System.out.println("********* Person appers more or equal " + num1 +":");
for(int i=0; i < person.size(); i++){
      if( count.get(i) >2 && count.get(i) >= num1 && count.get(i) <= num2){
     System.out.println(person.get(i) + "\t" + count.get(i)); 
    }
} 
 

}

public void testAll(){
  findAllCharacters();
  for(int i=0; i < person.size(); i++){
      if( count.get(i) >2){
     System.out.println(person.get(i) + "\t" + count.get(i)); 
    }
    }
    charactersWithNumParts(10,15);
}
}