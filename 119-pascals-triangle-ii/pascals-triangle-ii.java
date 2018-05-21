// Given a non-negative&nbsp;index k&nbsp;where k &le;&nbsp;33, return the kth&nbsp;index row of the Pascal&#39;s triangle.
//
// Note that the row index starts from&nbsp;0.
//
//
// In Pascal&#39;s triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
//
// Input: 3
// Output: [1,3,3,1]
//
//
// Follow up:
//
// Could you optimize your algorithm to use only O(k) extra space?
//


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<rowIndex+1;i++){
            list.add(1);
            for(int j=i-1;j>0;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }
        }
        return list;
    }
}
