package Poker;

public  class Poker {
    int numberOfPlayers;
    Player humanPlayer;;
    public DeckOfCards deck = new DeckOfCards();

    public Poker(Player player, int numberOfPlayers) {
        this.humanPlayer = player;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void testMethod() {
        System.out.println("test method");
    }


    public void dealHoleCards() {
        Card[] holeCards = {deck.dealOneCard(), deck.dealOneCard()};
        humanPlayer.setHand(holeCards);
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
