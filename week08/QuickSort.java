package Sort;

public class QuickSort {
    public static void quickSort(int[] nums, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int partition(int[] nums, int begin, int end) {
        //pivot标杆位置，counter小于pivot的元素个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if(nums[i] < nums[pivot]){
                int temp = nums[counter];
                nums[counter] = nums[i];
                nums[i] = temp;
                counter++;
            }
            print(nums);
        }
        int temp = nums[counter];
        nums[counter] = nums[pivot];
        nums[pivot] = temp;
        print(nums);
        return counter;
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

