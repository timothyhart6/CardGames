package CardGames.Poker;

import CardGames.Card;
import CardGames.CardGame;

import java.util.ArrayList;

public class PokerGame extends CardGame {

    ArrayList<PokerPlayer> pokerPlayers;
    ArrayList<Card> communityCards;
    int pot;
    private int tableBet;          //Need to refactor name to convey the current maximum player bet at the table
    private int checkCounter;     //checkCounter may not be needed anymore

    public PokerGame(ArrayList<PokerPlayer> pokerPlayers) {
        super();
        this.pokerPlayers = pokerPlayers;
        this.communityCards = new ArrayList<Card>();
    }

    public void setCardValues() {
        for (int c = 0; c < deck.count(); c++) {
            Card card = (Card) deck.getDeck().get(c);
            String rank = card.getRank();
            int value = 0;
            switch (rank) {
                case "2":
                    value = 2;
                    break;
                case "3":
                    value = 3;
                    break;
                case "4":
                    value = 4;
                    break;
                case "5":
                    value = 5;
                    break;
                case "6":
                    value = 6;
                    break;
                case "7":
                    value = 7;
                    break;
                case "8":
                    value = 8;
                    break;
                case "9":
                    value = 9;
                    break;
                case "10":
                    value = 10;
                    break;
                case "J":
                    value = 11;
                    break;
                case "Q":
                    value = 12;
                    break;
                case "K":
                    value = 13;
                    break;
                case "A":
                    value = 14;
                    break;
            }
            card.setValue(value);
        }
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
        int p = 0;
        int c = 0;
        while (c < 2) {
            pokerPlayers.get(p).setHand(deck.dealTopCard());
            p ++;
            if (p == pokerPlayers.size()) {
                c++;
                p = 0;
            }
        }
    }

    public void burnCard() {
        deck.discardTopCard();
    }

    public void dealFlop() {
        communityCards.add(deck.dealTopCard());
        communityCards.add(deck.dealTopCard());
        communityCards.add(deck.dealTopCard());
    }

    public void dealTurn() {
        communityCards.add(deck.dealTopCard());
    }

    public void dealRiver() {

        communityCards.add(deck.dealTopCard());
    }

    public ArrayList<String> displayCommunityCards() {
        ArrayList<String> communityCardsAsStrings = new ArrayList<String>();
        for (int i = 0; i < communityCards.size(); i++) {
            communityCardsAsStrings.add(communityCards.get(i).getRank() + communityCards.get(i).getSuit());
        }
        return communityCardsAsStrings;
    }

    public ArrayList<Card> getCommunityCards() {
        return communityCards;
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
}

