

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getLargestDepth(ArrayList<QuakeEntry> quakes, int from){
        int maxInd = from;
            for(int i=from+1; i < quakes.size(); i++){
                if(quakes.get(maxInd).getDepth() < quakes.get(i).getDepth()){
                maxInd = i;  
                }
            }
        return maxInd;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> quakes){
        
        for(int i = 0; i < quakes.size(); i++){
         int maxInd = getLargestDepth(quakes, i);
         QuakeEntry temp = quakes.get(i);
         QuakeEntry max = quakes.get(maxInd);
         quakes.set(i, max);
         quakes.set(maxInd,temp);
        }
    }
    
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
       int passes = 0;
       boolean check = checkInSortedOrder(in);
       for(int i=0; i< in.size();i++){
        if(!check){
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            check = checkInSortedOrder(in);
            passes ++;
        }
        }
        System.out.println("List was sorted : " + passes+ " times.");
    }

    public void testSort() {
        
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes"); 
        
        /*
        sortByMagnitude(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        */
       
       //sortByLargestDepth(list);
      /*
       int quakeNumber = 50;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));   
       */
       //sortByMagnitudeWithBubbleSort(list);
       sortByMagnitudeWithBubbleSortWithCheck(list);
       
       //sortByMagnitudeWithCheck(list);
       
      /* 
       for(QuakeEntry q : list){
           System.out.println(q);
        }
        */
        
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
        
            for(int i = numSorted; i < quakeData.size() - 1; i ++){
                if(quakeData.get(i).getMagnitude() > quakeData.get(i+1).getMagnitude()){
                QuakeEntry min = quakeData.get(i);
                QuakeEntry max = quakeData.get(i+1);
                quakeData.set(i, max);
                quakeData.set(i+1,min);
                }
            }
        
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for(int i = 0; i < quakes.size()-1; i++){
            if(quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()){
             
             return false;   
            }
        }
        return true;   
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i = 0; i < in.size(); i++){
        onePassBubbleSort(in, 0);    
        }
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        int passes = 0;
        boolean check = checkInSortedOrder(in);
        for(int i=0; i< in.size();i++){
        if(!check){
            onePassBubbleSort(in, 0); 
            check = checkInSortedOrder(in);
            passes ++;
        }
        }
        System.out.println("List was sorted : " + passes+ " times.");
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
}
