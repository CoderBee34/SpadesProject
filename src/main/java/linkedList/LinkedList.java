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
            tail = null;
        }
        head = head.getNext();
        size --;

    }

    /**
     *
     * @param index index of node that wanted
     * @return returns the node in the given index
     */
    public Node get(int index){

        if (index < 0 || index >= size)
            return null;
        if (index == 0)
            return getHead();
        if (index == size - 1)
            return getLast();

        Node tmp = head;
        int i = 0;

        while (i<index){
            tmp = tmp.getNext();
        }
        return tmp;
    }


    /**
     * removes the given number from the list
     * @param index node in the given index will be removed
     */
    public void remove(int index){
        Node pre = null;
        Node tmp = head;

        int i = 0;
        while (tmp != null){
            if (i == index){
                if (pre != null) {
                    pre.setNext(tmp.getNext());
                    size--;
                } else {
                    deleteFirst();
                }
                return;
            } else {
                pre = tmp;
                tmp = tmp.getNext();
                i++;
            }
        }

    }
}
