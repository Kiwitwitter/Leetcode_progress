//
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//
//
// Note: Do not modify the linked list.
//
//
// Follow up:
// Can you solve it without using extra space?
//


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode findIntersect(ListNode head){
        ListNode fast,slow;
        fast = head;
        slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return slow;
        }
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode ptr1 = head;
        ListNode ptr2 = findIntersect(head);
        if(ptr2 == null)
            return null;
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
