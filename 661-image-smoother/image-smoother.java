// Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.  If a cell has less than 8 surrounding cells, then use as many as you can.
//
// Example 1:
//
// Input:
// [[1,1,1],
//  [1,0,1],
//  [1,1,1]]
// Output:
// [[0, 0, 0],
//  [0, 0, 0],
//  [0, 0, 0]]
// Explanation:
// For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
// For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
// For the point (1,1): floor(8/9) = floor(0.88888889) = 0
//
//
//
// Note:
//
// The value in the given matrix is in the range of [0, 255].
// The length and width of the given matrix are in the range of [1, 150].
//
//


class Solution {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length;
        int C = M[0].length;
        int[][] ans = new int[R][C];
        
        for(int r = 0; r<R;r++){
            for(int c = 0; c<C; c++){
                int count = 0;
                for(int cr = r-1; cr <= r+1; cr++){
                    for(int cc = c-1; cc<=c+1; cc++){
                        if(cc>=0 && cr>=0 && cr<R && cc<C){
                            ans[r][c] += M[cr][cc];
                            count++;
                        }
                    }
                }
                ans[r][c] /= count;
            }
        }
        return ans;
    }
}
