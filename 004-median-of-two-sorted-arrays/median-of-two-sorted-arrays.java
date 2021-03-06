// There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
// Example 1:
//
// nums1 = [1, 3]
// nums2 = [2]
//
// The median is 2.0
//
//
//
// Example 2:
//
// nums1 = [1, 2]
// nums2 = [3, 4]
//
// The median is (2 + 3)/2 = 2.5
//
//


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int length = nums1.length + nums2.length;
        int cutL = 0;
        int cutR = nums1.length - 1;
        int cut1 = 0;
        int cut2 = 0;
        while(cut1<=nums1.length){
            cut1 = cutL + (cutR - cutL)/2;
            cut2 = length/2 - cut1;
            double L1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            double L2 = (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
            double R1 = (cut1==nums1.length)?Integer.MAX_VALUE:nums1[cut1];
            double R2 = (cut2==nums2.length)?Integer.MAX_VALUE:nums2[cut2];
            if(L1>R2){
                cutR = cut1 - 1;
            }else if(L2>R1){
                cutL = cut1 + 1;
            }else{
                if(length%2 == 0){
                    return (Math.max(L1,L2)+Math.min(R1,R2))/2;
                }else{
                    return Math.min(R1,R2);
                }
            }
        }
        return -1;
        
    }
}
