
import java.util.*;
import java.io.*;
import edu.duke.*;
public class CodonCount
{
private HashMap<String, Integer> hashMap;


    public CodonCount(){
hashMap = new HashMap<String,Integer>();        
}

    public void buildCodonMap(int start,String dna){
hashMap.clear();


String codon;
    for(int i = start; i <= dna.length() - 3;i +=3){
        codon = dna.substring(start, start +3) ; 
        start +=3;
        if(hashMap.containsKey(codon)){
            hashMap.put(codon,hashMap.get(codon) +1);
        }
        else{
        hashMap.put(codon,1);}   
        
    }

}

public void testAll(){
FileResource fr = new FileResource();
  
String dna = fr.asString();
int start = 0;
System.out.println("******** 0 *********");
buildCodonMap(start,dna);
for(String s : hashMap.keySet()){
    int x = hashMap.get(s);
 System.out.println(s + "\t" + x);   
}


System.out.println("******** 1 *********");
start = 1;
buildCodonMap(start,dna);
for(String s : hashMap.keySet()){
    int x = hashMap.get(s);
 System.out.println(s + "\t" + x);   
}

System.out.println("******** 2 *********");
start = 2;
buildCodonMap(start,dna);
for(String s : hashMap.keySet()){
    int x = hashMap.get(s);
 System.out.println(s + "\t" + x);   
}
}

}
