import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        
        Filter mag = new MagnitudeFilter(3.5,4.5, "Mag");
        Filter dep = new DepthFilter(-55000.0,-20000.0, "Dep");
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>(); 
        for (QuakeEntry qe: list) { 
            if(mag.satisfies(qe) && dep.satisfies(qe)){
            answer.add(qe);    
            }
        } 
        
        for(QuakeEntry q : answer){
        System.out.println(q);    
        }
        
       /*
       Location japan = new Location(35.42, 139.43);
       Filter dist = new DistanceFilter(japan,10000000,"Distance");
       Filter phr = new PhraseFilter("Japan","end", "Distance");
       
       ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
       for(QuakeEntry qe : list){
            if(dist.satisfies(qe) && phr.satisfies(qe)){
             answer.add(qe);   
            }
        }
       
        for(QuakeEntry q : answer){
         System.out.println(q);   
        }
        */
        System.out.println("Total: " + answer.size());
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
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

    public void testAllMatchFilters(){
    EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    MatchAllFilter fl = new MatchAllFilter();
    Filter mag = new MagnitudeFilter(1.0,4.0,"Magnitude");
    Filter dep = new DepthFilter(-180000.0,-30000.0,"Depth");
    Filter phr = new PhraseFilter("o","any","Phrase");
    Location oklahoma = new Location(36.1314, -95.9372);
    Location denver = new Location(55.7308, 9.1153);
    Filter dis = new DistanceFilter(denver,3000000,"Distance");
    fl.addFilter(mag);
    fl.addFilter(dep);
    fl.addFilter(phr);
    answer.clear();
    for(QuakeEntry qe : list){
        if(fl.satisfies(qe)){
            answer.add(qe);  
    
        }
    }
    for(QuakeEntry q : answer){
    System.out.println(q);    
    }
    System.out.println("Total found: " + answer.size());
    System.out.println("Filter used are: " + fl.getName());
    }
}

