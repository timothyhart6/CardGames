package Poker;

public class Player {

    String name;
    int chipCount;
    Card[] hand;

    public Player(String name, int chipCount){
         this.name = name;
         this.chipCount = chipCount;

    }


    public String getName() {
        return name;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public Card[] getHand() {
        return hand;
    }
}
