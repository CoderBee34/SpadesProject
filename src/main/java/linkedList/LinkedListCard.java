package linkedList;

import spadeGame.Card;

public class LinkedListCard {
    private NodeCard head;
    private NodeCard tail;
    private int size;

    /**
     * constructs the linkedlist by initializing the attributes
     */
    public LinkedListCard() {
        head = null;
        tail = null;
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
     * @param index index of nodecard that wanted
     * @return returns the nodecard in the given index
     */
    public NodeCard get(int index){

        if (index < 0 || index > size)
            return null;
        if (index == 0)
            return getHead();
        if (index == size - 1)
            return getLast();

        NodeCard tmp = head;
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
    public NodeCard remove(int index){
        NodeCard pre = null;
        NodeCard tmp = head;

        int i = 0;
        while (tmp != null){
            if (i == index){
                if (pre != null) {
                    pre.setNext(tmp.getNext());
                    size--;
                    return tmp;
                } else {
                    NodeCard tmp2 = head;
                    deleteFirst();
                    return tmp2;
                }

            } else {
                pre = tmp;
                tmp = tmp.getNext();
                i++;
            }
        }
        return null;

    }


    /**
     *
     * @return returns the head of the linkedlist as a nodecard
     */
    public NodeCard getHead(){
        return head;
    }

    /**
     *
     * @return returns the last node of the linkedlist as a nodecard
     */
    public NodeCard getLast(){
        return tail;
    }

    /**
     *
     * @param newNode inserts the given node to the beginning of the list
     */
    public void insertFirst(NodeCard newNode) {

        if (size == 0){
            head = newNode;
            tail = newNode;
            size ++;
            return;
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

    /**
     *
     * @return returns the information of linkedlistcard in othername deck, lists the all card in the deck
     */
    public String toString(){
        String str = "";
        for (int i = 0; i < size;i++){
            str = str + ((i+1) +" - ") + get(i).getData();
            if (i % 3 == 0 && i != 0){
                str = str + "\n";
            }
        }
        return str;
    }
}
