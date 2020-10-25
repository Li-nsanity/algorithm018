package Leetcode;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 772 👎 0


public class Q283 {
    /**
     * 数个数交换
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (count > 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /**
     * 通用双指针，快慢指针
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        //int[] nums = new int[]{0, 0, 1};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        moveZeroes2(nums);
        System.out.println("--------");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
