package BlackJack.Cards;

import java.util.ArrayList;
import java.security.SecureRandom;

public class Deck {
    SecureRandom srd =new SecureRandom();
    private ArrayList<Card> deck = new ArrayList<>();

    Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        for (Card card : deck) {
            int index = Math.abs(srd.nextInt()%52);
            Card temp = card;
            card = deck.get(index);
            deck.set(index, temp);
        }
    }

    public ArrayList<Card> getDeck() {
        shuffle();
        return deck;
    }
}
