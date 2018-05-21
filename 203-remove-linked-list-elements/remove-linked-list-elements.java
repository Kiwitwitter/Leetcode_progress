// Remove all elements from a linked list of integers that have value val.
//
// Example:
//
//
// Input:  1-&gt;2-&gt;6-&gt;3-&gt;4-&gt;5-&gt;6, val = 6
// Output: 1-&gt;2-&gt;3-&gt;4-&gt;5
//
// Credits:
// Special thanks to @mithmatt&nbsp;for adding this problem and creating all test cases.
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(0);
        ListNode ptr1 = head;
        ListNode ptr2 = dum;
        dum.next = head;
        while(ptr1!=null){
            if(ptr1.val == val){
                ptr2.next  = ptr1.next;
            }else{
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
        return dum.next;
    }
}
