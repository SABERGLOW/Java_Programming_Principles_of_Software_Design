public class PhraseFilter implements Filter
{
    private String param;
    private String query;
    private String myName;

    public PhraseFilter(String where, String searchQuery)
    {
        param = where;
        query = searchQuery;
    }

    public PhraseFilter(String name, String where, String searchQuery)
    {
        param = where;
        query = searchQuery;
        myName = name;
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

    public String getName()
    {
        return myName;
    }
}
