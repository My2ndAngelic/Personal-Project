package hello;

public class Card {
    private final String[] vals = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
    private int suit;
    private int val;

    Card() {

    }

    Card(int val, int suit) {
        this.suit = suit;
        this.val = val;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String toString() {
        return this.vals[this.val] + " of " + this.suits[this.suit];
    }
}
