import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
            for(QuakeEntry q : quakeData){
                if(q.getMagnitude() > magMin){
                answer.add(q);    
                }
            }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        int current = 0;
            for(QuakeEntry q : quakeData){
                
                Location curr = q.getLocation();
                if(from.distanceTo(curr) < distMax ){
                  answer.add(q);
                }
            }

        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,double minDepth, double maxDepth){
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry q : quakeData){
            if(q.getDepth() > minDepth && q.getDepth() < maxDepth){
            answer.add(q);   
            }
        }
    return answer;   
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String name, String phrase){
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry q : quakeData){
            String check = q.getInfo();
                if(check.startsWith(name) && phrase.equals("start")){
                answer.add(q);    
                }
                if(check.endsWith(name) && phrase.equals("end")){
                answer.add(q);    
                }
                if(check.contains(name) && phrase.equals("any")){
                answer.add(q);    
                }
        }
    return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
            // call filter by magnitude and print out
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list,5.0);
        int magCount = 0;
            for(QuakeEntry q : listBig){
             System.out.println(q); 
             magCount ++;
            }
        System.out.println("Found " + magCount + " that matching this criteria.");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
       // Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        double distMax = 1000000;    
        ArrayList<QuakeEntry> filterByDis = filterByDistanceFrom(list,distMax,city);
        int count = 0;
        for(QuakeEntry q : filterByDis){
        System.out.println(q);  
        count ++;
        }
        System.out.println("Found " + count + " that matching this criteria.");
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
        
    }
    
    public void quakesOfDepth(){
    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
            // call filter by magnitude and print out
        ArrayList<QuakeEntry> listBig = filterByDepth(list,-4000,-2000);
        int magCount = 0;
            for(QuakeEntry q : listBig){
             System.out.println(q); 
             magCount ++;
            }
        System.out.println("Found " + magCount + " that matching this criteria.");   
    }
    
    public void quakesByPhrase(){
    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
            // call filter by magnitude and print out
        ArrayList<QuakeEntry> listBig = filterByPhrase(list,"Can","any");
        int magCount = 0;
            for(QuakeEntry q : listBig){
             System.out.println(q); 
             magCount ++;
            }
        System.out.println("Found " + magCount + " that matching this criteria.");   
    }
}
