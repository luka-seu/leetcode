import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.25%)
 * Likes:    1188
 * Dislikes: 0
 * Total Accepted:    63.5K
 * Total Submissions: 180K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //List拼装
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        int size = list.size();
        if(size==0){
            return 0;
        }
        if(size%2!=0){
            return list.get(size/2);
        }else{
            return (double)(list.get(size/2-1)+list.get(size/2))/2;
        }
    }
}

