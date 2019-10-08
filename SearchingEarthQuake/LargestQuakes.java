
import java.util.*;


public class LargestQuakes
{
    // instance variables - replace the example below with your own
    private int x;

    
    public LargestQuakes()
    {
        // initialise instance variables
        
    }
    public int indexOfLargest(ArrayList<QuakeEntry> data){
    int indexOf = 0;
    double bigMag = 0;
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getMagnitude() > bigMag){
            bigMag = data.get(i).getMagnitude();
            indexOf = i;
            }
        }
    return indexOf;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    ArrayList<QuakeEntry> copy = quakeData;
        for(int i=0; i < howMany; i ++){
        int index = indexOfLargest(copy);
        answer.add(copy.get(index));
        copy.remove(index);
        }
        
    return answer;
    }
    
    public void findLargestQuakes(){
    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    String source = "data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list  = parser.read(source);
    System.out.println("read data for "+list.size()+" quakes");
        
    int indexOfLargest = indexOfLargest(list);
    QuakeEntry largestMag = list.get(indexOfLargest);
    System.out.println("Location : " + indexOfLargest);
    System.out.println(largestMag);
    System.out.println("_______________________");
    ArrayList<QuakeEntry> magList = getLargest(list, 50);
        for(QuakeEntry q : magList){
            System.out.println(q);
        }
    }
    
   
    
   
}
