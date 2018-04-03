// Given a singly linked list, determine if it is a palindrome.
//
// Follow up:
// Could you do it in O(n) time and O(1) space?


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
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode p1 = head, p2 = middle.next;
        while(p1 != null && p2 != null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }
    
    public ListNode findMiddle(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        
        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
