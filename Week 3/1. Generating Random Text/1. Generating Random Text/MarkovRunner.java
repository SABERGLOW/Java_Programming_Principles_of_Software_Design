import edu.duke.*;

public class MarkovRunner
{
    public void runMarkovZero()
	{
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');

		MarkovZero markov = new MarkovZero();
		markov.setRandom(88);
		markov.setTraining(st);

		for(int k=0; k < 3; k++)
		{
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkovOne()
	{
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');

		MarkovOne markov = new MarkovOne();
		markov.setRandom(273);
		markov.setTraining(st);
		for(int k=0; k < 3; k++)
		{
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkovFour()
	{
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');

		MarkovFour markov = new MarkovFour();
		markov.setRandom(371);
		markov.setTraining(st);
		for(int k=0; k < 3; k++)
		{
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkovModel()
	{
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');

		MarkovModel markov = new MarkovModel(8);
		markov.setRandom(365);
		markov.setTraining(st);
		for(int k=0; k < 3; k++)
		{
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	private void printOut(String s)
	{
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++)
		{
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60)
			{
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}


	public static void main(String []args)
	{
		MarkovRunner MR = new MarkovRunner();
		//MR.runMarkovZero();
		//MR.runMarkovOne();
		//MR.runMarkovFour();
		MR.runMarkovModel();
	}
	
}
