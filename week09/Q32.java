package Leetcode;
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划
// 👍 1108 👎 0

public class Q32 {
    /**
     * DP
     * 时间复杂度： O(n)，其中 n 为字符串的长度。我们只需遍历整个字符串一次，即可将 dp 数组求出来。
     * 空间复杂度： O(n)。我们需要一个大小为 n 的 dp 数组。
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
