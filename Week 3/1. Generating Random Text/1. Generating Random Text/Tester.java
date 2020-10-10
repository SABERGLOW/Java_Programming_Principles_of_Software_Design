import edu.duke.*;
import java.util.*;

public class Tester
{
    public void testGetFollows ()
    {
        MarkovOne markov = new MarkovOne ();
        markov.setTraining("this is a test yes this is a test.");

        String key = "e";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println("Letters that follow \"" + key + "\": " + follows);
        System.out.println("There are " + follows.size() + " letters that follow \"" + key + "\"");
    }

    public void testGetFollowsWithFile ()
    {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');

        MarkovOne markov = new MarkovOne ();
        markov.setTraining(st);

        String key = "th";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println("Letters that follow \"" + key + "\": " + follows);
        System.out.println("There are " + follows.size() + " letters that follow \"" + key + "\"");
    }

    public static void main(String []args)
    {
        Tester MRTester = new Tester();
        MRTester.testGetFollowsWithFile();
    }
}