// Given a 2D board and a list of words from the dictionary, find all words in the board.
//
// Each word must be constructed from letters of sequentially adjacent cell, where &quot;adjacent&quot; cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
// Example:
//
//
// Input: 
// words = [&quot;oath&quot;,&quot;pea&quot;,&quot;eat&quot;,&quot;rain&quot;] and board =
// [
//   [&#39;o&#39;,&#39;a&#39;,&#39;a&#39;,&#39;n&#39;],
//   [&#39;e&#39;,&#39;t&#39;,&#39;a&#39;,&#39;e&#39;],
//   [&#39;i&#39;,&#39;h&#39;,&#39;k&#39;,&#39;r&#39;],
//   [&#39;i&#39;,&#39;f&#39;,&#39;l&#39;,&#39;v&#39;]
// ]
//
// Output:&nbsp;[&quot;eat&quot;,&quot;oath&quot;]
//
//
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
//
//
// Hint:
//
//
// 	You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
// 	If the current candidate does not exist in all words&#39; prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
//
//
//


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board,i,j,root,res);
            }
        }
        return res;
    }
    
    class TrieNode{
        TrieNode [] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w: words){
            TrieNode p = root;
            for(char c: w.toCharArray()){
                if(p.next[c-'a']==null)
                    p.next[c-'a'] = new TrieNode();
                p = p.next[c-'a'];
            }
            p.word = w;
        }
        return root;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res){
        char c = board[i][j];
        if(c == '#' || p.next[c-'a'] == null) return;
        p = p.next[c-'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }
        
        board[i][j] = '#';
        if(i>0) dfs(board,i-1,j,p,res);
        if(j>0) dfs(board,i,j-1,p,res);
        if(i<board.length - 1) dfs(board,i+1,j,p,res);
        if(j<board[0].length - 1) dfs(board,i,j+1,p,res);
        board[i][j] = c;
    }
}
