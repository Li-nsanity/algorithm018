package Sort;

import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 18};
        //SelectionSort.selectionSort(nums);
        //InsertionSort.insertionSort(nums);
        //BubbleSort.bubbleSort(nums);
        //QuickSort.quickSort(nums, 0, nums.length - 1);
        //MergeSort.mergeSort(nums,0,14);
        HeapSort.heapSort(nums);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000000.0);
    }
}
