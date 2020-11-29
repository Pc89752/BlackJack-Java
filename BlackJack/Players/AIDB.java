package BlackJack.Players;

import java.util.ArrayList;

public class AIDB {
    private int blind=0;
    private int left = 340;
    private ArrayList<AI> AIList = new ArrayList<AI>();
    private String[] AINames = {"John", "Jack", "Jane", "Jenny", "Jade"};

    public AIDB(int num) {
        for (int i = 0; i < num; i++) {
            addAI(new AI(AINames[i]));
        }
    }

    public void addBlind(int blind) {
        this.blind += blind;
    }

    public void addAI(AI AI) {
        AIList.add(AI);
    }

    public ArrayList<AI> getAIList() {
        return AIList;
    }

    public int getLeft() {
        return left;
    }

    public void clear() {
        left -= blind;
        for (AI ai : AIList) {
            ai.cleanHand();
        }
    }

    public void shuffle() {
        left = 340;
    }
}
