// Validate if a given string is numeric.
//
// Some examples:
// &quot;0&quot; =&gt; true
// &quot; 0.1 &quot; =&gt; true
// &quot;abc&quot; =&gt; false
// &quot;1 a&quot; =&gt; false
// &quot;2e10&quot; =&gt; true
//
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
//
// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
//


class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean point_seen = false;
        boolean e_seen= false;
        boolean number_seen = false;
        boolean number_after_e = true;
        for(int i = 0; i <s.length();i++){
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
                number_seen = true;
                number_after_e = true;
            }else if(s.charAt(i) == '.'){
                if(point_seen || e_seen){
                    return false;
                }
                point_seen = true;
            }else if(s.charAt(i) == 'e'){
                if(e_seen || !number_seen){
                    return false;
                }
                e_seen = true;
                number_after_e = false;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i!= 0 && s.charAt(i-1)!='e'){
                    return false;
                }
                
            }else{
                return false;
            }
        }
        return number_seen&&number_after_e;
    }
}
