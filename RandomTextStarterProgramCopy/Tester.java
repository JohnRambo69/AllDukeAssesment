
import edu.duke.*;
import java.util.*;


public class Tester
{
    public void testGetFollows(){
    MarkovOne mo = new MarkovOne();
    FileResource fr = new FileResource();
   
    String test = fr.asString();
    mo.setTraining(test);
    
    ArrayList<String> testList = mo.getFollows("th");
    System.out.println(testList.size());
    }
}
