package org.example.LinkedList.add_elemet_at_the_beginning;

import org.example.LinkedList.merge_two_sorted_lists_21.ListNode;

public class Solution {
    public static void main(String[] args) {

        ListNode head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(3)));

        System.out.println("Original list:");
        printList(head);
        System.out.println("List after inserting element:");
        head = insertAtBeginning(head,0);
        printList(head);
    }

    public static ListNode insertAtBeginning(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
