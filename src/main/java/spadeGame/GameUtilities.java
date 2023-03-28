package spadeGame;

import linkedList.LinkedListCard;
import linkedList.LinkedListPlayer;
import player.Player;

public class GameUtilities {

    /**
     *
     * @return returns a deck of 52 cards
     */

    public LinkedListCard generateDeck(){
        return null;
    }

    /**
     *
     * @return returns 4 players to initialize the game
     */

    public LinkedListPlayer generatePlayers(){
        return null;
    }

    /**
     *
     * @param isSpadeBreaken considering this information card will be played
     * @param player which player is going to play
     * @return returns the card that played by given player
     */

    public Card playCard(Player player, boolean isSpadeBreaken){
        return null;
    }


    /**
     * Sets player ready for the next round by dealing cards and making bids
     * @param players players that will be ready for next trick
     * @param deck deck will be
     */
    public void setPlayersReady(LinkedListPlayer players, LinkedListCard deck){

    }

    /**
     *
     * @param players players that will be checked
     * @return returns the player that won if no one won the game then returns null
     */
    public Player isThereWinner(LinkedListPlayer players){
        return null;
    }



}
