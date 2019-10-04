

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna,String startCodon, String stopCodon) {
      
        String result = "";
        int startIndex = dna.indexOf("ATG");
        
       if (startIndex ==-1) // no ATG
        {
            return "Ten gen nie ma ATG";
        }
        
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
    if (stopIndex == -1) // no TAA
    {
        return "Ten gen nie ma TAA";
    }
// show start and last codon
startCodon = dna.substring(startIndex + 3);
System.out.println("//// dna start with:" + startIndex + "\\\\");
  
        result = dna.substring(startIndex, stopIndex + 3);
        
                int numberC;
    numberC = result.length();
         System.out.println("-----Dlugosc genu: "+ numberC);   
         
         if ((numberC % 3) != 0){
            return "To nie gen.";
            }
            if((numberC %3) == 0)
            {
                return "To jest gen.";
            }
         
        return result;
       
        
            

      
}
public void testFindGeneSimple(){
    
    
    String startCodon = "0";
    String stopCodon = "0";
    System.out.println("1........malo liter");
    String dna = "AATGCGTAATATGGT";
    System.out.println("dna is:" + dna);
    String gene = findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("gene is:" + gene);
    
    System.out.println("2.........ten gen jest ok");
    dna = "AATGCTAGGGTAATATGGT";
    System.out.println("dna is:" + dna);
    gene = findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("gene is:" + gene);
    
    System.out.println("3...........tEN CHUJ WIE");
    dna = "AATCTAGGGTAATTAATTTTATAGT";
    System.out.println("dna is:" + dna);
    gene = findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("gene is:" +gene);
    
    
}

}
