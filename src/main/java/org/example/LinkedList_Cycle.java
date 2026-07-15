package org.example;

public class LinkedList_Cycle {

    private int size;
    LinkedList_Cycle(){
        size = 0;
    }

    public class ListNode{
        String data;
        ListNode next;

        public ListNode(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public boolean hasCyclic(ListNode head){

        if(head == null){
            return false;
        }

        ListNode hare = head;
        ListNode turtle = head;

        while (hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                return true;
            }
        }
        return  false;

    }

    public static void main(String[] args) {

        LinkedList_Cycle ll = new LinkedList_Cycle();

        // build list: A -> B -> C -> D
        LinkedList_Cycle.ListNode head = ll.new ListNode("A");
        head.next = ll.new ListNode("B");
        head.next.next = ll.new ListNode("C");
        head.next.next.next = ll.new ListNode("D");

        // no cycle case
        System.out.println("Has cycle: " + ll.hasCyclic(head));

        // create a cycle: D -> B (points back into the list)
        head.next.next.next.next = head.next;
        System.out.println("Has cycle: " + ll.hasCyclic(head));
    }
}
