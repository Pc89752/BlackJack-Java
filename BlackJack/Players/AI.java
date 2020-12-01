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

    @Override
    public void toDraw() {
        double psbNum = ((double)BlackJack.AIDB.getLeft() +bPoint)/52;
        double will = srd.nextDouble()%3;
        //To confirm whether will be busted
        boolean toDraw = (psbNum +will) +getPoint() < 21;
        super.setToDraw(toDraw);
    }

    public void addBlind(Card card) {
        super.addBlind();
        this.bPoint += bPoint;
    }

    public void clearHand() {
        super.cleanHand();
        bPoint = 0;
    }
    
}
