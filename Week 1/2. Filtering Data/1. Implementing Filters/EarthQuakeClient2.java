import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f)
    {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        }
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        /*
        Filter magnitudeFilter = new MagnitudeFilter(4.0, 5.0);
        Filter depthFilter = new DepthFilter(-35000.0, -12000.0);
        ArrayList<QuakeEntry> m7  = filter(filter(list, magnitudeFilter), depthFilter);
        for (QuakeEntry qe: m7)
        {
            System.out.println(qe);
        }
         */

        Location tokyo = new Location(35.42, 139.43);
        Filter within = new DistanceFilter(tokyo, 10000000);
        Filter phrase = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> m7  = filter(filter(list, within), phrase);
        for (QuakeEntry qe: m7)
        {
            System.out.println(qe);
        }
    }


    public static void main(String[] args)
    {
        EarthQuakeClient2 TEST = new EarthQuakeClient2();
        TEST.quakesWithFilter();
    }

}
