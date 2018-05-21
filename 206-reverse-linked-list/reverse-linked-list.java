// Reverse a singly linked list.
//
// Example:
//
//
// Input: 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
// Output: 5-&gt;4-&gt;3-&gt;2-&gt;1-&gt;NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    public ListNode reverseList(ListNode head) {
        if(head ==null)
            return head;
        
        ListNode curHead = head;
        while(head.next != null){
            ListNode p = head.next;
            head.next = p.next;
            p.next = curHead;
            curHead = p;
        }
        return curHead;
    }
}
