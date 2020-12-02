package BlackJack.Players;

import java.util.ArrayList;

import BlackJack.BlackJack;
import BlackJack.Cards.Card;

public class Player {
    // private int turn = 1;
    private Card seen;
    private ArrayList<Card> blind = new ArrayList<>();
    private int point = 0;
    private String name;
    private boolean toDraw = true;

    public Player(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void addSeen(Card card) {
        System.out.println(name + " draw " + card);
        //When draw ACE , point could be 11
        if(card.getRank().toString().equals("ACE") && point +11 <=21){
            point += 11;
        }else
            point += card.getValue();
        seen = card;
    }

    public Card getSeen() {
        return seen;
    }

    public void addBlind() {
        if (!toDraw)
            return;

        Card card = BlackJack.stack.pop();
        //When draw ACE , point could be 11
        if(card.getRank().toString().equals("ACE") && point +11 <=21){
            point += 11;
        }else
            point += card.getValue();
        blind.add(card);
        System.out.println(name + " draw a card");
        // turn++;
        bust();
        if (toDraw)
            toDraw();
    }

    public ArrayList<Card> getBlind() {
        return blind;
    }

    public int getPoint() {
        return point;
    }

    public void cleanHand() {
        // turn = 0;
        if(point == 0)
            return;
        ArrayList<Card> handCards = new ArrayList<>();
        handCards.add(seen);
        handCards.addAll(blind);
        System.out.println(name +" hand cards are " +handCards);

        BlackJack.AIDB.minusLeft(point -seen.getValue());
        point = 0;
        seen = null;
        blind.clear();
    }

    public void setToDraw(boolean toDraw) {
        if(toDraw)
            return;
        System.out.println(name + " stop to draw");
        this.toDraw = toDraw;
    }

    public void toDraw() {

    }

    public boolean isToDraw() {
        return toDraw;
    }

    public void bust() {
        if(point > 21){
            System.out.println(name +" busted");
            cleanHand();
            setToDraw(false);
        }
    }
}
