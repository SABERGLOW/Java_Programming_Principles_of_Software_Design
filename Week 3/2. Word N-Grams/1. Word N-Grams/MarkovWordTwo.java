import java.util.*;

public class MarkovWordTwo implements IMarkovModel
{
    private String[] myText;
    private Random myRandom;

    public MarkovWordTwo()
    {
        myRandom = new Random();
    }

    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }

    public void setTraining(String text)
    {
        myText = text.split("\\s+");
    }

    public String toString()
    {
        return "MarkovWordOne of order 2";
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        sb.append(key1 + " " + key2 + " ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }

        return sb.toString().trim();
    }

    private ArrayList<String> getFollows(String key1, String key2)
    {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length)
        {
            int start = indexOf(myText, key1, key2, pos);
            if (start == -1)
            {
                break;
            }
            if (start + 2 >= myText.length)
            {
                break;
            }
            follows.add(myText[start+2]);
            pos = start+2;
        }
        return follows;
    }

    private int indexOf (String[] words, String target1, String target2, int start)
    {
        for (int k = start; k < words.length-1; k++)
        {
            if (words[k].equals(target1) && words[k+1].equals(target2))
            {
                return k;
            }
        }
        return -1;
    }

    public void testIndexOf()
    {
        String[] words = "this is just a test yes this is a simple test".split("\\s+");
        System.out.println("should be 0: "+indexOf(words, "this", "is", 0));
        System.out.println("should be 6: "+indexOf(words, "this", "is", 1));
        System.out.println("should be -1: "+indexOf(words, "frog", "juicer", 0));
        System.out.println("should be -1: "+indexOf(words, "frog", "juicer", 5));
        System.out.println("should be 9: "+indexOf(words, "simple", "test", 2));
        System.out.println("should be -1: "+indexOf(words, "simple", "trial", 5));
        System.out.println("should be -1: "+indexOf(words, "trial", "test", 0));
    }

}

