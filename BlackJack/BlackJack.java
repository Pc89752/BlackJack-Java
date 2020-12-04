package BlackJack;

import java.util.ArrayList;
import java.util.Stack;
import java.security.SecureRandom;

import BlackJack.Players.*;
import BlackJack.Cards.*;

public class BlackJack {
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
        user = new User(Console.getString());
        setAI(); // Set AI

        do {
            System.out.println();

            placeBet();

            if (stack.size() < 52) {
                shuffle(); // Insert cards in the stack
            }

            start();

            // Draw seen , Dealer draw a blind at second time
            drawSeen();

            // Draw Blind
            do {
                drawBlind();
            } while (isDrawing());

            // Settle
            settle();

            kickOut();

        } while (toContinue());
    }

/****************************************************************** */
/****************************************************************** */

    public void kickOut() {
        user.kickOut();
        AIDB.kickOut();
    }

    public void placeBet() {
        user.addChip();
        AIDB.getAIList().forEach(e -> e.addChip());
    }

    public void start() {
        user.start();
        for (AI AI : AIDB.getAIList()) {
            AI.start();
        }
        dealer.start();
    }

    public boolean toContinue() {
        System.out.print("Continue to play ? (Y/N): ");
        return Console.getYorN();
    }

    public void settle() {
        int DPoint = dealer.getPoint();
        System.out.println("Dealer has " + DPoint);
        dealer.cleanHand();
        user.settle(DPoint);
        for (AI ai : AIDB.getAIList()) {
            ai.settle(DPoint);
        }
    }

    public void shuffle() {
        SecureRandom srd = new SecureRandom();
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
            int num = Console.getInt();
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

        // Dealer addBlind at second time
        user.addSeen(stack.pop());
        for (AI ai : AIDB.getAIList()) {
            ai.addSeen(stack.pop());
        }
        dealer.addBlind();
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
