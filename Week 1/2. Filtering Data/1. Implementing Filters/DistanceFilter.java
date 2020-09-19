public class DistanceFilter implements Filter
{
    private Location myLocation = null;
    private double distMax;

    public DistanceFilter(Location location, double max)
    {
        myLocation = location;
        distMax = max;
    }

    public boolean satisfies(QuakeEntry qe)
    {
        return ( qe.getLocation().distanceTo(myLocation) < distMax);
    }

}
