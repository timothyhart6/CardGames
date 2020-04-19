package Poker;

import java.util.Objects;

public class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public boolean equals(Object object) {
        Card card = (Card) object;
        return rank.equals(card.rank) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
