/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        Node headB = head.next;
        temp = head;
        while (temp != null) {
            if (temp.random == null)
                temp.next.random = null;
            else
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        headB = head.next;

        while (temp != null) {
            Node copy = temp.next;
            temp.next = copy.next;

            if (copy.next != null)
                copy.next = copy.next.next;

            temp = temp.next;
        }
        return headB;
    }
}