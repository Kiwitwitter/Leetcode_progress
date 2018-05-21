//
// Given a non-empty array of integers, return the k most frequent elements.
//
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//
// Note: 
//
// You may assume k is always valid, 1 &le; k &le; number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) { result.add(pq.poll().num); }
        return result;
    }
    
    class Pair implements Comparable<Pair>{
        public int num;
        public int count;
        
        public Pair (int num, int count) {
            this.num = num;
            this.count = count;
        }
        
        @Override
        public int compareTo(Pair other) {
            return new Integer(other.count).compareTo(new Integer(this.count));
        }
    }
}
