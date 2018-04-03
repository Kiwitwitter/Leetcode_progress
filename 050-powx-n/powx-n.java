// Implement pow(x, n).
//
//
//
//
// Example 1:
//
// Input: 2.00000, 10
// Output: 1024.00000
//
//
//
// Example 2:
//
// Input: 2.10000, 3
// Output: 9.26100
//
//


 public class Solution {
        public double myPow(double x, int m) {
            double temp=x;
            if(m==0)
            return 1;
            temp=myPow(x,m/2);
            if(m%2==0)
            return temp*temp;
            else 
            {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }
          
    }
 }
