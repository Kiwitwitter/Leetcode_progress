// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
// Example:
//
//
// Input:
// [
// &nbsp; 1-&gt;4-&gt;5,
// &nbsp; 1-&gt;3-&gt;4,
// &nbsp; 2-&gt;6
// ]
// Output: 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
       PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dum = new ListNode(0);
        ListNode tail = dum;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dum.next;
        
    }
}
