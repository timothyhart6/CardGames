package Poker;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class  DeckOfCards<deck> {

    private ArrayList<String> deck = new ArrayList<String>(52);

    public DeckOfCards(){
        createDeck();
    }

    private void createDeck() {
        String[] s = {"S", "C", "D", "H"};
        String[] v = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] value = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        for (int i = 0; i < 4; i++) {
            for (int j= 0; j < 13; j++) {
                deck.add(v[j] + s[i]);
            }
        }
    }
    public int count() {
        int deckCount = deck.size();
        return deckCount;
    }

    public String findCard(String card){
        if (deck.contains(card)) {
            return card;
        }
        else return "NOPE!";
    }

    public boolean isDistinct() {
        ArrayList<String> distinct = (ArrayList) deck.stream().distinct().collect(Collectors.toList());
        return distinct.size() == deck.size();
    }

}
