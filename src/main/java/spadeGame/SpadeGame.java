package spadeGame;

import linkedList.LinkedListCard;
import linkedList.LinkedListPlayer;
import player.Player;

public class SpadeGame {

    private LinkedListPlayer players;
    private LinkedListCard deck;
    private GameUtilities gameUtilities;

    /**
     * Constructs the game by initializing players deck and gameutilities
     */
    public SpadeGame(){
        gameUtilities = new GameUtilities();
        deck = gameUtilities.generateDeck();
        players = gameUtilities.generatePlayers();
    }

    /**
     * it runs a while loop until any player wins, in this loop playRound method called in order to play rounds.
     */
    public void run(){
        Player winner = gameUtilities.whoIsWinner(players);
        while (winner == null){
            playRound();
            gameUtilities.calculateScores(players);
            winner = gameUtilities.whoIsWinner(players);
        }
        System.out.println("\n" + players + "\n");
        System.out.println(winner.getName() + " won the game with "+ winner.getScore() + " points");

    }

    /**
     * it runs a while loop until deck finished, in this while loop playTrick method called in order to play tricks
     */
    private void playRound(){
        gameUtilities.setPlayersReady(players, deck);
        boolean isBroken = false;

        for (int i = 0; i < 13; i++){
            printGame();
            isBroken = playTrick(isBroken);
        }

    }

    /**
     * it runs a wile loop until every player play a card then using gameUtilities to manage the game
     * @return returns true if the hand is broken otherwise returns false
     */
    private boolean playTrick(boolean isBroken){

        Card initialCard = null;
        Card currentCard = null;
        Player winnerOfTrick = null;
        Card winnerCard = null;
        boolean trickBroken = isBroken;

        for (int i = 0; i < players.getSize(); i++){

            Player playing = players.get(i).getData();

            if (i == 0){
                initialCard = gameUtilities.playCard(playing, initialCard, trickBroken);
                winnerOfTrick = playing;
                winnerCard = initialCard;
            } else {
                currentCard = gameUtilities.playCard(playing, initialCard, trickBroken);
                if (currentCard.getSuit() == CardSuit.SPADE || initialCard.getSuit() == CardSuit.SPADE){
                    trickBroken = true;
                }
                if (currentCard.getSuit() == initialCard.getSuit()){
                    if (winnerCard.getSuit() != CardSuit.SPADE){
                        if (currentCard.getValue() > winnerCard.getValue()){
                            winnerCard = currentCard;
                            winnerOfTrick = playing;
                        }
                    }
                }
                if (currentCard.getSuit() == CardSuit.SPADE) {
                    if (winnerCard.getSuit() == CardSuit.SPADE){
                        if (currentCard.getValue() > winnerCard.getValue()){
                            winnerCard = currentCard;
                            winnerOfTrick = playing;
                        }

                    } else {
                        winnerCard = currentCard;
                        winnerOfTrick = playing;
                    }
                }

            }
        }
        winnerOfTrick.setNumOfTrickWon(winnerOfTrick.getNumOfTrickWon() + 1);
        System.out.println("\n" + winnerOfTrick.getName() + " won the trick");
        return trickBroken;
    }

    /**
     * prints the all hands of players
     */
    private void printGame(){
        System.out.print("\n"+players);

    }

    public static void main(String args[]){

        SpadeGame game = new SpadeGame();
        game.run();


    }

}
