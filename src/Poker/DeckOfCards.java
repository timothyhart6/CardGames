package Poker;

import java.util.Hashtable;

public class  DeckOfCards<deck> {

    private Hashtable deck = new Hashtable();

    public DeckOfCards(){
        createDeck();
    }

    private void createDeck() {
        String[] s = {"S", "C", "D", "H"};
        String[] v = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (int i = 0; i < 4; i++) {
            int c = 2;
            for (int j= 0; j < 13; j++) {
                deck.put((v[j] + s[i]), c);
                c++;
            }
        }
    }
    public int count() {
        int deckCount = deck.size();
        return deckCount;
    }

    public String findCard(String card){
        if (deck.containsKey(card)) {
            return card;
        } else {
            return "NOPE!";
        }
    }

    public int cardNumericalValue(String v, String s) {
        int value = (int)deck.get(v + s);
        return value;
    }
}
