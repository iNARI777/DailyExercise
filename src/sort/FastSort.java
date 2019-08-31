package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序算法
 */

public class FastSort {

    private void fastSort(int nums[], int left, int right) {
        if (left >= right) return;
        int mid = subSort(nums, left, right);
        fastSort(nums, left, mid - 1);
        fastSort(nums, mid + 1, right);
    }

    private int subSort(int[] nums, int left, int right) {
        while (left < right) {
            while (left < right && nums[left] <= nums[right]) right--;
            exchange(nums, left, right);
            while (left < right && nums[left] <= nums[right]) left++;
            exchange(nums, left, right);
        }
        return left;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        int[] nums = new int[20];
//        for (int i = 0; i < 20; i++) {
//            nums[i] = random.nextInt(100);
//        }

        int[] nums = {18, 69, 69, 25, 72, 71, 23, 15, 59, 22, 79, 88, 9, 33, 36, 39, 5, 41, 28, 3};
        System.out.println(Arrays.toString(nums));
        new FastSort().fastSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
