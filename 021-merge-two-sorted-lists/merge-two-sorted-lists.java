// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
//
// Example:
//
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }else if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode head = null;
        if(l1.val<l2.val){
           head = l1;
           l1 = l1.next;
       }else{
           head = l2;
           l2 = l2.next;
       }
       ListNode temp = head;
       while(l1!=null || l2!=null){
           if(l1==null){
               temp.next = l2;
               l2 = null;
               break;
           }else if(l2==null){
               temp.next = l1;
               l1 = null;
               break;
           }
           if(l1.val<l2.val){
               temp.next = l1;
               l1 = l1.next;
               temp = temp.next;
           }else{
               temp.next = l2;
               l2 = l2.next;
               temp = temp.next;
           }
       }
        return head;
    }
}
