package Sort;

public class InsertionSort {
    public static void insertionSort(int[] nums) {
        int len = nums.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
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
