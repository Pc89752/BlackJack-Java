package BlackJack.Players;

import java.util.ArrayList;

public class AIDB {
    private int left = 340;
    private ArrayList<AI> AIList = new ArrayList<AI>();
    private String[] AINames = {"John", "Jack", "Jane", "Jenny", "Jade"};

    public AIDB(int num) {
        for (int i = 0; i < num; i++) {
            addAI(new AI(AINames[i]));
        }
    }

    public void addAI(AI AI) {
        AIList.add(AI);
    }

    public ArrayList<AI> getAIList() {
        return AIList;
    }

    public void kickOut() {
        for (AI ai : AIList) {
            if(ai.getFund() <= 0){
                ai.kickOut();
                AIList.remove(ai);
            }
        }
    }

    public int getLeft() {
        return left;
    }

    public void minusLeft(int point) {
        left -= point;
    }

    public void clear() {
        for (AI ai : AIList) {
            ai.cleanHand();
        }
    }

    public void shuffle() {
        left = 340;
    }
}
