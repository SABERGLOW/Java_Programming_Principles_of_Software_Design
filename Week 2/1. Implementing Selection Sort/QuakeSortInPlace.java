
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.IOException;
import java.util.*;
import edu.duke.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class QuakeSortInPlace
{
    public QuakeSortInPlace()
    {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from)
    {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++)
        {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude())
            {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakes, int from)
    {
        int largestIdx = from;
        for (int i=from+1; i< quakes.size(); i++)
        {
            if (quakes.get(i).getDepth() > quakes.get(largestIdx).getDepth())
            {
                largestIdx = i;
            }
        }
        return largestIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in)
    {
       
       for (int i=0; i< in.size(); i++)
       {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in)
    {

        for (int i=0; i<70; i++)
        {
            int largestDepth = getLargestDepth(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(largestDepth);
            in.set(i,qmax);
            in.set(largestDepth,qi);
        }

    }
/////////////////////////////////// Assignment 2 /////////////////////////////////////////
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted)
    {
        for (int i=1; i< quakeData.size()-numSorted; i++)
        {
            if (quakeData.get(i-1).getMagnitude() > quakeData.get(i).getMagnitude())
            {
                QuakeEntry temp = quakeData.get(i-1);
                quakeData.set(i-1, quakeData.get(i));
                quakeData.set(i, temp);
            }
        }
    }

    public void sortByMagnitudeWithBubbleSort (ArrayList<QuakeEntry> in)
    {

        for (int i=0; i< in.size(); i++)
        {
            onePassBubbleSort(in, i);
        }

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////// Assignment 3 /////////////////////////////////////////
    public boolean checkInSortedOrder (ArrayList<QuakeEntry> quakes)
    {
        for (int i=1; i< quakes.size(); i++)
        {
            if (quakes.get(i-1).getMagnitude() > quakes.get(i).getMagnitude())
            {
                return false;
            }
        }
        return true;
    }

    public void sortByMagnitudeWithBubbleSortWithCheck (ArrayList<QuakeEntry> in)
    {
        int i = 0;
        for (i=0; i< in.size(); i++)
        {
            if(checkInSortedOrder(in))
            {
                break;
            }
            onePassBubbleSort(in, i);
        }
        System.out.println("Passes required to Bubble Sort: " + i);
    }

    public void sortByMagnitudeWithWithCheck (ArrayList<QuakeEntry> in)
    {
        int i = 0;
        for (i=0; i< in.size(); i++)
        {
            if(checkInSortedOrder(in))
            {
                break;
            }
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        System.out.println("Passes required to Sort: " + i);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////
    public void testSort()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithWithCheck(list);

        for (QuakeEntry qe: list)
        {
            System.out.println(qe);
        }
    }
    
    public void createCSV()
    {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\wali6\\Documents\\Programming Projects\\IDEA Projects\\src\\data\\earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list)
     {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}

    public static void main(String[] args)
    {
        QuakeSortInPlace QSIP = new QuakeSortInPlace();
        QSIP.testSort();
    }
}
