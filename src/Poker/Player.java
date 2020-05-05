package Poker;

import java.util.ArrayList;

public class Player {

    String name;
    int chipCount;
//    Card[] hand;
    ArrayList hand = new ArrayList<Card>();
    int bet;

    public Player(String name, int chipCount){
         this.name = name;
         this.chipCount = chipCount;
    }

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

    public ArrayList<Card> getHand() {
        return hand;
    }


}
