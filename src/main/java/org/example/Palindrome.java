package org.example;

public class Palindrome {

    private int size;
    Palindrome() {
        size = 0;
    }

    public class ListNode {
        String data;
        ListNode next;
        ListNode(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode currn = head;
        while (currn != null){
            ListNode next = currn.next;
            currn.next = prev;
            prev = currn;
            currn = next;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head){

        ListNode hare = head;
        ListNode turtle = head;
        while (hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return  turtle;
    }

    public boolean isPalindrome(ListNode head){

        if(head == null || head.next == null){
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);
        ListNode firstHalfStart = head;

        while (secondHalfStart != null){
            if(firstHalfStart.data.equals(secondHalfStart.data)){
                return  true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Palindrome p = new Palindrome();

        // build list: "A" -> "B" -> "B" -> "A"
        Palindrome.ListNode head = p.new ListNode("A");
        head.next = p.new ListNode("B");
        head.next.next = p.new ListNode("B");
        head.next.next.next = p.new ListNode("A");

        boolean result = p.isPalindrome(head);
        System.out.println("Is palindrome: " + result);
    }
}
