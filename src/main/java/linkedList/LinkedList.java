package linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * constructs the linkedlist by initializing the attributes
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     *
     * @return returns the information of if list empty or not
     */

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @return returns the head of the linkedlist as a node
     */
    public Node getHead(){
        return head;
    }

    /**
     *
     * @return returns the last node of the linkedlist as a node
     */
    public Node getLast(){
        return tail;
    }

    /**
     *
     * @param newNode inserts the given node to the beginning of the list
     */
    public void insertFirst(Node newNode) {
        if (size == 0){
            head = newNode;
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
        size ++;
    }


    /**
     *
     * @return returns the size of the list
     */
    public int getSize(){
        return size;
    }

    /**
     * deletes the first node of the list
     */
    public void deleteFirst(){
        if (size == 0){
            return;
        }
        if(size == 1){
            head = null;
            tail = null;
            size --;
            return;
        }
        head = head.getNext();
        size --;

    }
}
