package linkedList;

import player.Player;

public class NodePlayer {
    private Player data;
    private NodePlayer next;

    /**
     * construct the node by initializing its attributes
     * @param data date that node will contain
     */
    public NodePlayer(Player data){
        this.data = data;
        next = null;
    }

    /**
     * set a link to the next node
     * @param next node will be linked to this node as next
     */
    public void setNext(NodePlayer next){
        this.next = next;
    }

    /**
     *
     * @return returns the next node
     */
    public NodePlayer getNext(){
        return next;
    }

    /**
     *
     * @return returns the data of the node
     */
    public Player getData(){
        return data;
    }

}
