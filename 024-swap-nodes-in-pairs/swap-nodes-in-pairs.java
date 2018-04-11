// Given a linked list, swap every two adjacent nodes and return its head.
//
// For example,
// Given 1-&gt;2-&gt;3-&gt;4, you should return the list as 2-&gt;1-&gt;4-&gt;3.
//
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode f = head;
        ListNode s = head.next;
        while(s != null && f != null){
            ListNode tmp = s.next;
            pre.next = s;
            s.next = f;
            f.next = tmp;
            pre = f;
            if(f.next!=null){
                f = f.next;
                s = f.next;
            }else{
                f = null;
                s = null;
            }
            
        }
        return dummy.next;
    }
}
