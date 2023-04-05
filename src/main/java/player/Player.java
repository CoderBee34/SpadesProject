package player;

import linkedList.LinkedListCard;


public class Player {

    private String name;
    private int score;
    private int numOfTrickWon;
    private int bid;
    private LinkedListCard hand;
    private PlayerType playerType;

    /**
     *
     * @param name in order to separate players from each other
     * @param playerType in order to know the type of player
     */
    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
        score = 0;
        numOfTrickWon = 0;
        bid = 0;
        hand = null;
    }

    /**
     *
     * @return returns the number of bidding of player
     */

    public int getBid(){
        return bid;
    }

    /**
     *
     * @param bid sets number of bidding to player
     */

    public void setBid(int bid){
        this.bid = bid;
    }

    /**
     *
     * @return returns the score of player
     */

    public int getScore(){
        return score;
    }

    /**
     *
     * @param score sets the score of player
     */

    public void setScore(int score){
        this.score = score;
    }

    /**
     *
     * @return returns cards of player in a linked list
     */

    public LinkedListCard getHand(){
        return hand;
    }

    /**
     *
     * @param hand give a hand to player
     */
    public void setHand(LinkedListCard hand){
        this.hand = hand;
    }

    /**
     *
     * @return returns the name of the player
     */

    public String getName(){
        return name;
    }

    /**
     *
     * @return returns the type of player either AI or real
     */
    public PlayerType getPlayerType() {
        return playerType;
    }

    /**
     *
     * @return returns the number of trick won byplayer
     */
    public int getNumOfTrickWon() {
        return numOfTrickWon;
    }

    /**
     *
     * @param numOfTrickWon sets number of trick won by given parameter
     */
    public void setNumOfTrickWon(int numOfTrickWon) {
        this.numOfTrickWon = numOfTrickWon;
    }

    /**
     *
     * @return returns the information of the player as string
     */
    public String toString(){
        String str = "Name: ";
        str = str + name + ", Bids: " + bid + ", Score: " + score + ", Hand: \n" + hand;
        return str;
    }

}