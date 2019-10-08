
public class MagnitudeFilter implements Filter
{
private double minMag;
private double maxMag;
private String name;

public String getName(){
    
    return name;
}

    public MagnitudeFilter(double min, double max, String nam)
    {
        minMag = min;
        maxMag = max;
        name = nam;
    }

    public boolean satisfies(QuakeEntry qe){
    return qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag;
    }
    

}
