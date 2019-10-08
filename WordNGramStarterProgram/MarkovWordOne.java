


import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        
        return sb.toString().trim();
    }
    
    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
            for(int i = 0; i < myText.length; i ++){
            int index = indexOf(myText, key, i);
            if(index != -1){
                if(index < myText.length - 1){
            follows.add(myText[index +1]); 
            i = index;
        }
            }
            }
        return follows;
    }

    private int indexOf(String[] words, String target, int start){
        for(int i = start; i < words.length; i++){
            if( words[i].equals(target)){
            return i;   
            }
        }
        return -1;
    }
    
    public void testIndexOf(){
        String testString = "this is just a test yes this is a simple test";
        String[] testArray = testString.split(" ");
        System.out.println(indexOf(testArray,"this",0));
        System.out.println(indexOf(testArray,"this",3));
        System.out.println(indexOf(testArray,"frog",0));
        System.out.println(indexOf(testArray,"frog",5));
        System.out.println(indexOf(testArray,"simple",2));
        System.out.println(indexOf(testArray,"test",5));
    }
    
    public void testGetFollows(){
     String testString = "this is just a test yes this is a simple test";
        String[] testArray = testString.split(" ");
        myText = testArray;
        for(int i = 0; i < testArray.length; i++){
            ArrayList<String> follows = getFollows(testArray[i]);
            System.out.println(follows);
        }
    }
}
