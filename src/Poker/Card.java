package Poker;

public class Card {
    String faceValue;
    String suit;
//    int numericalValue;


    public Card(String faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
