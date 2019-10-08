import java.util.*;
import java.io.*;
import edu.duke.*;

public class WordsInFiles
{
private HashMap<String, ArrayList> map;

private ArrayList<String> temp;
private ArrayList<String> total;

public WordsInFiles(){
    map = new HashMap<String, ArrayList>();
    temp = new ArrayList<String>();
    total = new ArrayList<String>();
    }

private void addWordsFromFile(File f){

FileResource fr = new FileResource(f);
    for(String s : fr.words()){
         total.add(s);
            if(map.containsKey(s) && !map.get(s).contains(f.getName())){
             ArrayList<String> temp2 = map.get(s);   
             temp2.add(f.getName());
                map.put(s,temp2);       
            }
            if(!map.containsKey(s)){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(f.getName());
                map.put(s,temp);
            }
        
    }
}
private void buildWordFileMap(){
 map.clear();
 DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
    addWordsFromFile(f);
    }
 
}

private int maxNumber(){
//ArrayList<String> temp = new ArrayList<String>();
int x = 0;
for(ArrayList<String> temp : map.values()){
  if(temp.size()>x){
     x = temp.size(); 
    }
}
return x;
}

private ArrayList<String> wordsInNumFiles (int num){
//ArrayList<String> temp = new ArrayList<String>();
for(String s : map.keySet()){
 if(map.get(s).size() == num){
    temp.add(s);
    }
}

return temp;  
}
public void printsFileIn(String word){
 for(String s : map.keySet()){
 if(s.equals(word)){
     ArrayList<String> temp = map.get(s);
     for(int i = 0; i < temp.size(); i ++){
         System.out.println(temp.get(i));
        }
    }
    }
}

public void testTemp(){
 //   File f = null;
//try{
//    f = new File("test.txt");
//}
//catch(Exception e) {
         // if any error occurs
 //        e.printStackTrace();
 //       }
//addWordsFromFile(f);
buildWordFileMap();
System.out.println("ok");
int y = 0;
for(String s : map.keySet()){
    int x = map.get(s).size();
    y = y+ x;
 //System.out.println(s + "\t"+ x.size());
    // System.out.println(z);
}
System.out.println("**** Total words:   :" + y);
//ArrayList<String> x = map.get("antoni");
//System.out.println(x.get(0));
int mn = maxNumber();
System.out.println("Max no :" + mn);
ArrayList<String> num = wordsInNumFiles(4);
System.out.println("******* max in file" + num.size());
//int counter = 0;
//for(int i = 0; i < num.size(); i++){
 //String z = num.get(i);
//System.out.println(z);
//}
//}
String filein = "laid";
System.out.println("^^^^^ get file in  >> " + filein);
printsFileIn(filein);
int totalX = map.size();
System.out.println("Total words :  " + totalX);
int totalXxx = 0;
for(ArrayList<String> s : map.values()){
  int temp = s.size();
  if(temp ==4){
     totalXxx = totalXxx + 1; 
    }
}
System.out.println("In four files:   " + totalXxx);
int totalTwo = 0;
for(ArrayList<String> s : map.values()){
  int temp = s.size();
  if(temp ==7){
     totalTwo = totalTwo + 1; 
    }
}
System.out.println("In 7 files:   " + totalTwo);
}
}







