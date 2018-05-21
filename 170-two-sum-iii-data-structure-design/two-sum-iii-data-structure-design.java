// Design and implement a TwoSum class. It should support the following operations: add and find.
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
//
// Example 1:
//
//
// add(1); add(3); add(5);
// find(4) -&gt; true
// find(7) -&gt; false
//
//
// Example 2:
//
//
// add(3); add(1); add(2);
// find(3) -&gt; true
// find(6) -&gt; false
//


class TwoSum {
    Map<Integer,Integer> map = null;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number,map.getOrDefault(number,0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key:map.keySet()){
            if(map.containsKey(value - key))
                if(value-key == key){
                    if(map.get(value - key) >1)
                        return true;
                    else{
                        continue;
                    }
                }else{
                    return true;
                }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
