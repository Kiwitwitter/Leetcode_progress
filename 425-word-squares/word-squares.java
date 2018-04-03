// Given a set of words (without duplicates), find all word squares you can build from them.
//
// A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 &le; k &lt; max(numRows, numColumns).
//
// For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
//
//
// b a l l
// a r e a
// l e a d
// l a d y
//
//
// Note:
//
// There are at least 1 and at most 1000 words.
// All words will have the exact same length.
// Word length is at least 1 and at most 5.
// Each word contains only lowercase English alphabet a-z.
//
//
//
// Example 1:
//
// Input:
// ["area","lead","wall","lady","ball"]
//
// Output:
// [
//   [ "wall",
//     "area",
//     "lead",
//     "lady"
//   ],
//   [ "ball",
//     "area",
//     "lead",
//     "lady"
//   ]
// ]
//
// Explanation:
// The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
//
//
//
// Example 2:
//
// Input:
// ["abat","baba","atan","atal"]
//
// Output:
// [
//   [ "baba",
//     "abat",
//     "baba",
//     "atan"
//   ],
//   [ "baba",
//     "abat",
//     "baba",
//     "atal"
//   ]
// ]
//
// Explanation:
// The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
//
//


class Solution {
    
    class TrieNode{
        List<String> startWith;
        TrieNode[] children;
        
        TrieNode(){
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    class Trie{
        TrieNode root;
        
        Trie(String [] words){
            root = new TrieNode();
            for(String w: words){
                TrieNode cur = root;
                for(char c: w.toCharArray()){
                    if(cur.children[c-'a']== null){
                        cur.children[c-'a'] = new TrieNode();
                    }
                    cur.children[c-'a'].startWith.add(w);
                    cur = cur.children[c-'a'];
                }
            }
        }
        
        List<String> findByPrefix(String pre){
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for(char c: pre.toCharArray()){
                if(cur.children[c-'a'] == null){
                    return ans;
                }
                cur = cur.children[c-'a'];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        for(String w: words){
            ansBuilder.add(w);
            search(len, trie, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size()-1);
        }
        return ans;
    }
    
    private void search(int len, Trie tr, List<List<String>> ans, List<String> ansBuilder){
        if (ansBuilder.size() == len) {
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }
        int idx = ansBuilder.size();
        StringBuilder sb = new StringBuilder();
        for(String s: ansBuilder){
            sb.append(s.charAt(idx));
        }
        List<String> startWith = tr.findByPrefix(sb.toString());
        for(String sw: startWith){
            ansBuilder.add(sw);
            search(len, tr, ans, ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }
    }
                    

        
    
}
