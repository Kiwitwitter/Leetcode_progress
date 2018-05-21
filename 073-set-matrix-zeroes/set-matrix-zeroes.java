// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//
// Example 1:
//
//
// Input: 
// [
// &nbsp; [1,1,1],
// &nbsp; [1,0,1],
// &nbsp; [1,1,1]
// ]
// Output: 
// [
// &nbsp; [1,0,1],
// &nbsp; [0,0,0],
// &nbsp; [1,0,1]
// ]
//
//
// Example 2:
//
//
// Input: 
// [
// &nbsp; [0,1,2,0],
// &nbsp; [3,4,5,2],
// &nbsp; [1,3,1,5]
// ]
// Output: 
// [
// &nbsp; [0,0,0,0],
// &nbsp; [0,4,5,0],
// &nbsp; [0,3,1,0]
// ]
//
//
// Follow up:
//
//
// 	A straight forward solution using O(mn) space is probably a bad idea.
// 	A simple improvement uses O(m + n) space, but still not the best solution.
// 	Could you devise a constant space solution?
//
//


public class Solution {
    public void setZeroes(int[][] matrix) {
       if(matrix == null || matrix[0].length == 0){
           return;
       }
        boolean em_r = false;
        boolean em_c = false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            if(matrix[0][i]==0){
                em_c = true;
                break;
            }
        }
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0]==0){
                em_r = true;
                break;
            }
        }
        
        for(int i = 1; i< m; i++){
            for(int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i< m; i++){
            for(int j = 1;j < n;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(em_r){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(em_c){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
