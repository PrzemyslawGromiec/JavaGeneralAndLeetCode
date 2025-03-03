package org.example.LinkedList.remove_nth_node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NthNodeTest {

    private NthNode.ListNode createList(int[] values) {
        NthNode.ListNode dummy = new NthNode.ListNode(0);
        NthNode.ListNode current = dummy;
        for(int val : values) {
            current.next = new NthNode.ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] listToArray(NthNode.ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
