public class PhraseFilter implements Filter
{
    private String param;
    private String query;

    public PhraseFilter(String where, String searchQuery)
    {
        param = where;
        query = searchQuery;
    }

    public boolean satisfies(QuakeEntry qe)
    {
        if(param.equals("start"))
        {
            return qe.getInfo().startsWith(query);
        }
        else if(param.equals("end"))
        {
            return qe.getInfo().endsWith(query);
        }
        else if(param.equals("any"))
        {
            return qe.getInfo().contains(query);
        }
        else
        {
            return false;
        }
    }
}
