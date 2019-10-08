
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 
import java.util.*;

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        
        markov.setTraining(text);
        markov.setRandom(seed);
        String f = markov.getFeed();
        System.out.println(f);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int s = 10;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,s);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,s);
      
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,s);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,s);
      
        EfficientMarkovModel emm = new EfficientMarkovModel(5);
        
        runModel(emm, st,size,s);
        
        System.out.println(emm.map.size());
        int tempSize = 0;
        for(ArrayList<String> q : emm.map.values()){
            if(q.size() > tempSize){
                tempSize = q.size();
            }
        }
        System.out.println(tempSize);
    }
   

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    public void compareMethods(){
    FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int s = 42;
    MarkovModel mThree = new MarkovModel(2);
        long time1 = System.nanoTime();
        runModel(mThree, st, size,s);
        long time2 = System.nanoTime() - time1;
        System.out.println("******" + time2);
      
        EfficientMarkovModel emm = new EfficientMarkovModel(2);
        time1 = System.nanoTime();
        runModel(emm, st,size,s); 
        time2 = System.nanoTime() - time1; 
        System.out.println("******" + time2);
    }
    
    
    public void testHashMap(){
        EfficientMarkovModel emm = new EfficientMarkovModel(5);
        int size = 1000;
        int s = 531;
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        emm.myText = st;
        emm.buildMap();
        int maxS = 0;
        if(emm.map.size() > 50){
        for(String q : emm.map.keySet()){
            //System.out.println(
                if(emm.map.get(q).size() > maxS){
                 maxS = emm.map.get(q).size();   
                }
            //System.out.println(q);
            //System.out.println(emm.map.get(q));
            
        }
    }
        System.out.println("Map size: " + emm.map.size());
        System.out.println("Biggest size: " + maxS);
    }
    
}
