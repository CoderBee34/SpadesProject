package linkedList;

import spadeGame.Card;

public class NodeCard {
    private Card data;
    private NodeCard next;

    /**
     * construct the node by initializing its attributes
     * @param data date that node will contain
     */
    public NodeCard(Card data){
        this.data = data;
        next = null;

    }

    /**
     * set a link to the next nodecard
     * @param next nodecard will be linked to this nodecard as next
     */
    public void setNext(NodeCard next){
        this.next = next;
    }

    /**
     *
     * @return returns the next nodecard
     */
    public NodeCard getNext(){
        return next;
    }

    /**
     *
     * @return returns the data of the nodecard
     */
    public Card getData(){
        return data;
    }
}
