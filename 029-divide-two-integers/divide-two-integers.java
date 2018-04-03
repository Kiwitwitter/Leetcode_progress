//
// Divide two integers without using multiplication, division and mod operator.
//
//
// If it is overflow, return MAX_INT.
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
