// Description:
// Count the number of prime numbers less than a non-negative number, n.
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


class Solution {
    public int countPrimes(int n) {
        boolean [] judge = new boolean[n];
        int count = 0;
        for(int i = 2;i<n;i++){
            if(judge[i] == false){
                count ++;
                for(int j = 2;i*j<n;j++){
                    judge[i*j] = true;
                }
            }
        }
        return count;
    }
}
