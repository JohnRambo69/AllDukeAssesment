import java.util.Random;
import java.util.*;
import edu.duke.*;

public class EfficientMarkovModel extends AbstractMarkovModel
{
protected HashMap<String, ArrayList<String>> map;
    
    
    public EfficientMarkovModel(int f) {
        myRandom = new Random();
        feed = f;
        map = new HashMap<String, ArrayList<String>>();
    }
    
    
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        buildMap();
       
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
    
    protected void buildMap(){
        //.clear();
        for(int i = 0; i < myText.length() - feed; i++){
        String key = myText.substring(i, i+feed);
        String letter = myText.substring(i+feed, i+feed+1);
            if(map.containsKey(key)){
            
            map.get(key).add(key);
            }
            else{
            ArrayList<String> list = new ArrayList<String>();
            list.add(letter);
            map.put(key,list);
            
            }
        }
        String last = myText.substring(myText.length() - feed);
        ArrayList<String> list = new ArrayList<String>();
        list.add(" ");
        map.put(last,list);
    }
    
    
    
    @Override
    protected ArrayList<String> getFollows (String key){
    ArrayList<String> list = new ArrayList<String>();
    list = map.get(key);
 
    return list;  
    }
}
