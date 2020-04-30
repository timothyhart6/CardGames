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
        Card card1 = deck.dealOneCard();
        Card card2 = deck.dealOneCard();
        Card[] holeCards = {card1, card2};
        humanPlayer.setHand(holeCards);
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
