


import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
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
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        String key2 = myText[index+1];
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key, key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key2;
            key2 = next;
            
        }
        
        return sb.toString().trim();
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        ArrayList<String> follows = new ArrayList<String>();
            for(int i = 0; i < myText.length; i ++){
            int index = indexOf(myText, key1, key2, i);
            
            if(index != -1){
                if(index < myText.length - 2){
                    follows.add(myText[index +2]); 
                    i = index;
                }
            }
            }
        return follows;
    }

    private int indexOf(String[] words, String target1,String target2, int start){
        for(int i = start; i < words.length - 1; i++){
            if( words[i].equals(target1) && words[i+1].equals(target2)){
            return i;   
            }
        }
        return -1;
    }
    
    public void testIndexOf(){
        /*
        String testString = "this is just a test yes this is a simple test";
        String[] testArray = testString.split(" ");
        System.out.println(indexOf(testArray,"this",0));
        System.out.println(indexOf(testArray,"this",3));
        System.out.println(indexOf(testArray,"frog",0));
        System.out.println(indexOf(testArray,"frog",5));
        System.out.println(indexOf(testArray,"simple",2));
        System.out.println(indexOf(testArray,"test",5));
        */
    }
    
    public void testGetFollows(){
     String testString = "this is just a test yes this is a simple test";
        String[] testArray = testString.split(" ");
        myText = testArray;
        for(int i = 0; i < testArray.length -1; i++){
            ArrayList<String> follows = getFollows(testArray[i], testArray[i+1]);
            System.out.println(follows);
        }
    }
    
}
