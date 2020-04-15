package Poker;

//import java.util.Hashtable;
import java.util.Hashtable;

public class  DeckOfCards {

    private Hashtable deck = new Hashtable();

    public DeckOfCards(){
        createDeck();
    }

    private void createDeck() {
        String[] s = {"S", "C", "D", "H"};
        String[] v = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < 4; i++) {
            int c = 2;
            for (int j= 0; j < 13; j++) {
                deck.put((new Card(v[j], s[i])), c);
                c++;
            }
        }
    }
    public int count() {
        int deckCount = deck.size();
        return deckCount;
    }

    public String findCard(String card){
        String[] cardArray = card.split("");
        Card cardToObject = new Card(cardArray[0], cardArray[1]);
        if (deck.containsKey(cardToObject)) {
            return card;
        } else {
            return "NOPE!";
        }
    }

    public int getCardNumericalValue(Card card) {
        int cardValue = (int) deck.get(card);
        return cardValue;
    }

}
