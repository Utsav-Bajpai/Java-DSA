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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        while(ptr1 != null|| ptr2 != null || carry != 0){
            int sum = carry;
            if(ptr1 != null){
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }
            if(ptr2 != null){
                sum += ptr2.val;
                ptr2 = ptr2.next;
            }
            carry = sum/10;
            int val = sum%10;
            ListNode node = new ListNode(val);
            if(head==null){
                head = node;
                curr = node;
            }else{
                curr.next = node;
                curr = curr.next;
            }
        }
        return head;
    }
}