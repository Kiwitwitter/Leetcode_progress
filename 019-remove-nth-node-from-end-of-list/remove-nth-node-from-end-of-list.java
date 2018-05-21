// Given a linked list, remove the n-th node from the end of list and return its head.
//
// Example:
//
//
// Given linked list: 1-&gt;2-&gt;3-&gt;4-&gt;5, and n = 2.
//
// After removing the second node from the end, the linked list becomes 1-&gt;2-&gt;3-&gt;5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
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
        ListNode D = new ListNode(0);
        D.next = head;
        ListNode first = D;
        ListNode second = D;
        for(int i = 0;i <= n;i++){
            first = first.next;
        }
        
        while(first != null){
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return D.next;
    }
}
