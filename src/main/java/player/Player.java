package player;

import linkedList.LinkedListCard;


public class Player {

    private String name;
    private int score;
    private int bid;
    private LinkedListCard hand;
    private PlayerType playerType;

    /**
     *
     * @param name in order to separate players from each other
     * @param playerType in order to know the type of player
     *
     */
    public Player(String name, PlayerType playerType) {
    }

    /**
     *
     * @return returns the number of bidding of player
     */

    public int getBid(){
        return 0;
    }

    /**
     *
     * @param bid sets number of bidding to player
     */

    public void setBid(int bid){
    }

    /**
     *
     * @return returns the score of player
     */

    public int getScore(){
        return 0;
    }

    /**
     *
     * @param score sets the score of player
     */

    public void setScore(int score){
    }

    /**
     *
     * @return returns cards of player in a linked list
     *
     */

    public LinkedListCard getHand(){
        return null;
    }

    /**
     *
     * @param hand give a hand to player
     */
    public void setHand(LinkedListCard hand){
    }

    /**
     *
     * @return returns the name of the player
     */

    public String getName(){
        return null;
    }
}