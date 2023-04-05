package linkedList;

import player.Player;

public class LinkedListPlayer {
    private NodePlayer head;
    private NodePlayer tail;
    private int size;

    /**
     * constructs the linkedlist by initializing the attributes
     */
    public LinkedListPlayer() {
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
     * @param index index of nodeplayer that wanted
     * @return returns the nodeplayer in the given index
     */
    public NodePlayer get(int index){

        if (index < 0 || index >= size)
            return null;
        if (index == 0)
            return getHead();
        if (index == size - 1)
            return getLast();

        NodePlayer tmp = head;
        int i = 0;

        while (i<index ){

            tmp = tmp.getNext();
            i++;
        }
        return tmp;
    }

    /**
     *
     * @return returns the head of the linkedlist as a node
     */
    public NodePlayer getHead(){
        return head;
    }

    /**
     *
     * @return returns the last node of the linkedlist as a node
     */
    public NodePlayer getLast(){
        return tail;
    }

    /**
     *
     * @param newNode inserts the given node to the beginning of the list
     */
    public void insertFirst(NodePlayer newNode) {

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
            head = null;
            tail = null;
            size --;
            return;
        }
        head = head.getNext();
        size --;
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < size; i++){
            Player tmp = get(i).getData();
            str = str + ((i + 1)+" - ") + tmp + "\n";
        }

        return str;
    }
}
