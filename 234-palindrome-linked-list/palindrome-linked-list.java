// Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
//
// Input: 1-&gt;2
// Output: false
//
// Example 2:
//
//
// Input: 1-&gt;2-&gt;2-&gt;1
// Output: true
//
// Follow up:
// Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode p1 = head;
        ListNode p2 = middle.next;
        while(p1!=null && p2!=null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
    
    private ListNode findMiddle(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
