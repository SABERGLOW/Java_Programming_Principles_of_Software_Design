public class DepthFilter implements Filter
{
    private double depthMin;
    private double depthMax;

    public DepthFilter(double min, double max)
    {
        depthMin = min;
        depthMax = max;
    }

    public boolean satisfies(QuakeEntry qe)
    {
        return ((qe.getDepth() >= depthMin) && (qe.getDepth() <= depthMax));

        //...returns true if depth is
        // between minimum & maximum depths,
        // or equal to one of them...//
    }
}
