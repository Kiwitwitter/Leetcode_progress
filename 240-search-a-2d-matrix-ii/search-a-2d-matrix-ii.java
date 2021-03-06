// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//
// 	Integers in each row are sorted in ascending from left to right.
// 	Integers in each column are sorted in ascending from top to bottom.
//
//
// Consider the following matrix:
//
//
// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]
//
//
// Example 1:
//
//
// Input: matrix, target = 5
// Output: true
//
//
// Example 2:
//
//
// Input: matrix, target = 20
// Output: false
//
//


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while(col>=0 && row <= matrix.length-1){
            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][col]){
                row++;
            }else if(target < matrix[row][col]){
                col--;
            }
        }
        return false;
    }
}
