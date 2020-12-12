package Leetcode;
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
//
//
// 示例 1:
//
// 输入: [7,5,6,4]
//输出: 5
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
// 👍 283 👎 0

public class offer51 {
    /**
     * 暴力解法
     * O(n^2)
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * mergrSort
     * O(n^2)
     * @param nums
     * @return
     */
    public static int reversePairs2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return merge(nums, 0, nums.length - 1);
    }

    private static int merge(int[] nums, int start, int end) {
        if (start == end)
            return 0;
        int mid = start + (end - start) / 2;
        int count = merge(nums, start, mid) + merge(nums, mid + 1, end);

        int[] temp = new int[end - start + 1];  // 创建新的暂时数组
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            // count += nums[i] <= nums[j] ? j - (mid + 1) : 0;
            // 当i指向的左区间中的数小于等于j指向的右区间的数时，不做处理
            // 当大于时，表示左区间i及i之后的数都将大于j指向的数，所以出现了mid+1-i个逆序对
            count += nums[i] <= nums[j] ? 0 : mid + 1 - i;
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        // mid + 1 - i：相当于对于右区间的每个数字a，找左区间中比a大的有多少，所以如果左区间有剩余，直接复制到暂时数组的后面
        // mid + 1 - i：如果右区间有剩余，表示右区间剩下的数都是比左区间数大的，此时不存在逆序，只需要复制到暂时数组的后面
        // j - (mid + 1)：相当于对于左区间的每个数字b，找右区间中比b小的有多少，所以如果右区间有剩余，直接复制到暂时数组的后面
        // j - (mid + 1)：如果左区间有剩余，表示左区间剩下的数都是比右区间数大的，所以需要在每次放入暂时数组时，加上右区间长度
        while (i <= mid) {
            // count += j - (mid + 1);
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, end - start + 1); // 将暂时数组的内容复制到原数组
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(reversePairs(nums));
    }
}
