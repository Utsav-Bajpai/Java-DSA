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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        if(head.next.next == null){
            ListNode temp = head.next;
            temp.next = head;
            head.next = null;
            return temp;
        }
        ListNode tLast = head;
        ListNode sLast = head.next;
        ListNode last = sLast.next;
        head.next = null;
        while(last != null){
            sLast.next = tLast;
            tLast = sLast;
            sLast = last;
            last = last.next;
        }
        sLast.next = tLast;
        return sLast;
    }
}