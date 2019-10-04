
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class part1 {

    public CSVRecord hottestHourInFile(CSVParser parser){
        
        CSVRecord largestSoFar = null;
        
        for(CSVRecord currentRow : parser){
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
            
        }
        
        return largestSoFar;
    }
    
    public void testHottestInDay(){
        FileResource fr = new FileResource("data/2013/weather-2013-08-10.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("The hottest temp was: " + largest.get("TemperatureF") + " at " + largest.get("TimeEDT"));
        
    }
    
    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        
     DirectoryResource dr = new DirectoryResource();
     for(File f : dr.selectedFiles()){
         FileResource fr = new FileResource(f);
         CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
         largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
     
    }
    return largestSoFar;
}
public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
if(largestSoFar==null){largestSoFar = currentRow;}
         else{
                    double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                    double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                    if(currentTemp > largestTemp){largestSoFar = currentRow;}
        }
        return largestSoFar;
    }
    public CSVRecord getLowestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
 if(largestSoFar==null){largestSoFar = currentRow;}
         else{
                    double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                    double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                    if(currentTemp < largestTemp && currentTemp > -99){largestSoFar = currentRow;}
        }
        return largestSoFar;
    }

public void testHottestInManyDay(){
       
        CSVRecord largest = hottestInManyDays();
        System.out.println("The hottest temp was: " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));
        
    }
    
       public CSVRecord coldestHourInFile(CSVParser parser){
        
        CSVRecord largestSoFar = null;
       
        for(CSVRecord currentRow : parser){
       //String temp = currentRow.get("TemperatureF"); 
        //System.out.println(temp);
        largestSoFar = getLowestOfTwo(currentRow, largestSoFar);
        
        //return largestSoFar;
            
        }
        
        return largestSoFar;
  
    }
    
     public void testColdestHour(){
        FileResource fr = new FileResource("data/2014/weather-2014-05-01.csv");
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        System.out.println("The coldest temp was: " + largest.get("TemperatureF") + " at " + largest.get("TimeEDT"));
        
    }
    
    
    public CSVRecord fileWithColdestTemperature(){
       CSVRecord largestSoFar = null;
       String fileName = null;
        File temp = null;
    DirectoryResource dr = new DirectoryResource();
     for(File f : dr.selectedFiles()){
         FileResource fr = new FileResource(f);
         CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
         if(largestSoFar==null){largestSoFar = currentRow;temp = f;}
         else{
                    double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                    double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                    if(currentTemp < largestTemp && currentTemp > -99){largestSoFar = currentRow;temp = f;}
        }
        
        //largestSoFar = getLowestOfTwo(currentRow, largestSoFar);
          // String temp = currentRow.get("TemperatureF"); 
       // System.out.println(temp);
     //fileName = fr.getName();
    }
    System.out.println(temp); 
   FileResource fr = new FileResource(temp);
   CSVParser rec = fr.getCSVParser();
   for(CSVRecord r: rec){
       String temp2;
       temp2 = r.get("TemperatureF");
       System.out.println(temp2);
            
        }
    return largestSoFar; 
    }
    public void testColdestInManyDay(){
       
        CSVRecord largest = fileWithColdestTemperature();
        System.out.println("The coldest temp was: " + largest.get("TemperatureF") + " at " + largest.get("DateUTC") + " in file");
        
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        
        CSVRecord largestSoFar = null;
        
        for(CSVRecord currentRow : parser){
            int x=0;
            String check = currentRow.get("Humidity");
            if(check.equals("N/A")){x=1;} else{x=0;}
            if(largestSoFar==null && x==0){largestSoFar = currentRow;}
         else{
                   if(x==0){int currentTemp = Integer.parseInt(currentRow.get("Humidity"));
                    int largestTemp = Integer.parseInt(largestSoFar.get("Humidity"));
                    if(currentTemp < largestTemp && x==0){largestSoFar = currentRow;}
                }
                    
        }
            
        }
        
        return largestSoFar;
    }
    
        public CSVRecord humidityInManyDays(){
        CSVRecord largestSoFar = null;
        
     DirectoryResource dr = new DirectoryResource();
     for(File f : dr.selectedFiles()){
         FileResource fr = new FileResource(f);
         CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
         int x=0;
            String check = currentRow.get("Humidity");
            if(check.equals("N/A")){x=1;} else{x=0;}
            if(largestSoFar==null && x==0){largestSoFar = currentRow;}
         else{
                   if(x==0){int currentTemp = Integer.parseInt(currentRow.get("Humidity"));
                    int largestTemp = Integer.parseInt(largestSoFar.get("Humidity"));
                    if(currentTemp < largestTemp && x==0){largestSoFar = currentRow;}
                }
                    
        }
     
    }
    return largestSoFar;
}
     public void testHumidity(){
        FileResource fr = new FileResource();
        CSVRecord largest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("The lowest humidity was: " + largest.get("Humidity") + " at " + largest.get("DateUTC"));
        
    }
    public void testHumidityInManyDay(){
       
        CSVRecord largest = humidityInManyDays();
        System.out.println("The lowest humidity was: " + largest.get("Humidity") + " at " + largest.get("DateUTC"));
        
    }
    public  void averageTemperatireInFile(CSVParser parser){
        
        CSVRecord largestSoFar = null;
        double sum = 0;
        int count = 0;
        for(CSVRecord currentRow : parser){
            
            double tempHum = Double.parseDouble(currentRow.get("TemperatureF"));
                   
                    sum = sum + tempHum;
                    count += 1;
        }
         double av = Double.valueOf( sum / count);
         System.out.println("Average temp is: "+av);
         
        }
        
      public void testAverageHumidity(){
       FileResource fr = new FileResource();
        averageTemperatireInFile(fr.getCSVParser());
        }  
        
        public  void averageTemperatureAndHumidity(CSVParser parser, int value){
        
        CSVRecord largestSoFar = null;
        int tempHum = 0;
        double sum = 0;
        int count = 0;
        for(CSVRecord currentRow : parser){
            
            double tempTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            tempHum = Integer.parseInt(currentRow.get("Humidity"));       
                    if(tempHum >= value){sum = sum + tempTemp;count += 1;}
                    
        }
         double av = Double.valueOf( sum / count);
         System.out.println("Average temp where humidity over 80: "+ av);
         
        }
        public void testAverageTempAndHumidity(){
       FileResource fr = new FileResource();
        averageTemperatureAndHumidity(fr.getCSVParser(), 80);
        }  
    }

