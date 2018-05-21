//
// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//
//
// Return a deep copy of the list.
//


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dum = new  RandomListNode(0);
        RandomListNode pre = dum,newNode;
        
        while(head != null){
            if(map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head,newNode);
            }
            pre.next = newNode;
            
            if (head.random != null) {
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random,newNode.random);
                }
            }
            pre = newNode;
            head = head.next;
        }
        return dum.next;
    }
}
