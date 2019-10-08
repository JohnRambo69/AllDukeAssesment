import java.util.Random;
import java.util.*;

public class MarkovModel extends AbstractMarkovModel
{

    
    
    public MarkovModel(int f) {
        myRandom = new Random();
        feed = f;
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
    

}
