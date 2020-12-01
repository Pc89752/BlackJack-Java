package BlackJack.Players;


import java.util.ArrayList;

import BlackJack.Console;
import BlackJack.Cards.Card;

public class User extends Player{
    Console cs = new Console();

    public User(String name) {
        super(name);
    }
    
    @Override
    public void toDraw() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(getSeen());
        hand.addAll(getBlind());
        System.out.println("Your card : " +hand);
        System.out.print("Continue to draw ? (y/n): ");
        super.setToDraw(cs.getYorN());
    }
}
