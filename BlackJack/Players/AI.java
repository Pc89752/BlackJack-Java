package BlackJack.Players;

import java.security.SecureRandom;

import BlackJack.BlackJack;
import BlackJack.Cards.Card;

public class AI extends Player{
    private int bPoint=0;
    SecureRandom srd = new SecureRandom();

    public AI(String name) {
        super(name);
    }

    public void addChip() {
        int chip = (int)Math.abs(srd.nextInt()%getFund() +1);
        addChip(chip);
    }

    @Override
    public void toDraw() {
        double psbNum = ((double)BlackJack.AIDB.getLeft() +bPoint)/52;
        double will = srd.nextDouble()%3;
        //To confirm whether will be busted
        boolean toDraw = (psbNum +will) +getPoint() < 21;
        setToDraw(toDraw);
    }

    public void addBlind(Card card) {
        addBlind();
        this.bPoint += bPoint;
    }

    public void clearHand() {
        cleanHand();
        bPoint = 0;
    }
    
}
