// Write a function to find the longest common prefix string amongst an array of strings.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for(int i=0; i<strs.length; i++){
            while(strs[i].indexOf(pre)!=0){
                pre = pre.substring(0, pre.length() - 1);
                if(pre.length() == 0) return "";
            }
        }
        return pre;
    }
}
