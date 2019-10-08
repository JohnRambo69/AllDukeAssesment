

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int feed;
    
    
    public AbstractMarkovModel() {
        myRandom = new Random();
        
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    public String getFeed(){
        String s = "MarkovModel running at: " + feed;
    return s;   
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows (String key){
    ArrayList<String> list = new ArrayList<String>();
    int tempInx = 0;
    int index = 0;
    
        while(myText.indexOf(key, tempInx) != -1)
        {
        index = myText.indexOf(key, tempInx);
        if(index == myText.length() - 1){
            break;
        }
        String temp = myText.substring(index + key.length(), index + (key.length() + 1));
        list.add(temp);
        tempInx = index +1;
        }
    return list;
        
    }
}
