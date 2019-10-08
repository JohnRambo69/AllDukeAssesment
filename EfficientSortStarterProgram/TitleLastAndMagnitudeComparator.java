import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>
{

@Override
public int compare(QuakeEntry q1, QuakeEntry q2){
    String [] split1 = q1.getInfo().split(" ");
String a = split1[split1.length - 1];
String [] split2 = q2.getInfo().split(" ");
String b = split2[split2.length - 1];

int result = a.compareTo(b);
    if (result == 0){
    return Double.compare(q1.getMagnitude(),q2.getMagnitude());
    }
return result;
}
}
