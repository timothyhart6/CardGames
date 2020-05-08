package Poker;

import java.util.ArrayList;

public class Player {

    String name;
    int chipCount;
//    Card[] hand;
    ArrayList <Card> hand = new ArrayList<Card>();
    int bet;

    public Player(String name, int chipCount){
         this.name = name;
         this.chipCount = chipCount;
    }

//    public void playerAction(int action) {
//        switch (action) {
//            case 1:
//                fold();
//                break;
//            case 2:
//                check();
//        }
//    }

    public void check() {
    }
    
    public void bet(int bet) {
        chipCount -= bet;
    }

    public void raise(int raise) {
        bet += raise;
        chipCount -= raise;
    }

    public void fold() {
        hand.clear();
//        hand.remove(0);
//        hand.remove(0);
    }

    public String getName() {
        return name;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList getHandAsString() {
        ArrayList stringHand = new ArrayList();
        if (hand.size() == 2) {
            stringHand.add(hand.get(0).rank + hand.get(0).suit);
            stringHand.add(hand.get(1).rank + hand.get(1).suit);
        }
        return stringHand;
    }

    public ArrayList getHand() {
        return hand;
    }


}
