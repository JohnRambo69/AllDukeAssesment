
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
int overSix = 0;
int newRatio = 0;
int manyGens = 0;
String longest =  "";
    public int findDna(String dna,int startIndex, String stopCodon){
        
        // znajdz pierwsze ATG pozycja
     //int startIndex = dna.indexOf("ATG");
     if(startIndex == -1){
        return 0;
        }
     //System.out.println(startIndex);
     // znajdz TAA zaczynajac od indexu + 3
     int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
     //System.out.println(currentIndex);
     
     while(currentIndex != -1){
            if((currentIndex - startIndex) % 3 == 0)
            {
             //return dna.substring(startIndex, currentIndex + 3);
            
             return currentIndex;
             
            }
            
            else {
                currentIndex = dna.indexOf(stopCodon, currentIndex + 3);
               // System.out.println(currentIndex);
                
            }
        }
     
        return dna.length();
    }

public String findGene(String dna, int where){
   int startIndex = dna.indexOf("ATG", where);
   if(startIndex ==-1){
       return "";
       
    }
    
    int taaIndex = findDna(dna,startIndex, "TAA");
    int tgaIndex = findDna(dna,startIndex, "TAG");
    int tagIndex = findDna(dna,startIndex, "TGA");
    int temp = Math.min(taaIndex, tagIndex);
    int minIndex = Math.min(temp,tgaIndex);
    if(minIndex == dna.length()){
        return "";
    }
    
    return dna.substring(startIndex, minIndex + 3);
    
    
    
    
  
}

public void findAllGenes(String dna){
int startIndex = 0;
int counter = 0;

while (true){
    String currentGene = findGene(dna, startIndex);
    
    if (currentGene.isEmpty()){
     break;   
    }
    
    System.out.println(currentGene);
    manyGens = manyGens + 1;
    // jezeli gen jest dluzszy niz 60
    
    counter = counter + 1;
//System.out.println("INDEX PRZED ZMIANA" + startIndex);
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    
   
    
}
counterGen(counter);

}


 public void counterGen(int index){
    System.out.println("W kodzie bylo tyle genow :" + index);
     
    }
public StorageResource getAllGenes(String dna){
    StorageResource geneList = new StorageResource();
int startIndex = 0;
int counter = 0;

while (true){
    String currentGene = findGene(dna, startIndex);
    
    if (currentGene.isEmpty()){
     break;   
    }
    
    geneList.add(currentGene);
    if(cgRatio(currentGene) > 0.35){newRatio = newRatio+1;};
    if (currentGene.length() > 60) {overSix = overSix + 1;}
    if(currentGene.length() > longest.length()){longest = currentGene;}
    counter = counter + 1;
    manyGens = manyGens + 1;
//System.out.println("INDEX PRZED ZMIANA" + startIndex);
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    
   
    
}

counterGen(counter);
return geneList;
}

public double cgRatio(String dna){
    int currIndex = 0;
    int gCount = 0;
   int cCount = 0;
   
   String tempX;
   
   // szukaj G
    while(currIndex != -1 && currIndex < dna.length()){
         tempX = dna.substring(currIndex, currIndex + 1);
        if ( tempX.equals("G")){
         //System.out.println("znalazlem");
           gCount = gCount + 1;  
        }
       // System.out.println(tempX);
       currIndex = currIndex + 1;
    
}

   // szukaj C
   currIndex = 0;
    while(currIndex != -1 && currIndex < dna.length()){
         tempX = dna.substring(currIndex, currIndex + 1);
        if ( tempX.equals("C")){
         //System.out.println("znalazlem");
           cCount = cCount + 1;  
        }
       // System.out.println(tempX);
       currIndex = currIndex + 1;
    
}
double len = dna.length();
double cg = (cCount + gCount);
double ratio1 =   cg/ len;

return ratio1;

}

public void testRatio(){
    String testDna = "ATGCCATAG";
    cgRatio(testDna);
}
 public void findCtg(String dna){
     int count = 0;
     int pos = 0;
     int index = 3;
     while (index != -1 && pos != -1 && index < dna.length()){
         
         if (dna.substring(pos,index).equals("CTG")) {count = count + 1;}
         pos = pos+ 1;
         index = index +1;
        }
        System.out.println(count);
    }

public void test(){
     FileResource fr = new FileResource("GRch38dnapart.fa");
    String dnaFile = fr.asString().toUpperCase();
 
String wynik;
String testDna;


//testDna = "ATGKKKTAATAAKATGRRRTGAATGKKKTGAC";
testDna = dnaFile;
//System.out.println("Lancuch DNA do badania >>>>" + testDna);
System.out.println("===================================");
///wynik = findGene(testDna,0);
//System.out.println(wynik);
StorageResource genes = getAllGenes(testDna);
for (String g: genes.data()){
System.out.println(g);
}
System.out.println("===================================");
cgRatio(testDna);
System.out.println("Over 60: " + overSix);
System.out.println("Gens over 0.35: " + newRatio);
System.out.println("Gens " + manyGens);
System.out.println("Longest gene is: " + longest.length());
findCtg(testDna);
//testDna = "ATGKKKTAAKTTAKTAAKKKTAAKKKTAAKKTAAKTAAKTAAKKKTAT";
//printAllGenes(testDna, "TAA");
}
 public void testSolo(){
    findCtg("CTGCTGCTGCTG");
     

    

}
}