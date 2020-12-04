package BlackJack.Players;


import java.util.ArrayList;

import BlackJack.Console;
import BlackJack.Cards.Card;

public class User extends Player{

    public User(String name) {
        super(name);
    }

    public void addChip() {
        int chip;
        do {
            System.out.println("Your fund : " +getFund());
            System.out.print("How much do you want to bet ? : ");
            chip = Console.getInt();
            if(chip > getFund()){
                System.out.println("Please enter correctly");
                continue;
            }else{
                break;
            }
        } while (true);
        addChip(chip);
    }
    
    @Override
    public void toDraw() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.addAll(getSeen());
        hand.addAll(getBlind());
        System.out.println("\nYour card : " +hand);
        System.out.print("Continue to draw ? (y/n): ");
        setToDraw(Console.getYorN());
    }

    @Override
    public void kickOut() {
        if(getFund() > 0)
            return;
            
        super.kickOut();
        System.exit(0);
    }
}
