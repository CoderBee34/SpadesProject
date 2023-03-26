package linkedList;

public class Node {
    private int data;
    private Node next;

    /**
     * construct the node by initializing its attributes
     * @param data date that node will contain
     */
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    /**
     * set a link to the next node
     * @param next node will be linked to this node as next
     */
    public void setNext(Node next){
        this.next = next;
    }

    /**
     *
     * @return returns the next node
     */
    public Node getNext(){
        return next;
    }

    /**
     *
     * @return returns the data of the node
     */
    public int getData(){
        return data;
    }

}
