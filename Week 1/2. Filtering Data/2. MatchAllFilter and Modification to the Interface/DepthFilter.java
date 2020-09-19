public class DepthFilter implements Filter
{
    private double depthMin;
    private double depthMax;
    private String myName;

    public DepthFilter(double min, double max)
    {
        depthMin = min;
        depthMax = max;
    }
    public DepthFilter(String name, double min, double max)
    {
        depthMin = min;
        depthMax = max;
        myName = name;
    }

    public boolean satisfies(QuakeEntry qe)
    {
        return ((qe.getDepth() >= depthMin) && (qe.getDepth() <= depthMax));

        //...returns true if depth is
        // between minimum & maximum depths,
        // or equal to one of them...//
    }

    public String getName()
    {
        return myName;
    }
}
