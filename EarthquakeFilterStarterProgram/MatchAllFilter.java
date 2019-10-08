import java.util.*;
import edu.duke.*;

public class MatchAllFilter implements Filter
{
    private String name = "";
    
    
    public String getName(){
        for(Filter f : filterList){
        name = name + f.getName() + ", ";   
        }
        return name;
    }
    
    private ArrayList<Filter> filterList;
    
    public MatchAllFilter()
    {
        filterList = new ArrayList<Filter>();
    }

    public void addFilter(Filter f){
    filterList.add(f);   
    }
    
    public boolean satisfies(QuakeEntry qe){
        for(Filter f : filterList){
            if(!f.satisfies(qe)){
                return false;
            }
        }
    return true;    
    }
    
    
}
