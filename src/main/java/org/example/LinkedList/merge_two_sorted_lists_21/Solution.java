package org.example.LinkedList.merge_two_sorted_lists_21;

public class Solution {
    /*
    * You are given the heads of two sorted linked lists list1 and list2.
    * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    * Return the head of the merged linked list.
    * */
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));

        // Example: list2 = 1 -> 3 -> 4
        ListNode list2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));

        printList(mergeTwoLists(list1,list2));

    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Example: list1 = 1 -> 2 -> 4
        // Example: list2 = 1 -> 3 -> 4
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }
}

