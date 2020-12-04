package BlackJack.Players;

import java.util.ArrayList;

import BlackJack.BlackJack;
import BlackJack.Cards.Card;

public class Player {
    // private int turn = 1;
    private ArrayList<Card> seen = new ArrayList<>();
    private ArrayList<Card> blind = new ArrayList<>();
    private int points = 0;
    private String name;
    private boolean toDraw = true;
    private int fund = 1000;
    private int chip = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public int getFund() {
        return fund;
    }

    public void addFund(int fund) {
        this.fund += fund;
    }

    public int getChip() {
        return chip;
    }

    public void addChip(int chip) {
        System.out.println(name +" place a bet of $" +chip);
        this.fund -= chip;
        this.chip += chip;
    }

    public void addSeen(Card card) {
        System.out.println(name + " draw " + card);
        // When draw ACE , point could be 11
        if (card.getRank().toString().equals("ACE") && points + 11 <= 21) {
            points += 11;
        } else
            points += card.getValue();
        seen.add(card);
    }

    public ArrayList<Card> getSeen() {
        return seen;
    }

    public void addBlind() {
        if (toDraw)
            toDraw();
        if (!toDraw)
            return;

        Card card = BlackJack.stack.pop();
        // When draw ACE , point could be 11 if not over 21 after the adding
        if (card.getRank().toString().equals("ACE") && points + 11 <= 21) {
            points += 11;
        } else
            points += card.getValue();
        blind.add(card);
        System.out.println("\n" +name + " draw a card");
        // turn++;
        bust();
    }

    public ArrayList<Card> getBlind() {
        return blind;
    }

    public int getPoint() {
        return points;
    }

    public void cleanHand() {
        // turn = 0;
        if (points == 0)
            return;
        ArrayList<Card> handCards = new ArrayList<>();
        handCards.addAll(seen);
        handCards.addAll(blind);
        System.out.println(name + " hand cards are " + handCards);
        seen.forEach(e -> points -= e.getValue());
        BlackJack.AIDB.minusLeft(points);
        points = 0;
        seen.clear();
        blind.clear();
    }

    public void setToDraw(boolean toDraw) {
        this.toDraw = toDraw;
        if (toDraw)
            return;
        System.out.println(name + " stop to draw");
    }

    public void toDraw() {

    }

    public boolean isToDraw() {
        return toDraw;
    }

    public void bust() {
        if (points > 21) {
            System.out.println(name + " busted");
            cleanHand();
            setToDraw(false);
        }
    }

    public void settle(int DPoints) {
        System.out.println(name + " has " + points);
        if (DPoints < points) {
            System.out.println(name + " won");
            this.addFund(chip *2);
        } else if (DPoints > points) {
            System.out.println(name + " lost");
        } else {
            System.out.println(name + " tied with dealer");
            this.addFund(chip);
        }

        cleanHand();
    }

    public void kickOut() {
        System.out.println(getName() +" has been kicked out od the game");
    }

    public void start() {
        setToDraw(true);
    }
}
