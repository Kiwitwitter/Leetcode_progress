// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
// Example
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode l3 = l;
        int carry = 0;
        int result = 0;
        int l1val = 0;
        int l2val = 0;
        ListNode l1next = null;
        ListNode l2next = null;
        while(l1 != null || l2 != null){
            if(l1==null){
                l1val=0;
                l1next = null;
            }else{
                l1val=l1.val;
                l1next = l1.next;
            }
            if(l2==null){
                l2val=0;
                l2next = null;
            }else{
                l2val=l2.val;
                l2next = l2.next;
            }
            if(l1val+l2val+carry>=10){
                result = (l1val+l2val+carry)%10;
                carry = 1;
            }else{
                result = l1val+l2val+carry;
                carry = 0;
            }
            ListNode new_l = new ListNode(result);
            l.next = new_l;
            l = new_l;
            l1 = l1next;
            l2 = l2next;
        }
        if (carry == 1){
            ListNode new_l = new ListNode(carry);
            l.next = new_l;
            l = new_l;
        }
        return l3.next;
    }
}
