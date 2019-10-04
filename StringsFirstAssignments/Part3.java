
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public String StringFirstAssigments(String stringA, String stringB)
    {
        String fraza;
        String temp = stringB;
        String temp2;
        int dlugosc = stringA.length();
     int firstIndexC = stringB.indexOf(stringA);
     int firstIndex = 0;
     int off = 0;
     int count = 0;
     if (firstIndexC == -1){
         return  "Nie wystepuje.";
        }
        do {
            if (firstIndex <= -1) {
            return "-- W sumie znaleziono fraze :" + stringA + " --tyle razy: " + count;
        }
            firstIndex = temp.indexOf(stringA);
            fraza = temp.substring(firstIndex, (firstIndex +dlugosc));
            temp2 = temp.substring(firstIndex + dlugosc);
                //System.out.println("temp2"+ temp2);
            System.out.println("Szukamy: " +fraza);
            //System.out.println("off"+off);
            //System.out.println("indexstart"+ firstIndex);
            //System.out.println("dlugosc"+dlugosc);
            //System.out.println("pierwszy index"+firstIndex);
            off = off + dlugosc;
            temp = temp2;
            //System.out.println("off teraz:" +off);
            System.out.println("Zostalo do przeszukania teraz:" + temp);
           firstIndex = temp.indexOf(stringA);
           System.out.println("pierwszy index"+firstIndex);
           
            count = count +1;
            
        
    }
      
        while (firstIndex >= -1);
        return "Koniec";
      
    }
    
    public void checkIf(){
        
    }
    public void testA()
    {
     String val1;
     String val2;
     String result;
     // pierwszy test
     val1 = "aa";
     val2 = "aabbbbaabbbbaa";
    result = StringFirstAssigments(val1,val2);
     System.out.println(result);
     
       // pierwszy test
     val1 = "abc";
     val2 = "aldafhsdhfabcashashabcsajdhasdabcabc";
    result = StringFirstAssigments(val1,val2);
     System.out.println(result);
     
       // pierwszy test
     val1 = "g";
     val2 = "nsudgatdgncgskrkgoxnagwkdng";
    result = StringFirstAssigments(val1,val2);
     System.out.println(result);
    }
}
