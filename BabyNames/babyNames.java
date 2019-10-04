
/**
 * Write a description of babyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class babyNames {
    int girlsNumIndex = 0;
    
// *****         print all information
public void printAll(){
    int totalNum = 0;
    int boysNum = 0;
    int girlsNum = 0;
    
    FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            // rank variable
            long currentIndex = rec.getRecordNumber();
            System.out.println("Name: " + rec.get(0) + 
                                " Gender: " + rec.get(1) + 
                                " Births: " + rec.get(2) +
                                " R/No: "+ currentIndex);
             // calculate totals
             totalNum += 1;
             // boys births
             if(rec.get(1).equals("M")){boysNum += 1;}
             // girls total
             if(rec.get(1).equals("F")){girlsNum += 1;}
        }
    System.out.println("******* TOTALS ********");
    System.out.println("Total births: " + totalNum);
    System.out.println("Boys total: " + boysNum);
    System.out.println("Girls total: " + girlsNum);
    System.out.println("***********************");
    System.out.println(fr);
}
public long getRank(int year, String name, String gender,CSVParser fname){
    int girlsNum = 0;
    long currentIndex = 0;
    //fname = "yob" + year +"short.csv";
   //FileResource fr =  new FileResource(fname);
        for(CSVRecord rec : fname){
            
            if (rec.get(1).equals("F")){girlsNum += 1;}
            // rank variable
            
            String genderCheck = rec.get(1);
           
             
             if(rec.get(0).equals(name) && genderCheck.equals(gender)){
                 currentIndex = rec.getRecordNumber();
                if(gender.equals("M"))
                {return currentIndex - girlsNum;}
                else
                { return currentIndex;}
                }
                
        }
        if (currentIndex != 0){if(gender.equals("M")){
                                   System.out.println("Name : " + name + 
                                                    " Rank is: " + (currentIndex - girlsNum));
                                                }
                                  if(gender.equals("F")){
                                   System.out.println("Name : " + name + 
                                  " Rank is: " + currentIndex);
                                                }
                                            }
        if (currentIndex == 0 ){System.out.println("---");}
       
        return currentIndex;
        
}

public void getName(int year, int rank, String gender){
  int girlsNum = 0;
    long currentIndex = 0;
    int check = 0;
   // String fname = "yob" + year +"short.csv";
   FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
        if (rec.get(1).equals("F")){girlsNum += 1;} 
        
        long currentRank = rec.getRecordNumber();
        if (currentRank == rank && rec.get(1).equals(gender)){
            System.out.println("Name: "+ rec.get(0) + " was " + currentRank);
            check = 1;
        }
        }
     //FileResource fr2 = new FileResource(fname);
        for(CSVRecord rec : fr.getCSVParser(false)){
        
        long currentRank = rec.getRecordNumber();
        
        
        if (currentRank == (rank + girlsNum) && rec.get(1).equals(gender)){
            System.out.println("Name: "+ rec.get(0) + " was " + (currentRank - girlsNum) + "    /2");
            check = 1;
        }
    }
    if (check == 0){System.out.println("NO MATCHES!");}
        
}

public void whatIsNameInYear(String name, int year, int newYear,String gender){
     int girlsNum1 = 0;
     int girlsNum2 = 0;
    long currentIndex = 0;
    int check = 0;
    String newName = null;
    String fname = "data1/yob" + year +".csv";
    String fname2 = "data1/yob" + newYear +".csv";
   FileResource fr = new FileResource(fname);
       
    
            for(CSVRecord rec : fr.getCSVParser(false)){
                 girlsNum1 = getGirls(rec,girlsNum1);
             if (rec.get(0).equals(name) && rec.get(1).equals("F") && rec.get(1).equals(gender)){
                 currentIndex = rec.getRecordNumber();
                }
                if(rec.get(0).equals(name) && rec.get(1).equals("M") && rec.get(1).equals(gender)){
                    currentIndex = rec.getRecordNumber() - girlsNum1;
                }
            }
            
            FileResource fr2 = new FileResource(fname2);
          
            for(CSVRecord rec : fr2.getCSVParser(false)){
                if(rec.get(1).equals("F")){girlsNum2 ++;}
               if(rec.getRecordNumber() == currentIndex  && rec.get(1).equals("F") && rec.get(1).equals(gender)){
                   newName = rec.get(0);
                }
                if(rec.getRecordNumber() == (currentIndex + girlsNum2) && rec.get(1).equals("M") && rec.get(1).equals(gender)){
                    newName = rec.get(0);
                }
            }
            
            if(newName != null){System.out.println(name + " born in " + year + " would be " + newName + " in " + newYear);}
                if(newName == null){System.out.println("Not found.");}
}
public int getGirls(CSVRecord rec,int girlsNum){
    if(rec.get(1).equals("F")){girlsNum ++;}
return girlsNum;
}

public void yearOfHighestRank(String name, String gender){
    long currentRank = 0;
    int yearCount = 0;
  long tempRank = 0;
   double averageRank = 0; 
   double averageTemp = 0;
   int yearCount2 = 0;
 DirectoryResource dr = new DirectoryResource();
     for(File f : dr.selectedFiles()){
         
         FileResource fr = new FileResource(f);
         yearCount2 ++;
         currentRank = getRank(2012,name,gender,fr.getCSVParser(false)) ;
        if (tempRank == 0){tempRank = currentRank;}
         averageTemp += currentRank;
         if(currentRank == 0){System.out.println("Not found");}
     System.out.println(currentRank);
     
     if (currentRank < tempRank){
         tempRank = currentRank;
         yearCount ++;
        }
    } 
    averageRank = averageTemp / yearCount2;
    System.out.println("Name: " + name + " was most popular in file no: " + yearCount);
    System.out.println("Average rank for name: " + name + " is: " +  averageRank);
    System.out.println(yearCount2);
}



//  ************** ALL TEST *************************
public void testYear(){
 yearOfHighestRank("Mich","M"); 
}

public int getTotalName(int year, String name, String gender){
 int total = 0;
 //int girlsNum = 0;
 String fname = "data1/yob" + year +".csv";
   FileResource fr = new FileResource(fname);
        for(CSVRecord rec : fr.getCSVParser(false)){
           //girlsNum =  getGirls(rec,girlsNum);
         if(!rec.get(0).equals(name) && rec.get(1).equals(gender)){
             total += Integer.parseInt(rec.get(2)); 
             System.out.println("Total at loop "+total);
            }
         if(rec.get(0).equals(name) && rec.get(1).equals(gender)) {
             break;
            }
        }
        //System.out.println(girlsNum + " girls num");
   //if(gender.equals("M")){total = total - girlsNum;}     
 return total;
}
public void testGetTotalName(){
 System.out.println("Total number is :"+getTotalName(1990,"Drew","M"));   
}
public void testAll(){
   // getRank(2012,"Mason","M");
//System.out.println("*******    ********");
    getName(2014,1,"M");
System.out.println("*******    ********");
    getName(2012,1,"M");
System.out.println("*******    ********");
 
whatIsNameInYear("Isabella",2012,2014,"F"); 
}
public long getRankSolo(String name, String gender){
    int girlsNum = 0;
    long currentIndex = 0;
    //fname = "yob" + year +"short.csv";
   FileResource fr =  new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            
            if (rec.get(1).equals("F")){girlsNum += 1;}
            // rank variable
            
            String genderCheck = rec.get(1);
           
             
             if(rec.get(0).equals(name) && genderCheck.equals(gender)){
                 currentIndex = rec.getRecordNumber();
                if(gender.equals("M"))
                {return currentIndex - girlsNum;}
                else
                { return currentIndex;}
                }
                
        }
        if (currentIndex != 0){if(gender.equals("M")){
                                   System.out.println("Name : " + name + 
                                                    " Rank is: " + (currentIndex - girlsNum));
                                                }
                                  if(gender.equals("F")){
                                   System.out.println("Name : " + name + 
                                  " Rank is: " + currentIndex);
                                                }
                                            }
        if (currentIndex == 0 ){System.out.println("Not Found.");}
       
        return currentIndex;
        
}
public void testRank(){
 //System.out.println(getRankSolo("Frank", "M"))  ; 
// getName(1982,450,"M");
 whatIsNameInYear("Owen",1974,2014,"M");
 
}
}
