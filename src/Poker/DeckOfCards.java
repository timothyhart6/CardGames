package Poker;

import java.util.*;

public class  DeckOfCards {

    private ArrayList deck = new ArrayList();

    public DeckOfCards() {
        createDeck();
    }

    private void createDeck() {
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suit = {"S", "C", "D", "H"};
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < 13; r++) {
                deck.add(new Card(rank[r], suit[s]));
            }
        }
    }

    public int count() {
        int deckCount = deck.size();
        return deckCount;
    }

    public String findCard(String card) {
        String[] cardArray = card.split("");
        Card cardToObject = new Card(cardArray[0], cardArray[1]);
        if (deck.contains(cardToObject)) {
            return card;
        } else {
            return cardToObject.rank + cardToObject.suit + " is not in the deck.";
        }
    }
// ###WILL BE MOVED TO GAME CLASS###
//    public int getCardNumericalValue(Card card) {
//        int cardValue = (int) deck.get(card);
//        return cardValue;
//    }

    public List getListOfDeckSuits() {
        List<String> suits = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            Card card = (Card) deck.get(i);
            if (!suits.contains(card.suit)) {
                suits.add(card.suit);
            }
        }
        Collections.sort(suits);
        return suits;
    }

    public List getListOfDeckRanks() {
        List<String> ranks = new ArrayList<>();
        for (int i = 0; i < deck.size(); i++) {
            Card card = (Card) deck.get(i);
            if (!ranks.contains(card.rank)) {
                ranks.add(card.rank);
            }
        }
        Collections.sort(ranks);
        return ranks;
    }

    public String getListOfAllCardsInDeck() {
        String[] listOfCards = new String[deck.size()];
        for (int i = 0; i < deck.size(); i++) {
            Card card = (Card) deck.get(i);
            listOfCards[i] = card.rank + card.suit;
        }
        return Arrays.toString(listOfCards);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealOneCard() {
        Card dealtCard = (Card) deck.remove(deck.size() - 1);
        return dealtCard;
    }

    public void discard(String card) {
        String[] cardArray = card.split("");
        Card discardedCard = new Card(cardArray[0], cardArray[1]);
        deck.remove(discardedCard);
    }
}