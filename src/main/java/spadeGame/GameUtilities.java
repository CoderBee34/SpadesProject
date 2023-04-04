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

        for (int i = 0; i< 4;i++){
            for (int j = 2; j < 15; j++){
                if (i == 0){
                    cardDeck.insertFirst(new NodeCard(new Card(j, CardSuit.DIAMOND)));
                } else if (i == 1) {
                    cardDeck.insertFirst(new NodeCard(new Card(j, CardSuit.CLUB)));
                } else if (i == 2) {
                    cardDeck.insertFirst(new NodeCard(new Card(j, CardSuit.HEART)));
                } else if (i == 3) {
                    cardDeck.insertFirst(new NodeCard(new Card(j, CardSuit.SPADE)));
                }
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

        Random rnd = new Random();

        for (int i = 0; i < players.getSize(); i++){
            Player player = players.get(i).getData();
            player.setBid(rnd.nextInt(3,7));
            player.setNumOfTrickWon(0);
        }


        for (int i = 0; i < 52; i++){
            int random =rnd.nextInt(52-i);
            NodeCard tmp = deck.remove(random);
            deck.insertFirst(tmp);
        }
        int counter = 0;
        for (int i = 0; i < players.getSize(); i++){
            LinkedListCard hand = players.get(i).getData().getHand();
            for (int j = 0; j < 13; j++){
                hand.insertFirst(deck.get(counter));
                counter ++;
            }

        }
    }

    /**
     *
     * @param players players that will be checked
     * @return returns the player that won if no one won the game then returns null
     */
    public Player isThereWinner(LinkedListPlayer players){

        int maxPoint = Integer.MIN_VALUE;
        Player winner = null;

        for (int i = 0; i < players.getSize(); i ++){
            int score = players.get(i).getData().getScore();
            if (score > 500 && score > maxPoint){
                maxPoint = score;
                winner = players.get(i).getData();
            }
        }
        return winner;
    }

    /**
     * calculates the scores of the players as given in the project description
     */
    public void calculateScores(LinkedListPlayer players){

        for (int i = 0; i < players.getSize(); i++){
            Player player = players.get(i).getData();
            int numOfWins = player.getNumOfTrickWon();
            int bid = player.getBid();

            if (numOfWins >= bid){
                player.setScore(player.getScore() + bid * 10 + (numOfWins - bid));
            } else if (numOfWins < bid) {
                player.setScore(player.getScore() - bid * 10);
            }
        }
    }
}
