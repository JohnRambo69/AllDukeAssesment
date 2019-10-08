
public class DistanceFilter implements Filter
{
private Location location;
private double maxDistance;
private String name;

public String getName(){
    return name;
    
}
    public DistanceFilter(Location loc, double max, String nam)
    {
        location = loc;
        maxDistance = max;
        name = nam;
    }
    @Override
    public boolean satisfies(QuakeEntry qe){
    return  qe.getLocation().distanceTo(location) < maxDistance; 
    }
}
