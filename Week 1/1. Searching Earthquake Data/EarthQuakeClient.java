import java.util.*;
import edu.duke.*;

public class EarthQuakeClient
{
    
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin)
    {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from)
    {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth)
    {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getDepth() > minDepth && qe.getDepth()<maxDepth)
            {
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase)
    {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData)
        {
            String title = qe.getInfo();
            if (where.equals("start") && title.startsWith(phrase))
            {
                answer.add(qe);
            }
            else if (where.equals("end") && title.endsWith(phrase))
            {
                answer.add(qe);
            }
            else if (where.equals("any") && title.contains(phrase))
            {
                answer.add(qe);
            }
        }
        return answer;
    }

    public void quakesOfDepth()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        ArrayList<QuakeEntry> deep = filterByDepth(list, -10000.0 , -8000.0 );
        for (QuakeEntry qe: deep)
        {
            System.out.println(qe);
        }
        System.out.println("Total Items: "+ deep.size());
    }

    public void quakesByPhrase()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        ArrayList<QuakeEntry> phrased = filterByPhrase(list, "any", "Creek" );
        for (QuakeEntry qe: phrased)
        {
            System.out.println(qe);
        }
        System.out.println("Total Items: "+ phrased.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
	
	public void bigQuakes()
    {
	    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        /*
        for (QuakeEntry qe : list)
        {
            if (qe.getMagnitude() > 5.0)
            {
                System.out.println(qe);
            }
        }
        */
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listBig)
        {
           System.out.println(qe); 
        }
	}
	
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
    }

    public static void main(String []args)
    {
        EarthQuakeClient ES = new EarthQuakeClient();
        ES.quakesByPhrase();
    }
}
