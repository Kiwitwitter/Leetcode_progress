// Given a linked&nbsp;list, rotate the list to the right by k places, where k is non-negative.
//
// Example 1:
//
//
// Input: 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL, k = 2
// Output: 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
// Explanation:
// rotate 1 steps to the right: 5-&gt;1-&gt;2-&gt;3-&gt;4-&gt;NULL
// rotate 2 steps to the right: 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
//
//
// Example 2:
//
//
// Input: 0-&gt;1-&gt;2-&gt;NULL, k = 4
// Output: 2-&gt;0-&gt;1-&gt;NULL
// Explanation:
// rotate 1 steps to the right: 2-&gt;0-&gt;1-&gt;NULL
// rotate 2 steps to the right: 1-&gt;2-&gt;0-&gt;NULL
// rotate 3 steps to the right:&nbsp;0-&gt;1-&gt;2-&gt;NULL
// rotate 4 steps to the right:&nbsp;2-&gt;0-&gt;1-&gt;NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k <= 0)
            return head;
        ListNode ptr = head;
        int i = 0;
        while(ptr.next!=null){
            ptr = ptr.next;
            i++;
        }
        ptr.next = head;
        int len = i+1;
        int num = len - k%len;
        for(int j=0;j<num-1;j++){
            head = head.next;
        }
        ListNode p = head.next;
        head.next = null;
        return p;
    }
}
