// Given a 2d grid map of &#39;1&#39;s (land) and &#39;0&#39;s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
// Input:
// 11110
// 11010
// 11000
// 00000
//
// Output:&nbsp;1
//
//
// Example 2:
//
//
// Input:
// 11000
// 11000
// 00100
// 00011
//
// Output: 3
//
//


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
