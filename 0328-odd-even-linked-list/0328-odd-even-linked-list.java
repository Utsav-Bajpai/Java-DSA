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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenHead = head.next, poi = head, even = head.next;
        while(even != null && even.next != null){
            poi.next = poi.next.next;
            even.next = even.next.next;
            poi = poi.next;
            even = even.next;
        }
        poi.next = evenHead;
        return head;
    }
}