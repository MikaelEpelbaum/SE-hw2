package part1;

import java.util.ArrayList;
import java.util.Random;

/**
 * MarkovModel class Generates a predictable text using Markov principle with a configurable length condition.
 */

public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int N;

    /**
     * class ctor sets the seed value to myRandom attribute
     * @param n configurable length condition
     */
    public MarkovModel(int n) {
        myRandom = new Random(25);
        this.N = n;
    }

    /**
     * sets the s param to myText class attribute.
     * @param s the string to set
     */
    public void setTraining(String s){
        myText = s.trim();
    }

    /**
     * runMarkovModel Generates a random text using markov principle, with a condition length
     * of configurable length condition (N attribute).
     * @param numChars length of the predictable word generated.
     * @return Predicted generated text (String).
     */

    public String runMarkovModel (int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - N);
        sb.append(myText, index, index + this.N);

        ArrayList<String> followers = getFollows(sb.toString());
        for (int k = this.N; k < numChars; k++) {
            if (followers.size() == 0)
                continue;
            index = myRandom.nextInt(followers.size());
            sb.append(followers.get(index));
            followers = getFollows(sb.toString().substring(k -(this.N)+1, k + 1));
        }
        return sb.toString();
    }

    /**
     * getFollows returns an ArrayList of Strings (chars), which follow the key argument in myText attribute.
     * @param key char to seek for in myText attribute.
     * @return ArrayList of Strings containing researched values
     */
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> followers = new ArrayList<String>();
        String temp = myText;
        while (temp.contains(key))
        {
            int index = temp.indexOf(key) + N;
            if (index >= temp.length())
                break;
            else {
                followers.add(Character.toString(temp.charAt(index)));
                temp = temp.substring(index);
            }
        }
        return followers;
    }
}
