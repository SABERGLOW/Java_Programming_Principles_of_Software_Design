import java.util.*;

public class MarkovWordOne implements IMarkovModel
{
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne()
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
		return "MarkovWordOne";
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}
	
	private ArrayList<String> getFollows(String key)
	{
	    ArrayList<String> follows = new ArrayList<String>();
	    int pos = 0;
		while (pos < myText.length)
		{
			int start = indexOf(myText, key, pos);
			if (start == -1)
			{
				break;
			}
			if (start + 1 >= myText.length)
			{
				break;
			}
			follows.add(myText[start+1]);
			pos = start+1;
		}
	    return follows;
    }

	private int indexOf (String[] words, String target, int start)
	{
		for (int k = start; k < words.length; k++)
		{
			if (words[k].equals(target))
			{
				return k;
			}
		}
		return -1;
	}

	public void testIndexOf()
	{
		String[] words = "this is just a test yes this is a simple test".split("\\s+");
		System.out.println("should be 0: "+indexOf(words, "this", 0));
		System.out.println("should be 6: "+indexOf(words, "this", 3));
		System.out.println("should be -1: "+indexOf(words, "frog", 0));
		System.out.println("should be -1: "+indexOf(words, "frog", 5));
		System.out.println("should be 9: "+indexOf(words, "simple", 2));
		System.out.println("should be 10: "+indexOf(words, "test", 5));
	}

}
