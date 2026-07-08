/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevTail = null;

        while (temp != null) {
            ListNode kNode = kthnode(temp, k);

            // Less than k nodes left
            if (kNode == null) {
                if (prevTail != null)
                    prevTail.next = temp;
                break;
            }

            ListNode nextGroup = kNode.next;
            kNode.next = null;

            ListNode newHead = reverse(temp);

            if (temp == head)
                head = newHead;
            else
                prevTail.next = newHead;

            prevTail = temp;
            temp.next = nextGroup;
            temp = nextGroup;
        }

        return head;
    }

    ListNode kthnode(ListNode node, int k) {
        while (node != null && --k > 0) {
            node = node.next;
        }
        return node;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}