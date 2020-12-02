package BlackJack.Cards;

import java.util.ArrayList;
import java.security.SecureRandom;

public class Deck {
    SecureRandom srd = new SecureRandom();
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < deck.size(); i++) {
            int another = Math.abs(srd.nextInt() % 52);
            Card temp = deck.get(i);
            deck.set(i, deck.get(another));
            deck.set(another, temp);
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
