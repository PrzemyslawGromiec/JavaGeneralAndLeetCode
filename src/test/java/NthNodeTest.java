import org.example.LinkedList.remove_nth.NthNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

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

    @Test
    public void testRemoveNthFromEnd_middleNode() {
        NthNode solution = new NthNode();
        NthNode.ListNode head = createList(new int[]{1, 2, 3, 4, 5});

        // Remove 2nd node from the end (expected result: [1, 2, 3, 5])
        NthNode.ListNode result = solution.removeNthFromEnd(head, 2);
        assertArrayEquals(new int[]{1, 2, 3, 5}, listToArray(result));
    }

    @Test
    public void testRemoveNthFromEnd_removeHead() {
        NthNode solution = new NthNode();
        NthNode.ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        NthNode.ListNode result = solution.removeNthFromEnd(head,5);
        assertArrayEquals(new int[]{2, 3, 4, 5},listToArray(result));
    }

}
