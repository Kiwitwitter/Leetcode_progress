// Given an array of strings, group anagrams together.
//
// Example:
//
//
// Input: [&quot;eat&quot;, &quot;tea&quot;, &quot;tan&quot;, &quot;ate&quot;, &quot;nat&quot;, &quot;bat&quot;],
// Output:
// [
//   [&quot;ate&quot;,&quot;eat&quot;,&quot;tea&quot;],
//   [&quot;nat&quot;,&quot;tan&quot;],
//   [&quot;bat&quot;]
// ]
//
// Note:
//
//
// 	All inputs will be in lowercase.
// 	The order of your output does not&nbsp;matter.
//
//


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for(String i:strs){
            char [] ca = i.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(i);
        }
        return new ArrayList(map.values());
    }
}
