
/**
 * Write a description of Part2in here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2in {
    

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
    counter = counter + 1;
//System.out.println("INDEX PRZED ZMIANA" + startIndex);
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    
   
    
}
counterGen(counter);

}


 public void counterGen(int index){
    System.out.println("W kodzie bylo tyle genow :" + index);
     
    }

public void test(){
String wynik;
String testDna;

// TEST 1 drugi doniec dla TAA
//testDna = "ATGKTATGTAGAAKKKKTAATAG";
//wynik = findGene(testDna,5);
//System.out.println("*****     TEST 1     *****");
//System.out.println("Lancuch DNA to: " + testDna);
//System.out.println("Gen to: " + wynik);
// TEST 2 drugi doniec TGA
testDna = "ATGKKKTAAKATGRRRTGAATGKKKTGA";
System.out.println("Lancuch DNA do badania >>>>" + testDna);
System.out.println("===================================");
///wynik = findGene(testDna,0);
//System.out.println(wynik);
findAllGenes(testDna);
System.out.println("===================================");

//testDna = "ATGKKKTAAKTTAKTAAKKKTAAKKKTAAKKTAAKTAAKTAAKKKTAT";
//printAllGenes(testDna, "TAA");

}


}

