// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
// Find all strobogrammatic numbers that are of length = n.
//
// Example:
//
//
// Input:  n = 2
// Output: [&quot;11&quot;,&quot;69&quot;,&quot;88&quot;,&quot;96&quot;]
//
//


class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> one  = Arrays.asList("0","1","8");
        List<String> two  = Arrays.asList("");
        List<String> r  = two;
        
        if(n%2 == 1){
            r = one;
        }
        
        if(n==1){
            return r;
        }
        
        for(int i = (n%2) + 2;i<=n;i+=2){
            List<String> newList = new ArrayList<>();
            for(String str:r){
                if(i!=n)
                    newList.add("0"+str+"0");
                newList.add("1"+str+"1");
                newList.add("6"+str+"9");
                newList.add("8"+str+"8");
                newList.add("9"+str+"6");
            }
            r = newList;
        }
        return r;
    }
}
