


import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram, ArrayList<String>> map;
    
    public void buildMap(){
    map = new HashMap<WordGram, ArrayList<String>>();
        for (int k=0; k<myText.length-myOrder; k++) {
            
            WordGram kGram = new WordGram(myText, k, myOrder);
            String follow = myText[k+kGram.length()];
            if (map.containsKey(kGram)) {
                map.get(kGram).add(follow);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(follow);
                map.put(kGram, list);
            }
        }
        WordGram kGram = new WordGram(myText, myText.length-myOrder, myOrder);
        if (!(map.containsKey(kGram))){
            ArrayList<String> list = new ArrayList<String>();
            map.put(kGram, list);
        }    
    }
    
    public EfficientMarkovWord(int order) {
        myRandom = new Random();
        myOrder = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
        WordGram key = new WordGram(myText,index,myOrder);
        
        sb.append(key);
        sb.append(" ");
        
        for(int k=0; k < numWords - myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }

            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }
        
        return sb.toString().trim();
    }
    
    private ArrayList<String> getFollows(WordGram kGram) {   
        return map.get(kGram);
    }

    private int indexOf(String[] words, WordGram target, int start){
        
        for(int i = start; i < words.length - myOrder; i++){
            WordGram wg = new WordGram(words,i,myOrder);
            if( wg.equals(target)){
            return i;   
            }
        }
        return -1;
    }
    
   public void printHashMapInfo(){
     System.out.println("**** HashMap ****");
     System.out.println("Size: " + "\t" + map.size());
     
     int bigValue = 0;
     String hash = "";
        for(WordGram w : map.keySet()){
            ArrayList<String> a = map.get(w);
            if(a.size() > bigValue){
             bigValue = a.size();  
             hash = w.toString();
            }
        }
     System.out.println("Biggest value: " + "\t" + bigValue);
     System.out.println(hash);
     
    }
}
