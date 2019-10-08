import java.util.Random;
import java.util.*;

public class MarkovModel
{
 private String myText;
    private Random myRandom;
    private int feed;
    
    public MarkovModel(int f) {
        myRandom = new Random();
        feed = f;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - feed);
        String key = myText.substring(index, index +feed);
        sb.append(key);
        for(int k=0; k < numChars - feed; k++){
          
            ArrayList<String> letters = getFollows(key);
            if(letters.size() == 0){
            break;   
            }
            int randomList = myRandom.nextInt(letters.size());
            String next = letters.get(randomList);
            sb.append(next);
            key = key.substring(1) + next;
        }
        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows (String key){
    ArrayList<String> list = new ArrayList<String>();
    int tempInx = 0;
    int index = 0;
    
        while(myText.indexOf(key, tempInx) != -1){
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
