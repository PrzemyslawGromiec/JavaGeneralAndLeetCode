package org.example.LinkedList.remove_nth_node;

public class NthNode {
    public static void main(String[] args) {
        NthNode solution = new NthNode();

        // Przykładowa lista [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);

        int n = 2; // Usuwamy 2. węzeł od końca (4)

        // Wywołujemy metodę
        ListNode newHead = solution.removeNthFromEnd(head, n);

        // Wyświetlamy wynik
        printList(newHead);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {};
        public ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val;
        this.next = next;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next !=null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

}
