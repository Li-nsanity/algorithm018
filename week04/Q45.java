package Leetcode;
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 示例:
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。
// Related Topics 贪心算法 数组
// 👍 745 👎 0

public class Q45 {
    /**
     * 反向贪心
     * 最坏时间复杂度O(n²)
     * 超时
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int res = 0;
        int endReachable = nums.length - 1;
        while (endReachable > 0) {
            for (int i = 0; i < endReachable; i++) {
                if (nums[i] + i >= endReachable) {
                    endReachable = i;
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 正向贪心
     * 时间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
