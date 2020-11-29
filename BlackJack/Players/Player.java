package BlackJack.Players;

import java.util.ArrayList;

import BlackJack.Cards.Card;

public class Player {
    private Card seen;
    private ArrayList<Card> blind = new ArrayList<>();
    private int point = 0;
    private String name;
    private boolean toDraw = true;

    public Player (String name){
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void addSeen(Card card) {
        System.out.println(name +" draw " +card);
        point += card.getValue();
        seen = card;
    }

    public Card getSeen() {
        return seen;
    }

    public void addBlind(Card card) {
        point += card.getValue();
        BlackJack.BlackJack.AIDB.addBlind(card.getValue());
        if(toDraw == true)
            blind.add(card);
    }
    
    public ArrayList<Card> getBlind() {
        return blind;
    }

    public int getPoint() {
        return point;
    }

    public void cleanHand() {
        blind.clear();
    }

    public void toDraw(boolean toDraw) {
        this.toDraw = toDraw;
    }
}
