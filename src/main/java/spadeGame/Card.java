package spadeGame;

public abstract class Card {
    private int value;
    private String suit;

    /**
     * Constructs the card by taking its value and suit type
     *
     * @param value value of the card by number
     * @param suit  suit of the card can be club, diamond, heart and spade.
     */
    public Card(int value, String suit) {}

    /**
     * @return returns the suit type of card as string
     */
    public abstract String getSuit();

    /**
     * @return returns the value of card as number
     */
    public abstract int getValue();

}
