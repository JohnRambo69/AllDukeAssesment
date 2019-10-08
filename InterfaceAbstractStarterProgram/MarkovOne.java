import java.util.Random;
import java.util.*;

public class MarkovOne extends AbstractMarkovModel
{
    
    
    public MarkovOne() {
        myRandom = new Random();
        feed = 1;
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
            int randomList = myRandom.nextInt(letters.size());
            String next = letters.get(randomList);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
    }
    

}
