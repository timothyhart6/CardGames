package CardGames.Poker;

import CardGames.Card;

import java.util.ArrayList;

public class Player {

    String name;
    int chipCount;
    ArrayList <Card> hand = new ArrayList<Card>();
    int playerBet;

    public Player(String name, int chipCount){
         this.name = name;
         this.chipCount = chipCount;
    }

    public int check() {
        return playerBet;
    }

    public int fold() {
        hand.clear();
        playerBet = 0;
        return playerBet;
    }

    public int call(int currentBet) {
        chipCount -= currentBet;
        playerBet = currentBet;
        return playerBet;
    }
    
    public int bet(int bet) {
        chipCount -= bet;
        playerBet = bet;
        return playerBet;
    }

    public int raise(int tableBet, int raise) {
        int betDifference = tableBet - playerBet;
        chipCount -= betDifference + raise;
        playerBet = tableBet + raise;
        return playerBet;
    }

    public String getName() {
        return name;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public ArrayList getHandAsString() {
        ArrayList stringHand = new ArrayList();
        if (hand.size() == 2) {
            stringHand.add(hand.get(0).getRank() + hand.get(0).getSuit());
            stringHand.add(hand.get(1).getRank() + hand.get(1).getSuit());
        }
        return stringHand;
    }

    public ArrayList getHand() {
        return hand;
    }


    public int getPlayerBet() {
        return playerBet;
    }
}
