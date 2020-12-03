package BlackJack.Players;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    @Override
    public void toDraw() {
        if (this.getPoint() >= 17)
            setToDraw(false);
    }

}
