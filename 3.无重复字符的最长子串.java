/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (30.09%)
 * Likes:    1973
 * Dislikes: 0
 * Total Accepted:    145.4K
 * Total Submissions: 483.1K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        //dp[i]表示到第i个字符为止的最长字串长度
        //下标从零开始
        /**
         * 判断第i个字符上一次出现的位置：
         * 1.第i个字符之前没有出现过，则dp[i]=dp[i-1]+1;
         * 2.第i个字符之前出现过，出现位置为j(j<i)
         * 3.若i-j>dp[i-1],说明dp[i-1]中不包括第i个字符，则dp[i]=dp[i-1]+1
         * 4.若i-j<dp[i-1],则dp[i]=dp[i-1]
         * 5.初始值dp[0] = 1
         * 哎，好像不需要要动态规划
         */
        int head = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j = head;j<i;j++){
                if(s.charAt(j)==c){
                    head = j+1;
                }
            }
            if(i+1-head>count){
                count = i+1-head;
            }
        }
        return count;
    }
}

