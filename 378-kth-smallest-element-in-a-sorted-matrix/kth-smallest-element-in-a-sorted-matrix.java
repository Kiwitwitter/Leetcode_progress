// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//
// Example:
//
// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,
//
// return 13.
//
//
//
// Note: 
// You may assume k is always valid, 1 &le; k &le; n2.


public class Solution {
    /*
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    class Pair {
        public int x, y, val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }
     
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int[] dx = new int[]{1,0};
        int[] dy = new int[]{0,1};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        PriorityQueue<Pair> minheap = new PriorityQueue<Pair>(k,new PairComparator());
        minheap.add(new Pair(0,0,matrix[0][0]));
        
        for(int i=0;i<k-1;i++){
            Pair current = minheap.poll();
            for(int j=0;j<2;j++){
                int next_x = current.x + dx[j];
                int next_y = current.y + dy[j];
                Pair next_Pair = new Pair(next_x,next_y,0);
                if(next_x < n && next_y < m && !hash[next_x][next_y]){
                    hash[next_x][next_y] = true;
                    next_Pair.val = matrix[next_x][next_y];
                    minheap.add(next_Pair);
                }
            }
        }
        return minheap.peek().val;
    }
}
