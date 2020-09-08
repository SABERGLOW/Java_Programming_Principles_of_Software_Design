import java.util.*;
import edu.duke.*;

public class LargestQuakes
{

    public void findLargestQuakes()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("Total Items: " + list.size());

        ArrayList<QuakeEntry> largeList = getLargest(list, 5);
        for(QuakeEntry qe: largeList)
        {
            System.out.println(qe);
        }
    }

    public int indexOfLargest(ArrayList<QuakeEntry> data)
    {
        double maxMag = 0;
        int index = 0;

        for(QuakeEntry qe: data)
        {
            if(qe.getMagnitude() >= maxMag)
            {
                maxMag = qe.getMagnitude();
                index = data.indexOf(qe);
            }
        }
        return index;
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany)
    {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();

        while(ret.size() < howMany || copy.size()==0)
        {
            int minIndex = indexOfLargest(copy);
            ret.add(copy.get(minIndex));
            copy.remove(minIndex);
        }
        return ret;
    }

    public static void main(String []args)
    {
        LargestQuakes ES = new LargestQuakes();
        ES.findLargestQuakes();
    }

}
