package Sort;

public class SelectionSort {
    public static void selectionSort(int[] nums) {
        print(nums);
        int len = nums.length;
        int minIndex, temp;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
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
