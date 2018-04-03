// You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
// Each 0 marks an empty land which you can pass by freely.
// Each 1 marks a building which you cannot pass through.
// Each 2 marks an obstacle which you cannot pass through.
//
//
// For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
//
// 1 - 0 - 2 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
//
// The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
//
// Note:
// There will be at least one building. If it is not possible to build such house according to the above rules, return -1.


class Solution {
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int [][] distance = new int[m][n];
        List<Tuple> buildings = new ArrayList<>();
        for(int i = 0; i<m;i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == 1){
                    buildings.add(new Tuple(i,j,0));
                }
                grid[i][j] = - grid[i][j];
            }
        }
        
        //BFS
        for(int i = 0; i<buildings.size();i++){
            bfs(buildings.get(i),i,distance,grid,m,n);
        }
        
        int ans = -1;
        for(int i = 0; i<m; i++){
            for(int j=0;j<n;j++){
                if (grid[i][j] == buildings.size() && (ans < 0 || distance[i][j] < ans)){
                    ans = distance[i][j];
                }
            }
        }
        return ans;
    }
    
    public void bfs(Tuple root, int k, int[][] distance, int[][]grid,int m,int n){
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Tuple r = queue.poll();
            distance[r.x][r.y] += r.dis;
            for(int i = 0; i<4;i++){
                int x = r.x + dx[i];
                int y = r.y + dy[i];
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==k){
                    grid[x][y] = k + 1;
                    queue.add(new Tuple(x,y,r.dis+1));
                }
            }
        }
    }
    
    class Tuple{
        public int x;
        public int y;
        public int dis;
        
        public Tuple(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
