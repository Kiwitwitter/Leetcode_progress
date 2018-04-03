// Given a linked list, remove the nth node from the end of list and return its head.
//
// For example,
//
//
//    Given linked list: 1-&gt;2-&gt;3-&gt;4-&gt;5, and n = 2.
//
//    After removing the second node from the end, the linked list becomes 1-&gt;2-&gt;3-&gt;5.
//
//
// Note:
// Given n will always be valid.
// Try to do this in one pass.
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<= 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 0;
        ListNode a = head;
        ListNode pre = dummy;
        while(head.next != null){
            head = head.next;
            i++;
            if(i>n-1){
                pre = pre.next;
                a = a.next;
            }
        }
        pre.next = a.next;
        return dummy.next;
    }
}
