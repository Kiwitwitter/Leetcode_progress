// Given a string, we can &quot;shift&quot; each of its letter to its successive letter, for example: &quot;abc&quot; -&gt; &quot;bcd&quot;. We can keep &quot;shifting&quot; which forms the sequence:
//
//
// &quot;abc&quot; -&gt; &quot;bcd&quot; -&gt; ... -&gt; &quot;xyz&quot;
//
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
//
// Example:
//
//
// Input: [&quot;abc&quot;, &quot;bcd&quot;, &quot;acef&quot;, &quot;xyz&quot;, &quot;az&quot;, &quot;ba&quot;, &quot;a&quot;, &quot;z&quot;],
// Output: 
// [
//   [&quot;abc&quot;,&quot;bcd&quot;,&quot;xyz&quot;],
//   [&quot;az&quot;,&quot;ba&quot;],
//   [&quot;acef&quot;],
//   [&quot;a&quot;,&quot;z&quot;]
// ]
//
//


class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str:strings){
            int offset = str.charAt(0) - 'a';
            String key = "";
            for(int i = 0; i <str.length();i++){
                char c = (char)(str.charAt(i) - offset);
                if(c<'a')
                    c+= 26;
                key += c;
            }
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                map.put(key,list);
            }
            map.get(key).add(str);
        }
        
        for(String key:map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}
