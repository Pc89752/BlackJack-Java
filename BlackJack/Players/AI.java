package BlackJack.Players;

import java.security.SecureRandom;

import BlackJack.BlackJack;
import BlackJack.Cards.Card;

public class AI extends Player{
    private int bPoint=0;
    private AIDB aidb = BlackJack.AIDB;
    SecureRandom srd = new SecureRandom();

    public AI(String name) {
        super(name);
    }

    public void toDraw() {
        double psbNum = ((double)aidb.getLeft() +bPoint)/52;
        double will = srd.nextDouble()%3;
        //To confirm whether will be busted
        boolean toDraw = (psbNum +will) +getPoint() < 21;
        super.toDraw(toDraw);
    }

    public void addBlind(Card card) {
        super.addBlind(card);
        this.bPoint += bPoint;
    }

    public void clearHand() {
        super.cleanHand();
        bPoint = 0;
    }
    
}
