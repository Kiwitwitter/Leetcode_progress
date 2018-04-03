// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
// 11110110101100000000
// Answer: 1
// Example 2:
// 11000110000010000011
// Answer: 3
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int x_len;
        int y_len;
        if(grid == null||grid.length == 0||grid[0].length == 0){
            return 0;
        }else{
            x_len = grid.length;
            y_len = grid[0].length;
            for(int x = 0;x<x_len;x++){
                for(int y = 0;y<y_len;y++){
                    if(grid[x][y] == '1'){
                        islandCount(grid,x,y);
                        count++;
                    }
                }
            }
        return count;
        }
        
    }
    
    public void islandCount(char[][] grid,int x,int y){
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] != '1'){
            return;
        }else{
            grid[x][y] = '0';
            islandCount(grid,x+1,y);
            islandCount(grid,x-1,y);
            islandCount(grid,x,y+1);
            islandCount(grid,x,y-1);
        }
    }
    
}
