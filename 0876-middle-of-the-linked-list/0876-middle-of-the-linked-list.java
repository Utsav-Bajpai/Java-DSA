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
    public ListNode middleNode(ListNode head) {
        ListNode oneJmp = head;
        ListNode twoJmp = head;
        while(twoJmp != null && twoJmp.next != null){
            oneJmp = oneJmp.next;
            twoJmp = twoJmp.next.next;
        }
        return oneJmp;
    }
}