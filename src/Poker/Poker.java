package Poker;

public  class Poker {
    int numberOfPlayers;
    Player humanPlayer;;
    public DeckOfCards deck = new DeckOfCards();
    Card[] flop;

    public Poker(Player player, int numberOfPlayers) {
        this.humanPlayer = player;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void testMethod() {
        System.out.println("test method");
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


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Card[] getFlop() {
        return flop;
    }

}
