package basic.exercise02;

/**
 * leetcode05题
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *      输入：s = "babad"
 *      输出："bab"
 *      解释："aba" 同样是符合题意的答案。
 * @author zhaoqw
 * @date 2022/8/16
 */
public class LeetCode05 {
    /**
     * 0(n^3)
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if(s == null) {
            return null;
        }

        for(int length = s.length(); length > 0; length--) {
            for(int start = 0; length + s.length() <= s.length(); start++) {
                if (isPalindrome(s, start, start + length - 1)) {
                    return s.substring(start, start + length);
                }
            }
        }
        return "";
    }
    private boolean isPalindrome(String str, int left, int right) {
        while(left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}
