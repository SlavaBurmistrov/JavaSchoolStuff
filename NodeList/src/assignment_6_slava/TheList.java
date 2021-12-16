/*

      File:  TheList.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the main class for the list. It has methods to modify 
      the list of nodes. It all contains the Node class.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_6_slava;

/**
 * This is the main blueprint for the list of nodes. It acts as a chain if
 * nodes, where each node is linked to its next one by a single link. It has
 * many methods to modify it.
 *
 * @author Slava
 */
public class TheList<E> {

    private String list; //To store the list of nodes
    private Node head; //The first node

    /**
     * The constructor initializes the first node to be null value
     */
    public TheList() {
        head = null;
    }
//-----------------------UTILITY--METHODS--------------------------------------

    /**
     * Goes through the list and finds the last node
     *
     * @return the last node of the list
     */
    private Node lastNode() {
        if (head == null) { //if list is empty returns nothing
            return null;
        } else {    // <----Gets pointer to last node
            Node temp = head; //Start at the head
            while (temp.next != null) { // While the last is not null
                temp = temp.next; // moves to the next node
            }
            return temp;
        }
    }

    /**
     * This method searches the list for a specific node and returns it.
     *
     * @param n the spot in the list
     * @return the found node
     */
    private Node searchNode(int n) {
        Node temp = head; //Sets the first node
        for (int j = 1; j < n; j++) { //Goes through the lits
            temp = temp.next;         //intil reaches N.
            if (temp == null) { //if it doesnt reach N
                break; //Ends loop
            }
        }
        return temp; //Returns the last set node
    }

    /**
     * Counts the nodes in the list and returns the count.
     *
     * @return the size of the list
     */
    private int countList() {
        Node temp = head;
        int count = 0;
        while (temp != null) { //goes through the list
            count++; //counts how many times
            temp = temp.next;
        }
        return count;
    }
//-----------------------------------------------------------------------------
    /**
     * This method acts as a method that converts the whole list to a string
     * @return the list 
     */
    @Override
    public String toString() {
        list = ""; //List is empty
        if (head == null) { //if it is empty
            return "The List is Empty";
        }
        Node temp = head;
        while (temp != null) {//goes through the list
            list += temp + " "; //saves each value
            temp = temp.next;
        }
        return list;
    }

    /**
     * This method deletes a node at the specific spot.
     *
     * @param p the spot of the node
     */
    public void DELETE(int p) {
        if (p == 1) { //if the node to delete is the head (1)
            head = head.next; //sets the new head to be the second node
        } else { //if not the head
            Node temp = searchNode(p); //find the node
            searchNode(p - 1).next = temp.next; //now it is its next node
        }
    }

    /**
     * This method reverses the list. It takes the second to last node, puts it
     * at the end and then deletes its original position.
     */
    public void REVERSE() {
        if (head == null) { //if the list is empty
            System.out.println("The list is empty and cannot be reversed.");
            return;
        }
        for (int i = countList() - 1; i > 0; i--) { //if not, go through it
            Node temp = searchNode(i); //get the second to last
            DELETE(i); //remove it from the list
            temp.next = null; //set its next to be null
            lastNode().next = temp; //put it at the end
        }
    }

    /**
     * This methods adds a node after a specific spot of the list
     *
     * @param n The spot on the list
     * @param x The node to add
     */
    public void ADD(int n, E x) {
        Node temp1 = searchNode(n); //get the spot of the node
        Node newNode = new Node(x); //create a new node
        if (n == 1) { //if the spot is the head
            head = newNode; //it becomes a new node
            newNode.next = temp1; //the previous nodes go after it
        } else {
            searchNode(n - 1).next = newNode; //set the new node
            newNode.next = temp1; //the previous nodes go after it
        }
    }

    /**
     * This method finds two specific nodes and then swaps them.
     *
     * @param m node 1
     * @param n node 2
     */
    public void SWAP(int m, int n) {
        Node swapM; //first  node
        Node swapMnext; //first node's other nodes
        Node swapN; //seocnd node
        Node swapNnext; //second node's other nodes

        if (m == n) {//if they are the same
            System.out.print("Cannot Swap.");
            return;
        }

        if (searchNode(m) == head) { //if the first node is the head
            swapM = head; //Get the node
            swapMnext = head.next; //Get the node's nodes

            swapN = searchNode(n);//Get the node
            swapNnext = searchNode(n + 1); //Get the node's nodes

            swapN.next = swapMnext; //Swap the nodes' nodes 
            swapM.next = swapNnext;

            head = swapN; //Swap the nodes
            searchNode(n - 1).next = swapM;

        } else if (searchNode(n) == lastNode()) { //if second node is the last
            swapM = searchNode(m);//Get the node
            swapMnext = searchNode(m + 1);//Get the node's nodes

            swapN = lastNode();//Get the node
            swapNnext = null;//Get the node's nodes

            swapN.next = swapMnext;//Swap the nodes' nodes 
            swapM.next = swapNnext;

            searchNode(m - 1).next = swapN;//Swap the nodes
            searchNode(n - 1).next = swapM;

        } else {
            swapM = searchNode(m);//Get the node
            swapMnext = searchNode(m + 1);//Get the node's nodes

            swapN = searchNode(n);//Get the node
            swapNnext = searchNode(n + 1);//Get the node's nodes

            swapN.next = swapMnext;//Swap the nodes' nodes 
            swapM.next = swapNnext;

            searchNode(m - 1).next = swapN;//Swap the nodes
            searchNode(n - 1).next = swapM;
        }
    }

    /**
     * This method clears the entire list by setting the first node to null
     */
    public void CLEAR() {
        head = null;
    }

    /**
     * This node adds a new node to the end of the list
     *
     * @param x the node to add
     */
    public void APPEND(E x) {
        Node temp = new Node(x);

        if (head == null) { //if list is empty
            head = temp; //put new node at the head
        } else {
            lastNode().next = temp; //put the new node to the end

        }
    }

    /**
     * This is the node class. It is the blueprint for the nodes in the list
     */
    class Node {

        private E info; //Stores the info of the node
        private Node next; //stores the next node on the list

        /**
         * The constructor of the node class sets the value of it to a parsed
         * value, and the end of the node is set to null.
         *
         * @param x
         */
        public Node(E x) {
            info = x;
            next = null;
        }

        /**
         * This methods return the info on the node
         *
         * @return
         */
        @Override
        public String toString() {
            return info + "";
        }
    }

}
