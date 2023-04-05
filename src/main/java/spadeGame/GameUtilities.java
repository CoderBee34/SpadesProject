package spadeGame;

import linkedList.*;
import player.Player;
import player.PlayerType;

import java.util.Random;
import java.util.Scanner;

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
     * @param initialCard considering this information card will be played
     * @param player which player is going to play
     * @return returns the card that played by given player
     */

    public Card playCard(Player player, Card initialCard, boolean isBroken){

        LinkedListCard deck = player.getHand();
        Scanner inp = new Scanner(System.in);
        Card cardPlayed = null;
        boolean anyCardObeyRules = false;

        if (player.getPlayerType() == PlayerType.PLAYER_AI){
            for (int i = 0; i < deck.getSize(); i++){
                Card card = deck.get(i).getData();

                if (isCardObeysRules(card, initialCard, isBroken, deck)){
                    cardPlayed = card;
                    deck.remove(i);
                    anyCardObeyRules = true;
                    break;
                }
            }
            if (!anyCardObeyRules){
                cardPlayed = deck.get(0).getData();
                deck.remove(0);
            }
            System.out.println(player.getName() + " played " + cardPlayed);

        } else if (player.getPlayerType() == PlayerType.PLAYER_REAL) {

            LinkedList listOfCardsThatObeysRules = new LinkedList();

            for (int i = 0; i < deck.getSize(); i++){
                if (isCardObeysRules(deck.get(i).getData(), initialCard, isBroken, deck)){
                    listOfCardsThatObeysRules.insertFirst(new Node(i));
                }
            }

            System.out.println("Enter the number of card that you want to play");

            int playedCardIndex = inp.nextInt();
            while (playedCardIndex < 0 || playedCardIndex >= deck.getSize()){
                System.out.println("Invalid number please enter again");
                playedCardIndex = inp.nextInt();
            }
            while (!listOfCardsThatObeysRules.contains(playedCardIndex)){

                System.out.println("This card does not obey rules play another card");
                playedCardIndex = inp.nextInt();
                while (playedCardIndex < 0 || playedCardIndex >= deck.getSize()){
                    System.out.println("Invalid number please enter again");
                    playedCardIndex = inp.nextInt();
                }

            }
            if (listOfCardsThatObeysRules.isEmpty()){
                playedCardIndex = 0;
            }
            cardPlayed = deck.get(playedCardIndex).getData();

        }
        return cardPlayed;
    }

    /**
     *
     * Checks the given card obey the rules for the given instructions and paramaters
     *
     * @return returns true if obey otherwise return false
     */

    private boolean isCardObeysRules(Card card, Card initialCard, boolean isBroken, LinkedListCard deck){
        boolean isObey;

        if (isBroken){
            if (initialCard != null){
                if (deck.containsSuitType(initialCard.getSuit())){
                    isObey = (card.getSuit() == initialCard.getSuit()) ? true : false;
                } else {
                    isObey = true;
                }
            } else {
                isObey = true;
            }
        } else {
            if (initialCard != null){
                if (deck.containsSuitType(initialCard.getSuit())){
                    isObey = (card.getSuit() == initialCard.getSuit()) ? true : false;
                } else {
                    isObey = (card.getSuit() == CardSuit.SPADE) ? true : false;
                }
            } else {
                isObey = (card.getSuit() != CardSuit.SPADE) ? true : false;
            }
        }
        return isObey;
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
            player.setBid(rnd.nextInt(0,6));
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
    public Player whoIsWinner(LinkedListPlayer players){

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
