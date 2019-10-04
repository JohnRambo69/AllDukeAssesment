
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    
    // MNUAL ENTRIES
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    
 // CALL READFILE MANUL, CALL PRINT ALL   
    public void testLogAnalyzer() {
        // initialize la object
        LogAnalyzer la = new LogAnalyzer();
        // initialize file directory
        String file1 = "weblog2_log";
        // initialize LogAnalizer readFile
        la.readFile(file1);
        
        // print out all logs
        //la.printAll();
        
        // calling print number of uniques ip
        int tempUnique = la.countUniqueIps();
        System.out.println("**** Number of unique IP's is:  " + tempUnique);
        // print list status greater than
        //System.out.println("<<<< All greather than >>>>");
        //la.printAllHigherThanNum(400);
    
        // call ips numbers at specific date in format Sep 30
        //String day = "Mar 24";
        //ArrayList<String> getIpDay = la.uniqueIPVisitsOnDay(day);
        //int tempX = getIpDay.size();
        //System.out.println("** List of IP's from day " + day + " **" + tempX);
        
           
            //System.out.println("*****");
        // call unique ip cont in size range
        int statTemp = la.countUniqueIPsInRange(200,299);
        System.out.println("In this range is : " + statTemp);
        
        
        HashMap<String, Integer>  tempIp = la.countVisitsPerIP();
        System.out.println(tempIp);
        // njwiecej wizyt
        int mostVisit = la.mostNumberVisitsByIP();
        System.out.println("Most visit  by single ip : " + mostVisit);
        
        ArrayList<String> printMost =  la.iPsMostVisits();
        System.out.println(printMost);
        
        HashMap<String,ArrayList<String>> temp = la.iPsForDays();
        System.out.println(temp);
        
        String day = la.dayWithMostIPVisits();
        System.out.println("Day with most visits is: " + day);
        
        HashMap<String, Integer> spec = la.iPsWithMostVisitsOnDay("Sep 30");
        System.out.println("List of ip from day");
        System.out.println(spec);
        int aa = spec.size();
        
        System.out.println(aa + "aray size");
    }


}
