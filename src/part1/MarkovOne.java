package part1;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovFour class Generates a predictable text using Markov principle with a length condition on one.
 */
public class MarkovOne {
    private String myText;
    private Random myRandom;

    /** class ctor sets the seed value to myRandom attribute */
    public MarkovOne() {
        myRandom = new Random(25);
    }

    /**
     * sets the s param to myText class attribute.
     * @param s the string to set
     */
    public void setTraining(String s){
        myText = s.trim();
    }

    /**
     * getRandomText Generates a random text using markov principle, with a condition length
     * of one.
     * @param numChars length of the predictable word generated.
     * @return Predicted generated text (String).
     */
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        sb.append(myText.charAt(index));
        ArrayList<String> followers = getFollows(sb.charAt(0));
        for(int k=0; k < numChars-1; k++){
            if (followers.size() == 0)
                continue;
            index = myRandom.nextInt(followers.size());
            sb.append(followers.get(index));
            followers = getFollows(sb.charAt(k+1));
        }
        return sb.toString();
    }

    /**
     * getFollows returns an ArrayList of Strings (chars), which follow the key argument in myText attribute.
     * @param key char to seek for in myText attribute.
     * @return ArrayList of Strings containing researched values
     */
    public ArrayList<String> getFollows(char key) {
        ArrayList<String> followers = new ArrayList<String>();
        String temp = myText;
        while (temp.indexOf(key)>= 0)
        {
            int index = temp.indexOf(key);
            int num = index + 1;
            if (num >= temp.length())
                break;
            if (num < temp.length()) {
                followers.add(Character.toString(temp.charAt(num)));
                temp = temp.substring(num);
            }
        }
        return followers;
    }
}

