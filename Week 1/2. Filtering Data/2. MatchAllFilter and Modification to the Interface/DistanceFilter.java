public class DistanceFilter implements Filter
{
    private Location myLocation = null;
    private double distMax;
    private String myName;

    public DistanceFilter(Location location, double max)
    {
        myLocation = location;
        distMax = max;
    }

    public DistanceFilter(String name, Location location, double max)
    {
        myLocation = location;
        distMax = max;
        myName = name;
    }

    public boolean satisfies(QuakeEntry qe)
    {
        return ( qe.getLocation().distanceTo(myLocation) < distMax);
    }
    public String getName()
    {
        return myName;
    }

}
