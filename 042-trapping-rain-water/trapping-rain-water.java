// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
// Example:
//
//
// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6


class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        if(left>=right){
            return res;
        }
        int leftheight = height[left];
        int rightheight = height[right];
        while(left<right){
            if(leftheight<rightheight){
                left++;
                if(leftheight>height[left]){
                    res+=leftheight-height[left];
                }else{
                    leftheight = height[left];
                }
            }else{
                right--;
                if(rightheight>height[right]){
                    res+=rightheight-height[right];
                }else{
                    rightheight = height[right];
                }
            }
        }
        return res;
    }
}
