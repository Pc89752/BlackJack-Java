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
        //Constructing User and input name :

        System.out.print("What is your name ? :");
        player = new Player(console.getString());

        shuffle();  //Insert cards in the stack

        //TODO Set AI

        //TODO Draw Seen

        //TODO Draw Blind

        //TODO Comparing points
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
