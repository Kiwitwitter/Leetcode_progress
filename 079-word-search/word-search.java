// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where &quot;adjacent&quot; cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// Example:
//
//
// board =
// [
//   [&#39;A&#39;,&#39;B&#39;,&#39;C&#39;,&#39;E&#39;],
//   [&#39;S&#39;,&#39;F&#39;,&#39;C&#39;,&#39;S&#39;],
//   [&#39;A&#39;,&#39;D&#39;,&#39;E&#39;,&#39;E&#39;]
// ]
//
// Given word = &quot;ABCCED&quot;, return true.
// Given word = &quot;SEE&quot;, return true.
// Given word = &quot;ABCB&quot;, return false.
//
//


class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean rst = find(board, i, j, word, 0);
                    if(rst)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, int i, int j, String word, int start){
        if(start == word.length())
            return true;
        if (i < 0 || i>= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)){
            return false;
        }
        board[i][j] = '#'; // should remember to mark it
        boolean rst = find(board, i-1, j, word, start+1) || find(board, i, j-1, word, start+1) || find(board, i+1, j, word, start+1) || find(board, i, j+1, word, start+1);
        board[i][j] = word.charAt(start);
        return rst;
    }
}
