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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tail = null;
        ListNode head = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(head == null){
                    head = list1;
                    tail = list1;
                }
                else{
                    tail.next = list1;
                    tail = tail.next;
                }
                list1 = list1.next;
            }
            else{
                if(head == null){
                    head = list2;
                    tail = list2;
                }
                else{
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            if(head == null)
                head = list2;
            else
                tail.next = list2;
        }
        else if(list2 == null){
            if(head == null)
                head = list1;
            else
                tail.next = list1;
        }
        return head;
    }
    static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(slow);
        return mergeTwoLists(leftHead,rightHead);
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}