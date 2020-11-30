package BlackJack.Players;

import BlackJack.Console;

public class User extends Player{
    Console cs = new Console();

    public User(String name) {
        super(name);
    }
    
    @Override
    public void toDraw() {
        System.out.print("Continue to draw ? (y/n): ");
        super.setToDraw(cs.getYorN());
    }
}
