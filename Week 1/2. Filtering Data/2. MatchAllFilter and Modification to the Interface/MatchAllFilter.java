import java.util.ArrayList;

public class MatchAllFilter implements Filter
{
    private ArrayList<Filter> filterArrayList;

    public MatchAllFilter()
    {
        filterArrayList = new ArrayList<>();
    }

    public void addFilter(Filter addMeFilter)
    {
        filterArrayList.add(addMeFilter);
    }

    public boolean satisfies(QuakeEntry qe)
    {
        for(Filter filter: filterArrayList)
        {
            if(!filter.satisfies(qe))
            {
                return false;
            }
        }
        return true;
    }

    public String getName()
    {
        StringBuilder sb = new StringBuilder();
        for(Filter filter: filterArrayList)
        {
            sb.append(filter.getName()+" ");
        }
        return sb.toString();
    }
}
