// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
//
//
// Therefore, return the max sliding window as [3,3,5,5,6,7].
//
// Note: 
// You may assume k is always valid, ie: 1 &le; k &le; input array's size for non-empty array.
//
// Follow up:
// Could you solve it in linear time?


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        if (nums.length == 0) {
            return toArray(ans);
        }
        
        for(int i = 0; i< k - 1; i++){
            inQue(deque, nums[i]);
        }
        
        for(int i = k-1; i < nums.length; i++){
            inQue(deque, nums[i]);
            ans.add(deque.peekFirst());
            outQue(deque, nums[i-k+1]);
        }
        return toArray(ans);
    }
    
    private void inQue(Deque<Integer> deque, int num){
        while(!deque.isEmpty() && deque.peekLast() < num){
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    private void outQue(Deque<Integer> deque, int num){
        if(deque.peekFirst() == num){
            deque.pollFirst();
        }
    }
    
    private int[] toArray(ArrayList<Integer> al){
        int size = al.size();
        if(size == 0){
            int [] ar = new int[0];
            return ar;
        }else{
            int [] ar = new int[size];
            int i = 0;
            for(Integer j: al){
                ar[i] = j.intValue();
                i++;
            }
            return ar;
        }
    }
    
}
