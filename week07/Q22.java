package Leetcode;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1393 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    /**
     * 左括号随便加，只要不超标
     * 左括号个数大于右括号个数
     * 时间复杂度O(logn)指数级
     */
    public static List<String> res;

    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        recur(0, 0, n, "");
        return res;
    }

    private static void recur(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        //process current logic:left,right

        //drill down
        if (left < n) {
            recur(left + 1, right, n, s + "(");
        }
        if (left > right) {
            recur(left, right + 1, n, s + ")");
        }
        //reverse states

    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
