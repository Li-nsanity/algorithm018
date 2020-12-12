package Sort;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        int temp;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
            print(nums);
        }
    }

    private static void print(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("arr[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                sb.append(nums[i]);
            } else {
                sb.append(nums[i]);
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
