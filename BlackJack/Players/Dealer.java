package BlackJack.Players;

public class Dealer extends Player{

    public Dealer() {
        super("Dealer");
    }

    @Override
    public void toDraw() {
        super.setToDraw(false);
    }
    
}
