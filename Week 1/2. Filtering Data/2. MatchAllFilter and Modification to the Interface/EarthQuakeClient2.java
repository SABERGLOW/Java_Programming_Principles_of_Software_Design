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
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        /*
        Filter magnitudeFilter = new MagnitudeFilter(4.0, 5.0);
        Filter depthFilter = new DepthFilter(-35000.0, -12000.0);
        ArrayList<QuakeEntry> m7  = filter(filter(list, magnitudeFilter), depthFilter);
        for (QuakeEntry qe: m7)
        {
            System.out.println(qe);
        }*/


        Location tokyo = new Location(35.42, 139.43);
        Filter within = new DistanceFilter(tokyo, 10000000);
        Filter phrase = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> m7  = filter(filter(list, within), phrase);
        for (QuakeEntry qe: m7)
        {
            System.out.println(qe);
        }
        System.out.println("TOTAL QUAKES RESULTS: " + m7.size());
    }

    public void testMatchAllFilter()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter("Magnitude", 0.0, 2.0));
        maf.addFilter(new DepthFilter("Depth", -100000.0 , -10000.0));
        maf.addFilter(new PhraseFilter("Phrase","any", "a"));
        ArrayList<QuakeEntry> m7  = filter(list, maf);
        for (QuakeEntry qe: m7)
        {
            System.out.println(qe);
        }
        System.out.println("TOTAL QUAKES RESULTS: " + m7.size());
        System.out.println("Filters used are: " + maf.getName());
    }

    public void testMatchAllFilter2()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0, 3.0));
        Location TulsaOklahoma = new Location(36.1314, -95.9372);
        maf.addFilter(new DistanceFilter(TulsaOklahoma , 10000000 ));
        maf.addFilter(new PhraseFilter("any", "Ca"));
        ArrayList<QuakeEntry> m7  = filter(list, maf);
        for (QuakeEntry qe: m7)
        {
            System.out.println(qe);
        }
        System.out.println("TOTAL QUAKES RESULTS: " + m7.size());
    }


    public static void main(String[] args)
    {
        EarthQuakeClient2 TEST = new EarthQuakeClient2();
        TEST.quakesWithFilter();
    }

}
