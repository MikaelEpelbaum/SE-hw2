package part1;

import java.util.Random;

/**
 * MarkovZero class Generates a predictable text using Markov principle without any
 * condition.
 */

public class MarkovZero {
    private String myText;
	private Random myRandom;

	/**
	 * class ctor sets the seed value to myRandom attribute
	 */
	public MarkovZero() {
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
	 * getRandomText Generates a random text using markov principle, without any condition.
	 * It is basically generating random numbers in the range of myText attribute and
	 * adding them to the returned String.
	 * @param numChars length of the predictable word generated.
	 * @return Predicted generated text (String).
	 */
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		
		return sb.toString();
	}
}