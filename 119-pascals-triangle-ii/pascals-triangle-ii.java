// Given an index k, return the kth row of the Pascal's triangle.
//
//
// For example, given k = 3,
// Return [1,3,3,1].
//
//
//
// Note:
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
