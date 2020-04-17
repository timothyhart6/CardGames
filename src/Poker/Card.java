package Poker;

import java.util.Objects;

public class Card {
    String faceValue;
    String suit;

    public Card(String faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public boolean equals(Object object) {
        Card card = (Card) object;
        return faceValue.equals(card.faceValue) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceValue, suit);
    }

    public String getFaceValue() {
        return faceValue;
    }

    public String getSuit() {
        return suit;
    }
}
