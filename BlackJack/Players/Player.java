package BlackJack.Players;

import java.util.ArrayList;
import BlackJack.BlackJack;
import BlackJack.Cards.Card;

public class Player {
    private int turn = 1;
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

    public void addBlind() {
        if(turn != 1)
            toDraw();
        if(toDraw == false)
            return;
            
        Card card = BlackJack.stack.pop();
        point += card.getValue();
        BlackJack.AIDB.addBlind(card.getValue());
        blind.add(card);
        System.out.println(name +" draw a card");
        turn++;
    }
    
    public ArrayList<Card> getBlind() {
        return blind;
    }

    public int getPoint() {
        return point;
    }

    public void cleanHand() {
        turn = 0;
        blind.clear();
    }

    public void setToDraw(boolean toDraw) {
        this.toDraw = toDraw;
    }

    public void toDraw() {
        
    }

}
