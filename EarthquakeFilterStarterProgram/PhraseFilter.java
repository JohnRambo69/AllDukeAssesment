
public class PhraseFilter implements Filter
{
    private String phrase;
    private String value;
    private String name;
    
    public String getName(){
    return name;    
    }
    public PhraseFilter(String phr, String val, String nam)
    {
        phrase = phr;
        value = val;
        name = nam;
    }

    public boolean satisfies(QuakeEntry qe){
    return (qe.getInfo().startsWith(phrase) && value.equals("start")) 
    || (qe.getInfo().endsWith(phrase) && value.equals("end")) 
    || (qe.getInfo().contains(phrase) && value.equals("any"));
    }
}
