package BlackJack;

import java.util.Stack;

import BlackJack.Players.*;
import BlackJack.Cards.*;

public class BlackJack {
    Console console = new Console();

    public static AIDB AIDB;
    public static Player player;
    public static Dealer dealer;
    public static Deck deck;
    public static Stack<Card> stack = new Stack<>();

    public static void main(String[] args) {
        BlackJack program = new BlackJack();
        program.run();
    }

    public void run() {
        //1.1> Constructing players and input name :

        System.out.print("What is your name ? :");
        player = new Player(console.getString());

        shuffle();  //Inser cards in the stack

        
    }

    public void shuffle() {
        for (int i = 0; i < 4; i++) {
            for (Card card : deck.getDeck()) {
                stack.add(card);
            }
        }
        AIDB.shuffle();
    }

}
