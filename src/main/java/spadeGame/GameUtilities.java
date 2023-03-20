package spadeGame;

import linkedList.LinkedListCard;
import linkedList.LinkedListPlayer;
import player.Player;

public abstract class GameUtilities {

    public abstract LinkedListCard generateDeck();

    public abstract LinkedListPlayer generatePlayers();

    public abstract Card playCardAI(Player player);

    public abstract void printHand(Player player);

}
