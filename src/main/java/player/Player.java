package player;

import linkedList.LinkedListCard;

/**
 * @
 *
 */

public abstract class Player {

    private String name;
    private int score;
    private int bid;
    private LinkedListCard hand;

    /**
     *
     * @param name in order to seperate players from each other
     *
     */
    public Player(String name) {
    }

    public abstract int getBid();

    public abstract void setBid(int bid);

    public abstract int getScore();

    public abstract void setScore(int score);

    public abstract LinkedListCard getHand();
    public abstract void setHand(LinkedListCard hand);

    public abstract String getName();
}