
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna) {
      
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

  
        result = dna.substring(startIndex, stopIndex + 3);
        
                int numberC;
    numberC = result.length();
         System.out.println("dlugosc tekstu:"+ numberC);   
         
         if ((numberC % 3) != 0){
            return "To nie genn.";
            }
         
        return result;
       
        
            

      
}
public void testFindGeneSimple(){
    
    System.out.println("malo liter");
    String dna = "AATGCGTAATATGGT";
    System.out.println("dna is:" + dna);
    String gene = findSimpleGene(dna);
    System.out.println("gene is:" + gene);
    
    System.out.println("ten gen jest ok");
    dna = "AATGCTAGGGTAATATGGT";
    System.out.println("dna is:" + dna);
    gene = findSimpleGene(dna);
    System.out.println("gene is:" + gene);
    
    System.out.println("tEN CHUJ WIE");
    dna = "AATCTAGGGTAATTAATTTTATAGT";
    System.out.println("dna is:" + dna);
    gene = findSimpleGene(dna);
    System.out.println("gene is:" +gene);
    
    
}

}
