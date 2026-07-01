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
    ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode first = head.next;
        first.next = head;
        head.next = null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode newHead = reverse(slow.next);
        fast = head;
        slow = newHead;
        while(slow != null){
            if(fast.val != slow.val){
                mid.next = reverse(newHead);
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        mid.next = reverse(newHead);
        return true;
    }
}