import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry>
{
    public int compare(QuakeEntry q1, QuakeEntry q2)
    {
        int titleCompare = (q1.getInfo()).compareTo(q2.getInfo());
        if(titleCompare != 0)
        {
            return titleCompare;
        }
        else
        {
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
    }
}
