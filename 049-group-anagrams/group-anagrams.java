// Given an array of strings, group anagrams together.
//
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:
//
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note: All inputs will be in lower-case.


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
