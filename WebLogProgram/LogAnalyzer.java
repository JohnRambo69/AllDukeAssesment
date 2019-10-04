
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     private ArrayList<String> uniqueIps;
     private ArrayList<String> ipsAtDay;
     
     private HashMap<String, Integer> counts;
     WebLogParser wlp = new WebLogParser();
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
         uniqueIps = new ArrayList<String>();
         ipsAtDay = new ArrayList<String>();
         
         counts = new HashMap<String, Integer>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String s : fr.lines()){
             
             records.add(wlp.parseEntry(s));
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
   public  ArrayList<LogEntry> getRecords(){
      return records; 
    }
    
    public int countUniqueIps(){
    
    
        for(LogEntry le : records){
        String temp = le.getIpAddress();
            if(!uniqueIps.contains(temp)){
                uniqueIps.add(temp);
            }
        }
    return uniqueIps.size();
    }
    
    public void printAllHigherThanNum(int num){
    System.out.println("***** LIST OF LOGS WITH STATUS NUMBER GREATER THAN " + num + " *****");
        for(LogEntry le : records){
            int tStat = le.getStatusCode();
                if(tStat > num){
                String temp = le.toString();
                //System.out.println(temp);
                }
        }
    System.out.println("*****     END OF LIST     *****");
    }
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        for(LogEntry le : records){
        Date tempD = le.getAccessTime();
        String temp = tempD.toString();
        String temp2 = le.getIpAddress();
            if(temp.contains(someday) && ipsAtDay.indexOf(temp2) == -1){
                ipsAtDay.add(temp2);
            }
        }
        return ipsAtDay;
    }
   
   public int countUniqueIPsInRange(int min, int max){
       ArrayList<String> count = new ArrayList<String>();
       for(LogEntry le : records){
         int tempStat = le.getStatusCode();
         String tempIp = le.getIpAddress();
                        
            if(tempStat < max && tempStat > min && !count.contains(tempIp)){
             count.add(tempIp); 
                            // System.out.println("addesd");
            }
        }
        int out = count.size();
    return out;
    }
    
    public HashMap<String,Integer>  countVisitsPerIP(){
    
        
        for(LogEntry le : records){
        String tempIp = le.getIpAddress();
            if(!counts.containsKey(tempIp)){
                counts.put(tempIp,1);
            }
            else{
                counts.put(tempIp, counts.get(tempIp) + 1);
            }
        }
        return counts;
    }
    
    public int mostNumberVisitsByIP(){
    int result = 0;
    
    for(int i : counts.values()){
        //System.out.println(i);
        if(i > result){
           
         result = i;   
        }
    }
    
    return result;
    }
    
    public ArrayList<String> iPsMostVisits(){
        ArrayList<String> mostIp = new ArrayList<String>();
        
        
       int max = mostNumberVisitsByIP();
       for(String s : counts.keySet()){
           int check = counts.get(s);
           if(check == max){
             mostIp.add(s);  
            }
        }
        return mostIp;
    }
    private String convertTo(Date date){
        String conv = date.toString();
        conv = conv.substring(4,10);
        
        return conv;    
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
       //ArrayList<String> ipNo = new ArrayList<String>();
        for(LogEntry le : records){
         String dat = convertTo(le.getAccessTime()); 
         String ip = le.getIpAddress();
       
       
       
                if(!list.containsKey(dat)){
                    ArrayList<String> ipNo = new ArrayList<String>();
                    ipNo.add(ip);
                    list.put(dat,ipNo);
                }
                else{
                    
                 list.get(dat).add(ip);   
                }
        }
        return list;
        
    }
    
    public String dayWithMostIPVisits(){
        HashMap<String, ArrayList<String>> list = iPsForDays();
        String day = "";
        int check = 0;
       for(String s : list.keySet()){
         int len = list.get(s).size();

            if(len > check){
                check = len;
             day = s;   
            }
        }
        return day;
    }
    public HashMap<String, Integer> iPsWithMostVisitsOnDay(String day){
     HashMap<String, ArrayList<String>> list = iPsForDays();
     //System.out.println(list);
     HashMap<String, Integer> allNumber = new HashMap<String, Integer>();
     
     if(list.containsKey(day)){
         //System.out.println("zmalazl");
            for(String s : list.get(day)){
                if(!allNumber.containsKey(s)){
                allNumber.put(s,1);
                }
                else{
                allNumber.put(s, allNumber.get(s) + 1);   
                }
            }
        }
        return allNumber;
    }
}
