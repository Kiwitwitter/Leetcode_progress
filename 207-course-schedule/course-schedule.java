// There are a total of n courses you have to take, labeled from 0 to n-1.
//
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
// Example 1:
//
//
// Input: 2, [[1,0]] 
// Output: true
// Explanation:&nbsp;There are a total of 2 courses to take. 
// &nbsp;            To take course 1 you should have finished course 0. So it is possible.
//
// Example 2:
//
//
// Input: 2, [[1,0],[0,1]]
// Output: false
// Explanation:&nbsp;There are a total of 2 courses to take. 
// &nbsp;            To take course 1 you should have finished course 0, and to take course 0 you should
// &nbsp;            also have finished course 1. So it is impossible.
//
//
// Note:
//
//
// 	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// 	You may assume that there are no duplicate edges in the input prerequisites.
//
//
// &nbsp;Hints:
//
//
// 	This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
// 	Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
// 	Topological sort could also be done via BFS.
//
//


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
    int[] indegree = new int[numCourses];
    
    for (int i=0; i<prerequisites.length; i++) {
        int ready = prerequisites[i][0];
        int pre = prerequisites[i][1];
        if (matrix[pre][ready] == 0)
            indegree[ready]++; //duplicate case
        matrix[pre][ready] = 1;
    }
    
    int count = 0;
    Queue<Integer> queue = new LinkedList();
    for (int i=0; i<indegree.length; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }
    while (!queue.isEmpty()) {
        int course = queue.poll();
        count++;
        for (int i=0; i<numCourses; i++) {
            if (matrix[course][i] != 0) {
                if (--indegree[i] == 0)
                    queue.offer(i);
            }
        }
    }
    return count == numCourses;
    }
}
