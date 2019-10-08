
public class DepthFilter implements Filter
{
private double minDepth;
private double maxDepth;
private String name;

public String getName(){
    return name;
}

    public DepthFilter(double min, double max, String nam)
    {
        minDepth = min;
        maxDepth = max;
        name = nam;
    }

    public boolean satisfies(QuakeEntry qe){
    return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;   
    }
}
