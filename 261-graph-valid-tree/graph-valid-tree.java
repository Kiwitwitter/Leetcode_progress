//
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//
//
// For example:
//
//
// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
//
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
//
//
// Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//


public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    class UnionFind{
        Map<Integer,Integer> father = new HashMap<Integer,Integer>();
        
        UnionFind(int n){
            for(int i=0;i<n;i++){
                father.put(i,i);
            }
        }
        int find(int x){
            int parent = father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
         void union(int a, int b){
             int root_a = find(a);
             int root_b = find(b);
             if(root_a != root_b){
                 father.put(root_a,root_b);
             }
         }
    }
    
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < edges.length; i++) {
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
