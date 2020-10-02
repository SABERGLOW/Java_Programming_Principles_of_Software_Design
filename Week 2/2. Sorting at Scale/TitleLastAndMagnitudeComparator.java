import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>
{
    public int compare(QuakeEntry q1, QuakeEntry q2)
    {
        String[] q1Title = q1.getInfo().split("\\W", 0);
        String[] q2Title = q2.getInfo().split("\\W", 0);

        String q1lastWord = "";
        String q2lastWord = "";
        if(q1Title.length == 0)
        {
            q1lastWord = q1.getInfo();
        }
        else
        {
            q1lastWord = q1Title[q1Title.length-1];
        }

        if(q1Title.length == 0)
        {
            q2lastWord = q2.getInfo();
        }
        else
        {
            q2lastWord = q2Title[q2Title.length-1];
        }


        int titleCompare = q1lastWord.compareTo(q2lastWord);
        if(titleCompare != 0)
        {
            return titleCompare;
        }
        else
        {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
    }
}
