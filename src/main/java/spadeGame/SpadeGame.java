package spadeGame;

import linkedList.LinkedListCard;
import linkedList.LinkedListPlayer;

public abstract class SpadeGame {

    private LinkedListPlayer players;
    private LinkedListCard deck;

    public SpadeGame(){}

    public abstract void run();

    abstract void playRound();
    abstract void playTrick();

    abstract void printGame();


}
