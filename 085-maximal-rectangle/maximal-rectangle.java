// Given a 2D binary matrix filled with 0&#39;s and 1&#39;s, find the largest rectangle containing only 1&#39;s and return its area.
//
// Example:
//
//
// Input:
// [
//   [&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;],
//   [&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;],
//   [&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;],
//   [&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;]
// ]
// Output: 6
//
//


class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = findMax(height);
        for(int i = 1; i < matrix.length; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, findMax(height));
        }
        return result;
    }
    
    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }
    
    public int findMax(int [] height){
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(stack.isEmpty() || h >= height[stack.peek()]){
                stack.push(i);
            }else{
                int tp = stack.pop();
                maxArea = Math.max(maxArea, height[tp]*(stack.isEmpty()?i:i-1-stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
