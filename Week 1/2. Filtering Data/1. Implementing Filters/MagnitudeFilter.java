public class MagnitudeFilter implements Filter
{
    private double magMin;
    private double magMax;

    public MagnitudeFilter(double min, double max)
    {
        magMin = min;
        magMax = max;
    }

    public boolean satisfies(QuakeEntry qe)
    {
        return qe.getMagnitude() >= magMin && qe.getMagnitude() <= magMax;

        //...returns true if magnitude magnitude is
        // between the minimum and maximum magnitudes,
        // or equal to one of them...//
    }
}
