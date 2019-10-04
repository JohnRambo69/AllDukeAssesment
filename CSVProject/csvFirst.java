
/**
 * Write a description of csvFirst here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class csvFirst {

    public void tester(){
     FileResource fr = new FileResource();
CSVParser parser = fr.getCSVParser();   
countryInfo(parser,"Nauru");

System.out.println("******** GOLD DIAMONDS *********");
parser = fr.getCSVParser();
listExportersTwoProducts(parser,"cotton","flowers");
System.out.println("******** GOLD *******");
parser = fr.getCSVParser();
numberOfExporters(parser, "cocoa");
System.out.println("***** BIG EXPORTERS *******");
parser = fr.getCSVParser();
bigExporters(parser,"$999,999,999,999");
    }
    
    public void countryInfo(CSVParser parser, String country){
        int match = 0;
        for(CSVRecord record : parser){
            String countryMatch = record.get("Country");
            if(countryMatch.contains(country)){
                match +=1;
            String info = record.get("Exports");
             String value = record.get("Value (dollars)");
             System.out.println(country + " " + info + " " + value);
             
            }
                
            }
            if(match == 0){
             System.out.println("No matches!");   
            }
            
           
        }
         public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        int match = 0;
        for(CSVRecord record : parser){
            String item1 = record.get("Exports");
            String country = record.get("Country");
            if(item1.contains(exportItem1) && item1.contains(exportItem2)){
                match +=1;
          
             System.out.println(country);
            }
                
            }
            if(match == 0){
             System.out.println("No matches!");   
            }
            
           
        }
        
        
        public void numberOfExporters(CSVParser parser, String exportItem){
        int match = 0;
        for(CSVRecord record : parser){
            String countryMatch = record.get("Country");
            String exportIt = record.get("Exports");
            if(exportIt.contains(exportItem)){
                match +=1;
                
            
            }
               
            }
            System.out.println("Number of Countries export " + exportItem + " is: " + match); 
            if(match == 0){
             System.out.println("No matches!");   
            }
            
           
        }
        
        
        public void bigExporters(CSVParser parser, String value){
        
        for(CSVRecord record : parser){
            String countryMatch = record.get("Country");
            String bigValue = record.get("Value (dollars)");
            if(bigValue.length() > value.length()){
                System.out.println(countryMatch + " " + record.get("Value (dollars)"));
                
            
            }
               
            }
        
        }
        
    }

