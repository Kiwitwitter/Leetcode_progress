// Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
//
// Return the quotient after dividing dividend by divisor.
//
// The integer division should truncate toward zero.
//
// Example 1:
//
//
// Input: dividend = 10, divisor = 3
// Output: 3
//
// Example 2:
//
//
// Input: dividend = 7, divisor = -3
// Output: -2
//
// Note:
//
//
// 	Both dividend and divisor&nbsp;will be&nbsp;32-bit&nbsp;signed integers.
// 	The divisor will never be 0.
// 	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [&minus;231, &nbsp;231 &minus; 1]. For the purpose of this problem, assume that your function returns 231 &minus; 1 when the division result&nbsp;overflows.
//
//


class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend>0 && divisor<0)||(dividend<0&&divisor>0))
            sign = -1;
        if(divisor==0)
            return Integer.MAX_VALUE;
        long first = Math.abs((long) dividend);
        long second = Math.abs((long) divisor);
        long ans = evaluate(first,second);
        if(ans>Integer.MAX_VALUE){
            return sign == 1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }else{
            return (int)(sign*ans);
        }
    }

    private long evaluate(long dividend, long divisor){
        if(dividend < divisor)
            return 0;
        long count = 1;
        long acumulate = divisor;
        while(acumulate <= dividend){
            count *=2;
            acumulate *=2;
        }
        long val = acumulate/2;
        return count/2 + evaluate(dividend - val,divisor);
    }
}
