package script.poker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card {
	public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
	
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    
    public enum Jocker {RED,BLACK}
    
    public static void main(String args[]) {
    	List<Integer> dice = Arrays.asList(1,2,3,4,5,6);
    	Collections.shuffle(dice);
    	System.out.println(dice);
    	
    }
}
