package BlackJack;

import java.util.ArrayList;
import java.util.Stack;
import java.security.SecureRandom;

import BlackJack.Players.*;
import BlackJack.Cards.*;

public class BlackJack {

    Console console = new Console();

    public static AIDB AIDB;
    public static User user;
    public static Dealer dealer = new Dealer();
    public static Deck deck = new Deck();
    public static Stack<Card> stack = new Stack<>();

    public static void main(String[] args) {
        BlackJack program = new BlackJack();
        program.run();
    }

    public void run() {
        // Constructing User and input name :
        System.out.print("What is your name ? :");
        user = new User(console.getString());
        setAI(); // Set AI

        shuffle(); // Insert cards in the stack

        drawSeen(); // Draw Seen

        // Draw Blind
        do {
            drawBlind();
        } while (isDrawing());

        // TODO Close Accounts

        // TODO Comparing points
    }

    public void shuffle() {
        SecureRandom srd =new SecureRandom();
        ArrayList<Card> fourDeck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (Card card : deck.getDeck()) {
                fourDeck.add(card);
            }
        }

        for (int i = 0; i < fourDeck.size(); i++) {
            int another = Math.abs(srd.nextInt() % 52);
            Card temp = fourDeck.get(i);
            fourDeck.set(i, fourDeck.get(another));
            fourDeck.set(another, temp);
        }

        stack.addAll(fourDeck);
        AIDB.shuffle();
    }

    public void setAI() {
        System.out.println("How many AI do you want ? (0~5): ");
        while (true) {
            int num = console.getInt();
            if (num < 0 || num > 5) {
                System.out.println("Please enter correctly");
                continue;
            } else {
                AIDB = new AIDB(num);
                return;
            }
        }
    }

    public void drawSeen() {
        user.addSeen(stack.pop());
        for (AI ai : AIDB.getAIList()) {
            ai.addSeen(stack.pop());
        }
        dealer.addSeen(stack.pop());

    }

    public void drawBlind() {
        user.addBlind();
        for (AI ai : AIDB.getAIList()) {
            ai.addBlind(stack.pop());
        }
        dealer.addBlind();
    }

    public boolean isDrawing() {
        if (user.isToDraw())
            return true;
        for (AI ai : AIDB.getAIList()) {
            if (ai.isToDraw()) {
                return true;
            }
        }
        return false;
    }
}
