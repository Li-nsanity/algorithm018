package Leetcode;
//编写一个程序，找出第 n 个丑数。
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划
// 👍 417 👎 0

import java.util.HashSet;
import java.util.PriorityQueue;

public class Q264 {
    /**
     * 堆优化
     * 时间复杂度：n*堆的高度log（n）=nlog(n),空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        int[] factors = new int[]{2, 3, 5};
        long currUgly = 1, newUgly;
        for (int i = 0; i < n; i++) {
            currUgly = heap.poll();
            for (int item : factors) {
                newUgly = currUgly * item;
                if (!set.contains(newUgly)) {
                    set.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
        return (int) currUgly;
    }

    /**
     * 动态规划（还不太熟悉），等学完之后补充
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber2(int n) {
        return 0;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

}
