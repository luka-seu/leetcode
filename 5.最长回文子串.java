

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.59%)
 * Likes:    975
 * Dislikes: 0
 * Total Accepted:    70.1K
 * Total Submissions: 273.8K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        //中心拓展法
        //每一个字符都可能成为回文字符串的中心轴，这里包括单轴，双轴左和双轴右
        //双轴左和双轴右一样，故只考虑双轴左
        int left = 0;
        int right = 0;
        for(int i = 0;i<s.length();i++){
           
            int single = midExpansion(s,i,i);
            int doubleleft = midExpansion(s,i,i+1);
            int m = Math.max(single, doubleleft);
            if(m>right-left){
                //m表示字符串长度，更新左右指针的位置
                left = i-(m-1)/2;
                right = i+m/2;
            }
        }
        return s.substring(left, right+1);
    }
    public int midExpansion(String str,int left,int right){
        while(left>=0&&right<str.length()&&str.charAt(left)==str.charAt(right)){
            left--;
            right++;
        }
        //右指针指向回文子串最后一个字符后一个字符，左指针指向回文子串第一个字符前一个字符，故应该是+1-2
        return right-left-1;

    }
}

