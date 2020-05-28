package CardGames.Poker;

import CardGames.Card;

import java.util.ArrayList;

public class PokerPlayer {

    private String name;
    private int chipCount;
    private ArrayList <Card> hand = new ArrayList<Card>();
    private int playerBet;
    private  String playerAction;

    public PokerPlayer(String name, int chipCount){
         this.name = name;
         this.chipCount = chipCount;
    }

    public int check() {
        setPlayerAction("Check");
        return playerBet;
    }

    public int fold() {
        hand.clear();
        playerBet = 0;
        setPlayerAction("Fold");
        return playerBet;
    }

    public int call(int currentBet) {
        chipCount -= currentBet;
        playerBet = currentBet;
        setPlayerAction("Call");
        return playerBet;
    }
    
    public int bet(int bet) {
        chipCount -= bet;
        playerBet = bet;
        setPlayerAction("Bet");
        return playerBet;
    }

    public int raise(int tableBet, int raise) {
        int betDifference = tableBet - playerBet;
        chipCount -= betDifference + raise;
        playerBet = tableBet + raise;
        setPlayerAction("Raise");
        return playerBet;
    }

    public ArrayList getHandAsString() {
        ArrayList stringHand = new ArrayList();
        if (hand.size() == 2) {
            stringHand.add(hand.get(0).getRank() + hand.get(0).getSuit());
            stringHand.add(hand.get(1).getRank() + hand.get(1).getSuit());
        }
        return stringHand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }

    public ArrayList getHand() {
        return hand;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public String getPlayerAction() {
        return playerAction;
    }

    public void setPlayerAction(String playerAction) {
        this.playerAction = playerAction;
    }
}
