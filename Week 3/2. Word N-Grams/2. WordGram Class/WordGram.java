
public class WordGram
{
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size)
    {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length()
    {
        return myWords.length;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (String word : myWords)
            sb.append(word).append(" ");
        // remember to remove the trailing space.
        return sb.toString().trim();
    }

    public boolean equals(Object o)
    {
        WordGram other = (WordGram) o;
        if (myWords.length != other.length())
        {
            return false;
        }
        for (int k = 0; k < myWords.length; k++)
        {
            if (!myWords[k].equals(other.myWords[k]))
            {
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word)
    {
        WordGram out = new WordGram(myWords, 0, myWords.length);
        if (word == null)
        {
            word = "";
        }

        System.arraycopy(out.myWords, 1, out.myWords, 0, out.myWords.length-1);
        out.myWords[out.myWords.length-1] = word;
        out.myHash = out.toString().hashCode();
        return out;
    }

}