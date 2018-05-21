// Roman numerals are represented by seven different symbols:&nbsp;I, V, X, L, C, D and M.
//
//
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
//
// For example,&nbsp;two is written as II&nbsp;in Roman numeral, just two one&#39;s added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//
// 	I can be placed before V (5) and X (10) to make 4 and 9.&nbsp;
// 	X can be placed before L (50) and C (100) to make 40 and 90.&nbsp;
// 	C can be placed before D (500) and M (1000) to make 400 and 900.
//
//
// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
// Example 1:
//
//
// Input:&nbsp;3
// Output: &quot;III&quot;
//
// Example 2:
//
//
// Input:&nbsp;4
// Output: &quot;IV&quot;
//
// Example 3:
//
//
// Input:&nbsp;9
// Output: &quot;IX&quot;
//
// Example 4:
//
//
// Input:&nbsp;58
// Output: &quot;LVIII&quot;
// Explanation: C = 100, L = 50, XXX = 30 and III = 3.
//
//
// Example 5:
//
//
// Input:&nbsp;1994
// Output: &quot;MCMXCIV&quot;
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//


class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num>=1000){
            int g = num/1000;
            for(int i = 0; i<g; i++){
                sb.append("M");
            }
            num%=1000;
        }
        
        if(num>=100){
            if(num/100 == 9){
                sb.append("CM");
            }
            if(num/100>=5 && num/100<9){
                sb.append("D");
                int s = num - 500;
                int g = s/100;
                for(int i = 0; i<g; i++){
                    sb.append("C");
                }
            }
            if(num/100<5){
                if(num/100==4){
                    sb.append("CD");
                }else{
                    int g = num/100;
                    for(int i = 0; i<g; i++){
                        sb.append("C");
                    }
                }
            }
            num%=100;
        }
        
        if(num>=10){
            if(num/10 == 9){
                sb.append("XC");
            }
            if(num/10>=5 && num/10<9){
                sb.append("L");
                    int s = num - 50;
                    int g = s/10;
                    for(int i = 0; i<g; i++){
                        sb.append("X");
                    } 
            }
            if(num/10<5){
                if(num/10==4){
                    sb.append("XL");
                }else{
                int g = num/10;
                for(int i = 0; i<g; i++){
                    sb.append("X");
                }
                }
            }
            num%=10;
        }
        if(num>=1){
            if(num == 9){
                sb.append("IX");
            }
            if(num>=5 && num<9){
                
                    sb.append("V");
                    int s = num - 5;
                    int g = s;
                    for(int i = 0; i<g; i++){
                        sb.append("I");
                    }
                
            }
            if(num<5){
                if(num == 4){
                    sb.append("IV");
                }else{
                int g = num;
                for(int i = 0; i<g; i++){
                    sb.append("I");
                }
                }
            }
        }
        
        return sb.toString();
    }
}
