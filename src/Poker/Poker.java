package Poker;

public  class Poker {
    int numberOfPlayers;
    Player humanPlayer;;
    public DeckOfCards deck = new DeckOfCards();
    Card[] flop;
    Card turn;
    Card river;

    public Poker(Player player, int numberOfPlayers) {
        this.humanPlayer = player;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void dealHoleCards() {
        Card[] holeCards = {deck.dealTopCard(), deck.dealTopCard()};
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


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
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
