package spadeGame;

import linkedList.*;
import player.Player;
import player.PlayerType;

import java.util.Random;

public class GameUtilities {

    /**
     *
     * @return returns a deck of 52 cards for every suit creates 13 cards
     */

    public LinkedListCard generateDeck(){
        LinkedListCard cardDeck = new LinkedListCard();
        CardSuit[] suits = {CardSuit.CLUB, CardSuit.DIAMOND, CardSuit.HEART, CardSuit.SPADE};

        for (int i = 0; i< suits.length;i++){
            for (int j = 2; j < 15; j++){
                cardDeck.insertFirst(new NodeCard(new Card(j, suits[i])));
            }
        }

        return cardDeck;
    }

    /**
     *
     * @return returns 4 players to initialize the game
     */

    public LinkedListPlayer generatePlayers(){

        LinkedListPlayer players = new LinkedListPlayer();

        for (int i = 0; i < 3; i++){
            players.insertFirst(new NodePlayer(new Player(("playerAI"+(i+1)),PlayerType.PLAYER_AI)));
        }

        players.insertFirst(new NodePlayer(new Player("real", PlayerType.PLAYER_REAL)));

        return players;
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

    /**
     * calculates the scores of the players as given in the project description
     */
    public void calculateScores(LinkedListPlayer players){


    }


}
