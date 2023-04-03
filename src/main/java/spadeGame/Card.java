package spadeGame;

public class Card {
    private int value;
    private CardSuit suit;

    /**
     * Constructs the card by taking its value and suit type
     *
     * @param value value of the card by number
     * @param suit  suit of the card can be club, diamond, heart and spade.
     */
    public Card(int value, CardSuit suit) {
        this.value = value;
        this.suit = suit;

    }

    /**
     * @return returns the suit type of card as string
     */
    public CardSuit getSuit(){
        return suit;
    }

    /**
     * @return returns the value of card as number
     */
    public int getValue(){
        return value;
    }

    /**
     *
     * @return returns the information of the card such as suit and value as string
     */
    public String toString(){
        String str = "";
        if (value < 11){
            str = value + "";
        } else if (value == 11) {
            str = "Jack";
        } else if (value == 12) {
            str = "Queen";
        } else if (value == 13) {
            str = "King";
        }

        str = str + " of ";

        if (suit == CardSuit.CLUB){
            str = str + "Club";
        } else if (suit == CardSuit.DIAMOND){
            str = str + "Diamond";
        } else if (suit == CardSuit.HEART) {
            str = str + "Heart";
        } else if (suit == CardSuit.SPADE) {
            str = str + "Spade";
        }

        return str;
    }
}
