import java.util.ArrayList;
import java.util.Random;

public class MarkovFour
{
    private int markovOrder = 4;
    private String myText;
    private Random myRandom;

    public MarkovFour ()
    {
        myRandom = new Random();
        myText = "";
    }

    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }

    public void setTraining(String s)
    {
        if (s != null && ! s.isEmpty()) myText = s.trim();
    }

    public String getRandomText(int numChars)
    {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-markovOrder);

        String key = myText.substring(index, index+markovOrder);
        sb.append(key);


        for(int k=0; k < numChars-markovOrder; k++)
        {
            ArrayList<String> follows = getFollows(key);
            //System.out.println("key '"+key+ "' " + follows);
            if (follows.size() == 0)
            {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(next.length())+next;
        }

        return sb.toString();
    }

    private ArrayList<String> getFollows(String key)
    {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length())
        {
            int start = myText.indexOf(key, pos);
            if (start == -1)
            {
                break;
            }
            if (start + key.length()+1 > myText.length())
            {
                break;
            }
            String next = myText.substring(start+key.length(), start+key.length()+1);
            follows.add(next);
            pos = start+key.length();
        }

        return follows;
    }
}