package Poker;

import java.util.ArrayList;

public  class Poker {
    int numberOfPlayers;
    Player humanPlayer;;
    public DeckOfCards deck = new DeckOfCards();
    Card[] flop;
    Card turn;
    Card river;
    int pot;
    private int tableBet;
    private int checkCounter;

    public Poker(Player player, int numberOfPlayers) {
        this.humanPlayer = player;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void incrementCheckCounter() {
        checkCounter += 1;
    }

    public void playerAction(int betAmount) {
        if (tableBet < betAmount) {
            setTableBet(betAmount);
        }
    }

    public void dealHoleCards() {
        ArrayList holeCards= new ArrayList<Card>();
        holeCards.add(deck.dealTopCard());
        holeCards.add(deck.dealTopCard());
        humanPlayer.setHand(holeCards);
    }

    public void burnCard() {
        deck.discardTopCard();
    }

    public void dealFlop() {
        Card[] flopCards = {deck.dealTopCard(), deck.dealTopCard(), deck.dealTopCard()};
        flop = flopCards;
    }

    public void dealTurn() {
        Card turnCard = deck.dealTopCard();
        turn = turnCard;
    }

    public void dealRiver() {
        Card riverCard = deck.dealTopCard();
        river = riverCard;
    }

    public ArrayList getFlopAsString() {
        ArrayList stringFlop = new ArrayList();

        stringFlop.add(flop[0].rank + flop[0].suit);
        stringFlop.add(flop[1].rank + flop[1].suit);
        stringFlop.add(flop[2].rank + flop[2].suit);

        return stringFlop;
    }

    public String getTurnAsString() {
        String stringTurn = turn.rank + turn.suit;
        return stringTurn;
    }

    public String getRiverAsString() {
        String stringRiver = river.rank + river.suit;
        return stringRiver;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getTableBet() {
        return tableBet;
    }

    public void setTableBet(int tableBet) {
        this.tableBet = tableBet;
    }

    public int getCheckCounter() {
        return checkCounter;
    }

    public void setCheckCounter(int checkCounter) {
        this.checkCounter = checkCounter;
    }

    public Card[] getFlop() {
        return flop;
    }

    public Card getTurn() {
        return turn;
    }

    public Card getRiver() {
        return river;
    }
}
