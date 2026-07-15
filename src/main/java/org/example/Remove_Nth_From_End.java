package org.example;

public class Remove_Nth_From_End {

    ListNode head;
    private  int size;

    Remove_Nth_From_End(){
        size = 0;
    }

    public class ListNode{
        String data;
        ListNode next;

        ListNode(String data){
            this.data = data;
            this.next = null;
            size ++;
        }
    }

    public  ListNode removeNthFromEnd(ListNode head , int n){

        if( head.next == null){
            return null;
        }
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            curr = curr.next;
            size++;
        }
        int indexToSearch = size-n;
        ListNode prev = head;
        int i = 1;
        while(i != indexToSearch){
          prev = prev.next;
          i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public void printList(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
      Remove_Nth_From_End obj = new Remove_Nth_From_End();

        ListNode n1 = obj.new ListNode("1");
        ListNode n2 = obj.new ListNode("2");
        ListNode n3 = obj.new ListNode("3");
        ListNode n4 = obj.new ListNode("4");
        ListNode n5 = obj.new ListNode("5");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        obj.head = n1;

        obj.printList(obj.head);
        obj.head = obj.removeNthFromEnd(obj.head, 2);
        obj.printList(obj.head);

    }
}
